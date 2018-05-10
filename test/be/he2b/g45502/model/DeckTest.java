package be.he2b.g45502.model;

import org.junit.Test;

/**
 *
 * @author g45502
 */
public class DeckTest {

    public DeckTest() {
    }

    /**
     * Test of putBack method, of class Deck.
     */
    @Test
    public void testPutBack() {
        System.out.println("putBack");
        Deck instance = new Deck();
        Tile tile = instance.getTile();
        instance.putBack(tile);
    }

    /**
     * Test of tileList method, of class Deck.
     */
    @Test
    public void testTileList() {
        System.out.println("tileList");
        Deck instance = new Deck();
        instance.tileList();
    }

}
