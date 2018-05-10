package be.he2b.g45502.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author g45502
 */
public class CaveTest {

    @Test
    public void hasNewEntranceToExplore_False() {
        Cave cave = new Cave();
        for (int i = 1; i <= 5; i++) {
            cave.openNewEntrance();
            cave.lockOutCurrentEntrance();
        }
        assertFalse(cave.hasNewEntranceToExplore());
    }

    @Test
    public void hasNewEntranceToExplore_True() {
        Cave cave = new Cave();
        for (int i = 1; i <= 3; i++) {
            cave.openNewEntrance();
            cave.lockOutCurrentEntrance();
        }
        assertTrue(cave.hasNewEntranceToExplore());
    }

    @Test
    public void openNewEntrance_Ok() {
        Cave cave = new Cave();
        cave.openNewEntrance();
        cave.lockOutCurrentEntrance();
        assertTrue(cave.getNbExploredEntrance() == 1);
    }

    @Test(expected = GameException.class)
    public void openNewEntrance_Exception() {
        Cave cave = new Cave();
        cave.openNewEntrance();
        cave.openNewEntrance();
    }

    @Test(expected = GameException.class)
    public void openNewEntrance_Exception2() {
        Cave cave = new Cave();
        for (int i = 1; i <= 6; i++) {
            cave.openNewEntrance();
            cave.lockOutCurrentEntrance();
        }
    }

    @Test
    public void lockOutCurrentEntrance_Ok() {
        Cave cave = new Cave();
        cave.openNewEntrance();
        cave.lockOutCurrentEntrance();
        assertTrue(cave.getNbExploredEntrance() == 1);
    }

    public void lockOutCurrentEntrance() {
        Cave cave = new Cave();
        cave.openNewEntrance();
        cave.lockOutCurrentEntrance();
        cave.lockOutCurrentEntrance();
    }
}
