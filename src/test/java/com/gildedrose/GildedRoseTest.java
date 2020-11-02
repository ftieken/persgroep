package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    /**
     * "Aged Brie" actually increases in Quality the older it gets
     */
    @Test
    void testBrie() {
        Item[] items = new Item[]{new Item("Aged Brie", 5, 6)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(7, app.items[0].quality);
    }

    /**
     * Found bug in old calculation for Aged Brie. When sellin < 0 then Quality increased by 2, must be 1
     */
    @Test
    void testBrieSellinSmallerThenZero() {
        Item[] items = new Item[]{new Item("Aged Brie", -1, 48)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(49, app.items[0].quality);
    }

    @Test
    void testBrieQualityMoreThenFifty() {
        Item[] items = new Item[]{new Item("Aged Brie", 5, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void testDextery() {
        Item[] items = new Item[]{new Item("+5 Dexterity Vest", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(19, app.items[0].quality);
    }

    @Test
    void testElixer() {
        Item[] items = new Item[]{new Item("Elixir of the Mongoose", 2, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(19, app.items[0].quality);
    }

    @Test
    void testElixerSellinNeg() {
        Item[] items = new Item[]{new Item("Elixir of the Mongoose", -1, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(18, app.items[0].quality);
    }

    @Test
    void testElixerNeverNegativeQuality() {
        Item[] items = new Item[]{new Item("Elixir of the Mongoose", 2, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    /**
     * "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
     */
    @Test
    void testSulfaras() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 0, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    //    "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches
    @Test
    void testBackstagePassesMoreThenTenDays() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21, app.items[0].quality);
    }

    @Test
    void testBackstagePassesLessThenTenDays() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 9, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(22, app.items[0].quality);
    }

    @Test
    void testBackstagePassesLessThenFiveDayes() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 4, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(23, app.items[0].quality);
    }

    @Test
    void testBackstagePassesAfterConcert() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void testConjured() {
        Item[] items = new Item[]{new Item("Conjured Mana Cake", 5, 6)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].quality);
    }

    @Test
    void testConjuredNeg() {
        Item[] items = new Item[]{new Item("Conjured Mana Cake", -1, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
    }
}
