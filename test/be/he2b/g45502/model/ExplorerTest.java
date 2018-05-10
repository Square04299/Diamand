package be.he2b.g45502.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author g45502
 */
public class ExplorerTest {

    public ExplorerTest() {
    }

    /**
     * Test of getChest method, of class Explorer.
     */
    @Test
    public void testGetChest() {
        System.out.println("getChest");
        Explorer instance = new Explorer("e1");
        Chest expResult = new Chest();
        Chest result = instance.getChest();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPseudonym method, of class Explorer.
     */
    @Test
    public void testGetPseudonym() {
        System.out.println("getPseudonym");
        Explorer instance = new Explorer("e1");
        String expResult = "e1";
        String result = instance.getPseudonym();
        assertEquals(expResult, result);

    }

    /**
     * Test of getBag method, of class Explorer.
     */
    @Test
    public void testGetBag() {
        System.out.println("getBag");
        Explorer instance = new Explorer("e1");
        Bag expResult = new Bag();
        Bag result = instance.getBag();
        assertEquals(expResult, result);

    }

    /**
     * Test of getState method, of class Explorer.
     */
    @Test
    public void testGetState() {
        System.out.println("getState");
        Explorer instance = new Explorer("e1");
        State expResult = State.CAMPING;
        State result = instance.getState();
        assertEquals(expResult, result);
    }

    /**
     * Test of takeDecisionToLeave method, of class Explorer.
     */
    @Test
    public void testTakeDecisionToLeave() {
        System.out.println("takeDecisionToLeave");
        Explorer instance = new Explorer("e1");
        State expResult = State.LEAVING;
        instance.takeDecisionToLeave();
        State result = instance.getState();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFortune method, of class Explorer.
     */
    @Test
    public void testGetFortune() {
        System.out.println("getFortune");
        Explorer instance = new Explorer("e1");
        int expResult = 0;
        int result = instance.getFortune();
        assertEquals(expResult, result);
    }

    /**
     * Test of reachCamp method, of class Explorer.
     */
    @Test
    public void testReachCamp() {
        System.out.println("reachCamp");
        Explorer instance = new Explorer("e1");
        State expResult = State.CAMPING;
        instance.reachCamp();
        State result = instance.getState();
        assertEquals(expResult, result);
    }

    /**
     * Test of startExploration method, of class Explorer.
     */
    @Test
    public void testStartExploration() {
        System.out.println("startExploration");
        Explorer instance = new Explorer("e1");
        instance.startExploration();
    }

    /**
     * Test of runAway method, of class Explorer.
     */
    @Test
    public void testRunAway() {
        System.out.println("runAway");
        Explorer instance = new Explorer("e1");
        instance.runAway();
    }
}
