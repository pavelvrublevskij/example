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

    private List<Item> items;

    @Autowired
    ItemRepository itemRepository;

    private static final String FMPRO_4 = "FM-Pro4";
    private static final String FMTCO4LCV = "FM-Tco4 LCV";
    private static final String FUELLVLSENSOR = "Fuel level sensor";

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void update() {
        List<Item> items = itemRepository.findAll();
        updateQuality(items);
        itemRepository.saveAll(items);
    }

    public void updateQuality(List<Item> items) {
        String[] values = {FMPRO_4, FMTCO4LCV, FUELLVLSENSOR};

        for (Item item : items) {
            if (Arrays.stream(values).noneMatch(item.getName()::equals))
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
