package com.crazyfingers;

import static org.junit.Assert.*;

import org.junit.Test;

public class InventoryTest {

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        Inventory app = new Inventory(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

}
