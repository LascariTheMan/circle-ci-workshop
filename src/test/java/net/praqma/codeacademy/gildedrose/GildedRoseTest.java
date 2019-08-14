package net.praqma.codeacademy.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void name_is_never_changed() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }
    @Test
    public void old_brie() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue("brie is a higher quality",app.items[0].quality>1 );
        
    }
    @Test
    public void never_over_50() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue("brie is higher quality than it should be able to",app.items[0].quality==50 );
        
    }
    @Test
    public void double_degredation_after_sell_date() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", -1, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue("The quality has degraded twice when sellin is exceeded",app.items[0].quality==28 );
    }
    @Test
    public void quality_is_never_negative() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 10, 1), new Item("Cake", 8, 0), new Item("Cake", 8, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertTrue("The quality is not negative",app.items[0].quality>=0 );
        assertTrue("The quality is not negative",app.items[1].quality>=0 );
        assertTrue("The quality is not negative",app.items[2].quality>=0 );
    }
    @Test
    public void sulfuras_never_must_be_selled_or_decreases_quality() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 100) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue("Sulfuras, Hand of Ragnaros has not decreased sellIn or quality",app.items[0].quality==100 );
        assertTrue("Sulfuras, Hand of Ragnaros has not decreased sellIn or quality",app.items[0].sellIn==10 );
    }
    /** 
    public void ticket_quality_increase_as_sellIn_decreases() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 100) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue("Sulfuras, Hand of Ragnaros has not decreased sellIn or quality",app.items[0].quality==100 );
        assertTrue("Sulfuras, Hand of Ragnaros has not decreased sellIn or quality",app.items[0].sellIn==10 );
    }
    @Test
    public void ticket_quality_is_zero_after_concert() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 100) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue("Sulfuras, Hand of Ragnaros has not decreased sellIn or quality",app.items[0].quality==100 );
        assertTrue("Sulfuras, Hand of Ragnaros has not decreased sellIn or quality",app.items[0].sellIn==10 );
    }*/
}
