package be.he2b.g45502.model;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author g45502
 */
public class BagTest {

    @Test
    public void equalsTestTrueAfterAdding() {
        Bag bag1 = new Bag();
        Bag bag2 = new Bag();
        bag1.addGems(Gem.RUBY);
        bag2.addGems(Gem.RUBY);
        assertTrue(bag1.equals(bag2));
    }

    @Test
    public void equalsFalseOtherObject() {
        Bag bag1 = new Bag();
        String bag2 = "bag2";
        assertFalse(bag1.equals(bag2));
    }

    @Test
    public void equalsFalseNull() {
        Bag bag1 = new Bag();
        assertFalse(bag1.equals(null));
    }

    @Test
    public void loseContent() {
        Bag bag = new Bag();
        bag.addGems(Gem.RUBY);
        bag.loseContent();
        assertTrue(bag.getGems().isEmpty());
    }
}
