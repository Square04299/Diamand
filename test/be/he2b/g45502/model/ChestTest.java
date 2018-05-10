package be.he2b.g45502.model;

import org.junit.Test;

/**
 *
 * @author g45502
 */
public class ChestTest {


    /**
     * Test of saveBag method, of class Chest.
     */
    @Test
    public void testSaveBag() {
        System.out.println("saveBag");
        Bag bag = new Bag();
        Chest instance = new Chest();
        instance.saveBag(bag);
    }

}
