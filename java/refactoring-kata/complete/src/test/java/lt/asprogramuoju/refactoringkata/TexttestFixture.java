package lt.asprogramuoju.refactoringkata;

import lt.asprogramuoju.refactoringkata.domain.Item;
import lt.asprogramuoju.refactoringkata.service.InventoryService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Item[] items = new Item[] {
                new Item("Panic button", 10, 20), //
                new Item("FM-Pro4", 2, 0), //
                new Item("Temperature sensor", 5, 7), //
                new Item("Fuel level sensor", 0, 80), //
                new Item("Fuel level sensor", -1, 80),
                new Item("FM-Tco4 LCV", 15, 20),
                new Item("FM-Tco4 LCV", 10, 49),
                new Item("FM-Tco4 LCV", 5, 49),
                new Item("FM-Tco4 LCV", 5, 19)};

        List<Item> itemList = Arrays.asList(items);

        InventoryService app = new InventoryService();
        app.setItems(itemList);

        int days = 8;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");

            for (Item item : items)
                System.out.println(item);

            System.out.println();
            app.update();
        }
    }

}
