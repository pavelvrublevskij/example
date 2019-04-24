package lt.asprogramuoju.refactoringkata;

import lt.asprogramuoju.refactoringkata.domain.Item;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class Inventory {
    Item[] items;
    private static final String FMPRO_4 = "FM-Pro4";
    private static final String FMTCO4LCV = "FM-Tco4 LCV";
    private static final String FUELLVLSENSOR = "Fuel level sensor";

    public Inventory() {
    }

    public Inventory(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.getName().equals(FMPRO_4) && !item.getName().equals(FMTCO4LCV) && !item.getName().equals(FUELLVLSENSOR))
                item.setQuality(item.getQuality() - 1);

            if (item.getName().equals(FMPRO_4))
                item.setQuality(item.getQuality() + 1);

            if (!item.getName().equals(FUELLVLSENSOR))
                item.setSellIn(item.getSellIn() - 1);

            if (item.getName().equals(FMTCO4LCV)) {
                if (item.getSellIn() < 6)
                    item.setQuality(item.getQuality() + 3);
                else if (item.getSellIn() < 11)
                    item.setQuality(item.getQuality() + 2);
                else
                    item.setQuality(item.getQuality() - 1);
            }

            if (item.getSellIn() < 0) {
                if (!item.getName().equals(FMPRO_4)) {
                    if (!item.getName().equals(FMTCO4LCV)) {
                        if (!item.getName().equals(FUELLVLSENSOR))
                            item.setQuality(item.getQuality() - 2);
                    } else
                        item.setQuality(0);
                }
            }
        }
    }
}
