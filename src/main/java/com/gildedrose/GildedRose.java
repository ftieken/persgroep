package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private void updateItem(Item item) {
        switch (item.name) {
            case "Aged Brie": {
                if (item.quality < 50) {
                    item.quality += 1;
                }
            }
            break;
            case "Sulfuras, Hand of Ragnaros": {
                // nothing to do, always same quality
            }
            break;
            case "Backstage passes to a TAFKAL80ETC concert": {
                if (item.sellIn < 1) {
                    item.quality = 0;
                } else if (item.sellIn < 5) {
                    item.quality += 3;
                } else if (item.sellIn < 10) {
                    item.quality += 2;
                } else {
                    item.quality += 1;
                }
            }
            break;
            case "Conjured Mana Cake": {
                if (item.sellIn > 0) {
                    item.quality -= 2;
                } else {
                    item.quality -= 4;
                }
            }
            break;
            default:
                if (item.sellIn < 0) {
                    item.quality -= 2;
                } else {
                    item.quality -= 1;
                }
                break;
        }

        if (item.quality < 0) {
            item.quality = 0;
        } else if (item.quality > 50 && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.quality = 50;
        }

        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }
}