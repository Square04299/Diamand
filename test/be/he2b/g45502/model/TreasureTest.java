package be.he2b.g45502.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author g45502
 */
public class TreasureTest {

    public TreasureTest() {
    }

    /**
     * Test of getGems method, of class Treasure.
     */
    @Test
    public void testGetGems() {
        System.out.println("getGems");
        Treasure instance = new Treasure(5);
        List<Gem> expResult = new ArrayList<>();
        expResult.add(Gem.RUBY);
        expResult.add(Gem.RUBY);
        expResult.add(Gem.RUBY);
        expResult.add(Gem.RUBY);
        expResult.add(Gem.RUBY);
        List<Gem> result = instance.getGems();
        assertEquals(expResult, result);
    }

    /**
     * Test of getInitNbRubies method, of class Treasure.
     */
    @Test
    public void testGetInitNbRubies() {
        System.out.println("getInitNbRubies");
        Treasure instance = new Treasure(6);
        int expResult = 6;
        int result = instance.getInitNbRubies();
        assertEquals(expResult, result);
    }

    /**
     * Test of restore method, of class Treasure.
     */
    @Test
    public void testRestore() {
        System.out.println("restore");
        Treasure instance = new Treasure(0);
        instance.restore();
    }

    /**
     * Test of transferGemsFrom method, of class Treasure.
     */
    @Test
    public void testTransferGemsFrom() {
        System.out.println("transferGemsFrom");
        Treasure o = new Treasure(3);
        Treasure instance = new Treasure(3);
        instance.transferGemsFrom(o);
    }

}
