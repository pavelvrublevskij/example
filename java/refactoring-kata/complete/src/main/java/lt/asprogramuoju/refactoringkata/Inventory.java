package lt.asprogramuoju.refactoringkata;

import lt.asprogramuoju.refactoringkata.domain.Item;
import org.springframework.stereotype.Service;

@Service
public class Inventory {
    Item[] items;
    private static String FMPRO_4 = "FM-Pro4";
    private static String FMTCO4LCV= "FM-Tco4 LCV";
    private static String FUELLVLSENSOR = "Fuel level sensor";

    public Inventory(){}
    public Inventory(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].getName().equals(FMPRO_4)
                    && !items[i].getName().equals(FMTCO4LCV)) {
                if (!items[i].getName().equals(FUELLVLSENSOR))
                    items[i].setQuality(items[i].getQuality() - 1);
            } else {
                if (items[i].getName().equals(FMPRO_4))
                    items[i].setQuality(items[i].getQuality() + 1);
            }

            if (!items[i].getName().equals(FUELLVLSENSOR))
                items[i].setSellIn(items[i].getSellIn() - 1);

            if (items[i].getName().equals(FMTCO4LCV)) {
                if (items[i].getSellIn() < 6)
                    items[i].setQuality(items[i].getQuality() + 3);
                else if (items[i].getSellIn() < 11)
                    items[i].setQuality(items[i].getQuality() + 2);
                else
                    items[i].setQuality(items[i].getQuality() - 1);
            }

            if (items[i].getSellIn() < 0) {
                if (!items[i].getName().equals(FMPRO_4)) {
                    if (!items[i].getName().equals(FMTCO4LCV)) {
                        if (!items[i].getName().equals(FUELLVLSENSOR))
                            items[i].setQuality(items[i].getQuality() - 2);
                    } else
                        items[i].setQuality(0);
                } else
                    items[i].setQuality(items[i].getQuality() + 1);
            }
        }
    }
}
