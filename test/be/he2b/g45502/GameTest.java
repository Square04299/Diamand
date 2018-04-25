package be.he2b.g45502;

import be.he2b.g45502.model.Explorer;
import be.he2b.g45502.model.Game;
import be.he2b.g45502.model.State;
import be.he2b.g45502.model.Treasure;
import org.junit.Test;

import java.util.List;
import org.junit.Assert;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void addAndGetExplorerGoodNumberOfExplorers() {
        Game game = new Game();
        Explorer e1 = new Explorer("sdr");
        Explorer e2 = new Explorer("mcd");

        game.addExplorer(e1);
        game.addExplorer(e2);

        assertEquals(2, game.getExplorers().size());
    }

    @Test
    public void addAndGetExplorerGoodExplorers() {
        Game game = new Game();
        Explorer e1 = new Explorer("sdr");
        Explorer e2 = new Explorer("mcd");

        game.addExplorer(e1);
        game.addExplorer(e2);

        /*
         * If this test is false, check if you implement the
         * Explorer's equals method...
         */
        assertTrue(game.getExplorers().contains(e1) &&
            game.getExplorers().contains(e2));
    }

    @Test
    public void treatChoiceToLeave() {
        Game game = new Game();
        Explorer e1 = new Explorer("pbt");
        game.addExplorer(e1);
        game.handleExplorerDecisionToLeave(e1);
        assertTrue(e1.getState() == State.LEAVING);
    }

    @Test(expected = RuntimeException.class)
    public void treatChoiceToLeaveException() {
        Game game = new Game();
        Explorer e1 = new Explorer("pbt");
        game.handleExplorerDecisionToLeave(e1);
    }

    @Test
    public void moveForwardExploringExplorerGetRubies() {
        Game game = new Game();
        Explorer e1 = new Explorer("sdr");
        Explorer e2 = new Explorer("pbt");
        Explorer e3 = new Explorer("jlc");
        game.addExplorer(e1);
        game.addExplorer(e2);
        game.addExplorer(e3);
        game.start();
        game.startNewExplorationPhase();
        game.moveForward();
        game.handleExplorerDecisionToLeave(e1);
        game.moveForward();
        assertTrue(e2.getBag().getNbRubies() >= 0);
    }

    @Test
    public void moveForwardLeavingExplorerDoNotGetRubies() {
        Game game = new Game();
        Explorer e1 = new Explorer("sdr");
        Explorer e2 = new Explorer("pbt");
        game.addExplorer(e1);
        game.addExplorer(e2);
        game.startNewExplorationPhase();
        game.handleExplorerDecisionToLeave(e1);
        game.moveForward();
        assertTrue(e1.getBag().getNbRubies() == 0);
    }

    @Test
    public void isOverNoExplorers() {
        Game game = new Game();
        assertTrue(game.isExplorationPhaseOver());
    }

    @Test
    public void isOverExploringExplorer() {
        Game game = new Game();
        Explorer e1 = new Explorer("sdr");
        game.addExplorer(e1);
        game.startNewExplorationPhase();
        assertFalse(game.isExplorationPhaseOver());
    }

    @Test
    public void isOverExplorerIsLeaving() {
        Game game = new Game();
        Explorer e1 = new Explorer("sdr");
        game.addExplorer(e1);
        game.handleExplorerDecisionToLeave(e1);
        assertTrue(game.isExplorationPhaseOver());
    }

    @Test
    public void getExploringExplorers() {
        Game game = new Game();
        Explorer e1 = new Explorer("pbt");
        Explorer e2 = new Explorer("sdr");
        game.addExplorer(e1);
        game.addExplorer(e2);
        game.startNewExplorationPhase();
        game.handleExplorerDecisionToLeave(e1);
        List<Explorer> exploringExplorers = game.getExploringExplorers();
        assertTrue(exploringExplorers.size() == 1
                && exploringExplorers.contains(e2));
    }
    
    @Test
    public void isItPossibleToAddExplorer_less(){
        Game game = new Game();
        Explorer e1 = new Explorer("pbt");
        Explorer e2 = new Explorer("sdr");
        game.addExplorer(e1);
        game.addExplorer(e2);
        assertFalse(game.isThereEnoughExplorer());
    }

    @Test
    public void isItPossibleToAddExplorer_equal(){
        Game game = new Game();
        Explorer e1 = new Explorer("pbt");
        Explorer e2 = new Explorer("sdr");
        Explorer e3 = new Explorer("jlc");
        Explorer e4 = new Explorer("abs");
        Explorer e5 = new Explorer("pma");
        Explorer e6 = new Explorer("bis");
        game.addExplorer(e1);
        game.addExplorer(e2);
        game.addExplorer(e3);
        game.addExplorer(e4);
        game.addExplorer(e5);
        game.addExplorer(e6);
        assertTrue(game.isItPossibleToAddExplorer());
    }
    
    @Test(expected = RuntimeException.class)
    public void isItPossibleToAddExplorer_toMuch(){
        Game game = new Game();
        Explorer e1 = new Explorer("pbt");
        Explorer e2 = new Explorer("sdr");
        Explorer e3 = new Explorer("jlc");
        Explorer e4 = new Explorer("abs");
        Explorer e5 = new Explorer("pma");
        Explorer e6 = new Explorer("bis");
        Explorer e7 = new Explorer("jss");
        Explorer e8 = new Explorer("mba");
        Explorer e9 = new Explorer("hal");
        game.addExplorer(e1);
        game.addExplorer(e2);
        game.addExplorer(e3);
        game.addExplorer(e4);
        game.addExplorer(e5);
        game.addExplorer(e6);
        game.addExplorer(e7);
        game.addExplorer(e8);
        game.addExplorer(e9);
        assertFalse(game.isItPossibleToAddExplorer());
    }
    
    @Test
    public void getWinner_cas1(){
        Game game = new Game();
        Explorer e1 = new Explorer("pbt");
        Explorer e2 = new Explorer("sdr");
        Explorer e3 = new Explorer("jlc");
        Explorer e4 = new Explorer("abs");
        game.addExplorer(e1);
        game.addExplorer(e2);
        game.addExplorer(e3);
        game.addExplorer(e4);
        e1.addToBag(2);
        e2.addToBag(7);
        e3.addToBag(3);
        e4.addToBag(5);
        assertEquals(e2, game.getWinner());
        
    }
}