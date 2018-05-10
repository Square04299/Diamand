package be.he2b.g45502.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author g45502
 */
public class HazardTest {
    
    public HazardTest() {
    }

    /**
     * Test of getType method, of class Hazard.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Hazard instance = new Hazard(HazardType.SNAKES);
        HazardType expResult = HazardType.SNAKES;
        HazardType result = instance.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of isExlorersEscapeReason method, of class Hazard.
     */
    @Test
    public void testIsExlorersEscapeReason() {
        System.out.println("isExlorersEscapeReason");
        Hazard instance = new Hazard(HazardType.SNAKES);
        boolean expResult = false;
        boolean result = instance.isExplorersEscapeReason();
        assertEquals(expResult, result);
    }

    /**
     * Test of escape method, of class Hazard.
     */
    @Test
    public void testEscape() {
        System.out.println("escape");
        Hazard instance = new Hazard(HazardType.GIANT_SPIDERS);
        instance.escape();
        assertTrue(instance.isExplorersEscapeReason());
    }

    /**
     * Test of explore method, of class Hazard.
     */
    @Test
    public void testExplore() {
        System.out.println("explore");
        List<Explorer> explorers = new ArrayList<>();
        Hazard instance = new Hazard(HazardType.SNAKES);
        instance.explore(explorers);
    }
    
}
