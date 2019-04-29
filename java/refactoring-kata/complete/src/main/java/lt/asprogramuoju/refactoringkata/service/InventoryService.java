package lt.asprogramuoju.refactoringkata.service;

import lombok.Getter;
import lt.asprogramuoju.refactoringkata.domain.Item;
import lt.asprogramuoju.refactoringkata.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Getter
public class InventoryService {

    private Item[] items;

    @Autowired
    ItemRepository itemRepository;

    private static final String FMPRO_4 = "FM-Pro4";
    private static final String FMTCO4LCV = "FM-Tco4 LCV";
    private static final String FUELLVLSENSOR = "Fuel level sensor";

    public void setItems(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        List<Item> listOfItems = itemRepository.findAll();
        items = listOfItems.toArray(new Item[listOfItems.size()]);

        for (Item item : items)
            update(item);

        listOfItems = Arrays.asList(items);
        itemRepository.saveAll(listOfItems);
    }

    //TODO: need rewrite existing tests by update method
    private void update(Item item) {
        if (!item.getName().equals(FMPRO_4) && !item.getName().equals(FMTCO4LCV) && !item.getName().equals(FUELLVLSENSOR))
            this.setQuality(item, -1);

        if (item.getName().equals(FMPRO_4))
            this.setQuality(item, 1);

        if (!item.getName().equals(FUELLVLSENSOR))
            item.setSellIn(item.getSellIn() - 1);

        if (item.getName().equals(FMTCO4LCV)) {
            if (item.getSellIn() < 6)
                this.setQuality(item, 3);
            else if (item.getSellIn() < 11)
                this.setQuality(item, 2);
            else
                setQuality(item, -1);
        }

        doUpdateQualityWhenDayPast(item);
    }

    private void setQuality(Item item, int count) {
        item.setQuality(item.getQuality() + count);
    }

    private void doUpdateQualityWhenDayPast(Item item) {
        if (item.getSellIn() < 0) {
            if (!item.getName().equals(FMPRO_4)) {
                if (!item.getName().equals(FMTCO4LCV)) {
                    if (!item.getName().equals(FUELLVLSENSOR))
                        this.setQuality(item, -2);
                } else
                    item.setQuality(0);
            }
        }
    }
}
