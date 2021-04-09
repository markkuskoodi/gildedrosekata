package com.gildedrose;

import java.util.Locale;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    /**
     * Vaatame millise asjaga tegemist on ja siis vastavalt kutsume välja meetodi, millist asja väärtust ja
     * müügi aega vähendame/uuendame
     */

    public void updateQuality() {
        for(int i = 0; i < items.length; i++) {
            String itemName = items[i].name.toLowerCase();
            if(itemName.equals("aged brie"))
                items[i] = updateAgedBrie(items[i]);
            else if(itemName.contains("backstage pass"))
                items[i] = updateBackStagePass(items[i]);
            else if(itemName.contains("conjured"))
                items[i] = updateConjuredItem(items[i]);
            else{
                if((items[i].quality > 50 || items[i].quality < 0) && items[i].quality != 80){
                    throw new UnsupportedOperationException("Quality of the item is no go");
                } else if(itemName.contains("sulfuras"))
                    continue;
                else {
                    items[i] = updateRegularItem(items[i]);
                }
            }
        }
    }

    private Item updateAgedBrie(Item item){
        if(item.sellIn == -1){
            item.quality /= 2;
        } else {
            item.quality += 1;
            item.sellIn -= 1;
        }
        return item;
    }

    private Item updateBackStagePass(Item item){
        if(item.sellIn == -1){
            item.quality = 0;
            return item;
        } else if(item.sellIn > 5 && item.sellIn <= 10){
            item.quality += 2;
        } else if(item.sellIn <= 5 && item.sellIn >= 0){
            item.quality += 3;
        } else {
            item.quality += 1;
        }
        item.sellIn -= 1;
        return item;
    }

    private Item updateConjuredItem(Item item){
        if(item.sellIn == -1){
            item.quality /= 4;
        } else{
            item.quality -= 2;
            item.sellIn -= 1;
        }
        return item;
    }

    private Item updateRegularItem(Item item){
        if(item.sellIn == -1){
            item.quality /= 2;
        } else {
            item.quality -= 1;
            item.sellIn -= 1;
        }
        return item;
    }


}