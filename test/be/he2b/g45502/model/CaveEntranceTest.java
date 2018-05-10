package be.he2b.g45502.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author g45502
 */
public class CaveEntranceTest {

    public CaveEntranceTest() {
    }

    /**
     * Test of isLockedOut method, of class CaveEntrance.
     */
    @Test
    public void testIsLockedOut() {
        System.out.println("isLockedOut");
        Cave cave = new Cave();
        CaveEntrance instance = new CaveEntrance(cave);
        boolean expResult = false;
        boolean result = instance.isLockedOut();
        assertEquals(expResult, result);
    }

    /**
     * Test of isUnsafe method, of class CaveEntrance.
     */
    @Test
    public void testIsUnsafe() {
        System.out.println("isUnsafe");
        Cave cave = new Cave();
        CaveEntrance instance = new CaveEntrance(cave);
        boolean expResult = false;
        boolean result = instance.isUnsafe();
        assertEquals(expResult, result);
    }

    /**
     * Test of lockOut method, of class CaveEntrance.
     */
    @Test
    public void testLockOut() {
        System.out.println("lockOut");
        Cave cave = new Cave();
        CaveEntrance instance = new CaveEntrance(cave);
        instance.lockOut();
    }

    /**
     * Test of getPath method, of class CaveEntrance.
     */
    @Test
    public void testGetPath() {
        System.out.println("getPath");
        Cave cave = new Cave();
        CaveEntrance instance = new CaveEntrance(cave);
        List<Tile> expResult = new ArrayList<>();
        List<Tile> result = instance.getPath();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastDiscoveredTile method, of class CaveEntrance.
     */
    @Test
    public void testGetLastDiscoveredTile() {
        System.out.println("getLastDiscoveredTile");
        Cave cave = new Cave();
        CaveEntrance instance = new CaveEntrance(cave);
        Tile expResult = null;
        Tile result = instance.getLastDiscoveredTile();
        assertEquals(expResult, result);
    }

    /**
     * Test of discorverNewTile method, of class CaveEntrance.
     */
    @Test
    public void testDiscorverNewTile() {
        System.out.println("discorverNewTile");
        List<Explorer> explorers = new ArrayList<>();
        Cave cave = new Cave();
        CaveEntrance instance = new CaveEntrance(cave);
        instance.discorverNewTile(explorers);
    }

    /**
     * Test of returnToCamp method, of class CaveEntrance.
     */
    @Test
    public void testReturnToCamp() {
        System.out.println("returnToCamp");
        List<Explorer> explorers = null;
        Cave cave = new Cave();
        CaveEntrance instance = new CaveEntrance(cave);
        instance.returnToCamp(explorers);
    }

    /**
     * Test of addTileToPath method, of class CaveEntrance.
     */
    @Test
    public void testAddTileToPath() {
        System.out.println("addTileToPath");
        Tile tiles = null;
        Cave cave = new Cave();
        CaveEntrance instance = new CaveEntrance(cave);
        instance.addTileToPath(tiles);
    }

    /**
     * Test of makeLastTileExplored method, of class CaveEntrance.
     */
    @Test
    public void testMakeLastTileExplored() {
        System.out.println("makeLastTileExplored");
        Cave cave = new Cave();
        CaveEntrance instance = new CaveEntrance(cave);
        instance.makeLastTileExplored();

    }

}
