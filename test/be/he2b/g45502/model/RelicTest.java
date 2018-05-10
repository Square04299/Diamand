package be.he2b.g45502.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author g45502
 */
public class RelicTest {

    public RelicTest() {
    }

    /**
     * Test of explore method, of class Relic.
     */
    @Test
    public void testExplore() {
        System.out.println("explore");
        List<Explorer> explorers = new ArrayList<>();
        Relic instance = new Relic();
        instance.explore(explorers);
    }

    /**
     * Test of canBeTaken method, of class Relic.
     */
    @Test
    public void testCanBeTaken() {
        System.out.println("canBeTaken");
        List<Explorer> explorers = new ArrayList<>();
        Relic instance = new Relic();
        boolean expResult = false;
        boolean result = instance.canBeTaken(explorers);
        assertEquals(expResult, result);
    }

    /**
     * Test of convertGemValue method, of class Relic.
     */
    @Test
    public void testConvertGemValue() {
        System.out.println("convertGemValue");
        int nbTakenRelics = 3;
        Relic instance = new Relic();
        instance.convertGemValue(nbTakenRelics);

    }

}
