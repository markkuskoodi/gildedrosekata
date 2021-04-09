package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void updateAgedBrie(){
        Item[] items = new Item[] { new Item("Aged Brie", 5, 0) };
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < 5; i++) {
            app.updateQuality();
        }
        assertEquals(5, app.items[0].quality);

        app.updateQuality();
        app.updateQuality();

        assertEquals(3, app.items[0].quality);
    }

    @Test
    void updateBackstage(){
        Item[] items = new Item[] { new Item("Backstage passes", 10, 0) };
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < 5; i++) {
            app.updateQuality();
        }
        assertEquals(10, app.items[0].quality);

        for (int i = 0; i < 6; i++) {
            app.updateQuality();
        }

        assertEquals(28, app.items[0].quality);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    void updateConjured(){
        Item[] items = new Item[] { new Item("Conjured item", 5, 16), new Item("Conjured 2", 5, 10) };
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < 7; i++) {
            app.updateQuality();
            System.out.println(app.items[0].quality + " " + app.items[0].sellIn);
        }
        assertEquals(1, app.items[0].quality);
        assertEquals(0, app.items[1].quality);
    }


}
