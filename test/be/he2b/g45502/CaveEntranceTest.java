package be.he2b.g45502;

import be.he2b.g45502.model.CaveEntrance;
import be.he2b.g45502.model.Explorer;
import be.he2b.g45502.model.Game;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class CaveEntranceTest {

    @Test
    public void discoverNewTreasureSameSharing() {
        Game game = new Game();
        Explorer e1 = new Explorer("e1");
        Explorer e2 = new Explorer("e2");
        game.startNewExplorationPhase();
        game.getCave().getCurrentEntrance().discorverNewTile(Arrays.asList(e1, e2));
        assertTrue(e1.getBag().equals(e2.getBag()));
    }
}