package be.he2b.g45502.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author g45502
 */
public class GameTest {

    public GameTest() {
    }

    /**
     * Test of addExplorer method, of class Game.
     */
    @Test
    public void testAddExplorer() {
        System.out.println("addExplorer");
        Explorer explorer = new Explorer("e1");
        Game instance = new Game();
        instance.addExplorer(explorer);
    }

    /**
     * Test of isExplorationPhaseOver method, of class Game.
     */
    @Test
    public void testIsExplorationPhaseOver() {
        System.out.println("isExplorationPhaseOver");
        Game instance = new Game();
        boolean expResult = true;
        boolean result = instance.isExplorationPhaseOver();
        assertEquals(expResult, result);
    }

    /**
     * Test of getExploringExplorers method, of class Game.
     */
    @Test
    public void testGetExploringExplorers() {
        System.out.println("getExploringExplorers");
        Game instance = new Game();
        List<Explorer> expResult = new ArrayList<>();
        List<Explorer> result = instance.getExploringExplorers();
        assertEquals(expResult, result);
    }

    /**
     * Test of handleExplorerDecisionToLeave method, of class Game.
     */
    @Test(expected = GameException.class)
    public void testHandleExplorerDecisionToLeave() {
        System.out.println("handleExplorerDecisionToLeave");
        Explorer explorer = new Explorer("e1");
        Game instance = new Game();
        instance.handleExplorerDecisionToLeave(explorer);
    }

    /**
     * Test of start method, of class Game.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        Game instance = new Game();
        instance.start();
    }

    /**
     * Test of isThereEnoughExplorer method, of class Game.
     */
    @Test
    public void testIsThereEnoughExplorer() {
        System.out.println("isThereEnoughExplorer");
        Game instance = new Game();
        boolean expResult = false;
        boolean result = instance.isThereEnoughExplorer();
        assertEquals(expResult, result);
    }

    /**
     * Test of isItPossibleToAddExplorer method, of class Game.
     */
    @Test
    public void testIsItPossibleToAddExplorer() {
        System.out.println("isItPossibleToAddExplorer");
        Game instance = new Game();
        boolean expResult = true;
        boolean result = instance.isItPossibleToAddExplorer();
        assertEquals(expResult, result);
    }

}
