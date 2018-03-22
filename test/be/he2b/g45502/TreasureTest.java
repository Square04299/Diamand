package be.he2b.g45502;

import be.he2b.g45502.model.Explorer;
import be.he2b.g45502.model.Treasure;
import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class TreasureTest {

    @Test
    public void contructorWithoutAttribut() {
        Treasure treasure = new Treasure();
        int initNbRubies = treasure.getInitNbRubies();
        int rubies = treasure.getRubies();
        boolean rubiesEqualsInitNbRubies = rubies == initNbRubies;
        boolean inBoundaries = (1 <= rubies && rubies <= 15);

        assertTrue(rubiesEqualsInitNbRubies && inBoundaries);
    }

    @Test
    public void contructorWithAttribut() {
        Treasure treasure = new Treasure(42);
        int initNbRubies = treasure.getInitNbRubies();
        int rubies = treasure.getRubies();

        assertTrue(initNbRubies == rubies && rubies == 42);
    }

    @Test
    public void exploredByNoExplorer() {
        Treasure treasure = new Treasure();
        treasure.explore(Arrays.asList());
    }

    @Test
    public void exploredBy1Explorer() {
        Explorer e1 = new Explorer("e1");
        Treasure treasure = new Treasure(4);
        treasure.explore(Arrays.asList(e1));
        assertEquals(0, treasure.getRubies());
    }

    @Test
    public void exploredBy2Explorers() {
        Explorer e1 = new Explorer("e1");
        Explorer e2 = new Explorer("e2");
        Treasure treasure = new Treasure(3);
        treasure.explore(Arrays.asList(e1, e2));
        assertEquals(1, treasure.getRubies());
    }
}
