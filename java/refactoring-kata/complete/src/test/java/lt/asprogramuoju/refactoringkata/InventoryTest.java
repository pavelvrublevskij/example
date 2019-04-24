package lt.asprogramuoju.refactoringkata;

import static org.junit.Assert.*;

import lt.asprogramuoju.refactoringkata.domain.Item;
import org.junit.Test;

public class InventoryTest {

    /***
     * Once the sell by date has passed, Quality degrades twice as fast
     * * The Quality of an item is never negative
     * * "FM-Pro4" actually increases in Quality the older it gets
     * * The Quality of an item is never more than 50
     * * "Fuel level sensor", being a legendary item, never has to be sold or decreases in Quality
     * * "FM-Tco4 LCV" increases in Quality as it's SellIn value approaches: Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but Quality drops to 0 after the sell by date has passed
     */

    @Test
    public void the_sell_by_date_has_passed_quality_degrades_twice() {
        Item[] items = new Item[]{new Item("some item", 2, 43)};
        Inventory app = new Inventory(items);
        app.updateQuality();
        assertEquals(1, app.items[0].getSellIn());
        assertEquals(42, app.items[0].getQuality());
        app.updateQuality();
        app.updateQuality();
        assertEquals(38, app.items[0].getQuality());
    }

    @Test
    public void the_quality_of_item_should_be_positive() {
        Item[] items = new Item[]{
                new Item("some item 2", 5, 1),
                new Item("some item 3", 5, 0)
        };
        Inventory app = new Inventory(items);
        app.updateQuality();
        assertEquals(0, app.items[0].getQuality());
        assertEquals(0, app.items[1].getQuality());
    }

    @Test
    public void quality_of_an_item_should_be_never_more_than_50() {
        Item[] items = new Item[]{
                new Item("some item", 3, 346345),
                new Item("FM-Pro4", 5, 49)
        };
        Inventory app = new Inventory(items);
        assertEquals(50, app.items[0].getQuality());
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals(47, app.items[0].getQuality());
        assertEquals(50, app.items[1].getQuality());
    }

    @Test
    public void the_FM_Pro4_actually_increases_in_quality_the_older_it_gets() {
        Item[] items = new Item[]{
                new Item("FM-Pro4", 5, 49),
                new Item("FM-Pro4", 5, 0)
        };
        Inventory app = new Inventory(items);
        app.updateQuality();
        assertEquals(50, app.items[0].getQuality());
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals(4, app.items[1].getQuality());
    }

    @Test
    public void the_fuel_level_sensor_test() {
        /**
         * "Fuel level sensor", being a legendary item,
         * never has to be sold or decreases in Quality
         */
        Item[] items = new Item[]{
                new Item("Fuel level sensor", 0, 80), //
                new Item("Fuel level sensor", -1, 80)
        };
        Inventory app = new Inventory(items);
        app.updateQuality();
        app.updateQuality();
        assertEquals(50, app.items[0].getQuality());
        assertEquals(-1, app.items[1].getSellIn());
    }

    @Test
    public void the_FM_Tco4_LCV_test() {
        /**
         * "FM-Tco4 LCV" increases in Quality as it's SellIn
         * value approaches: Quality increases by 2 when there
         * are 10 days or less and by 3 when there are 5 days
         * or less but Quality drops to 0 after the sell by date has passed
         */
        String dayPast = "Day past for FM-Tco4 LCV should return quantity as 0";
        Item[] items = new Item[]{
                new Item("FM-Tco4 LCV", 12, 25), //
                new Item("FM-Tco4 LCV", -1, 80)
        };
        Inventory app = new Inventory(items);
        app.updateQuality();
        assertEquals(dayPast,0, app.items[1].getQuality());
        assertEquals(11, app.items[0].getSellIn());
        assertEquals(24, app.items[0].getQuality());
        app.updateQuality();
        assertEquals(10, app.items[0].getSellIn());
        assertEquals(26, app.items[0].getQuality());

        // when 6 days
        for (int i = 0; i <= 5; i++)
            app.updateQuality();

        assertEquals(4, app.items[0].getSellIn());
        assertEquals(40, app.items[0].getQuality());

        // when day past equal to 0
        for (int i = 0; i <= 5; i++)
            app.updateQuality();

        assertEquals(dayPast, 0, app.items[0].getQuality());
        assertEquals(dayPast, 0, app.items[1].getQuality());
    }
}
