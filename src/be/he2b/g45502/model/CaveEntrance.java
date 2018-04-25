package be.he2b.g45502.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 45502
 */
public class CaveEntrance {

    private Tile lastDiscoveredTile;
    private final List<Tile> path;
    private boolean lockedOut;
    private Cave cave;
    private boolean unsafe;

    /**
     * Contructor of the class CaveEntrave
     */
    public CaveEntrance(Cave cave) {
        this.path = new ArrayList();
        this.lockedOut = false;
        this.cave = cave;
        this.unsafe = false;
    }

    /**
     * See if lockedOut is true or false
     *
     * @return true if the cave is locked
     */
    public boolean isLockedOut() {
        return lockedOut;
    }

    public boolean isUnsafe() {
        return unsafe;
    }

    /**
     * Set the value of lockOut to true
     */
    public void lockOut() {
        lockedOut = true;
    }

    /**
     * Get the List(path)
     *
     * @return The path
     */
    public List<Tile> getPath() {
        return path;
    }

    /**
     * Create a new treasure
     *
     * @return return the new treasure created
     */
    public Tile getLastDiscoveredTile() {
        return lastDiscoveredTile;
    }

    /**
     * Will create a new room for the (explorers)
     *
     * @param explorers list of player
     */
    public void discorverNewTile(List<Explorer> explorers) {
        if (explorers.isEmpty()) {
            return;
        }
        this.lastDiscoveredTile = cave.getDeck().getTile();
        lastDiscoveredTile.explore(explorers);
        if (this.lastDiscoveredTile instanceof Hazard) {
            for (Tile hazard : this.path) {
                if (hazard instanceof Hazard) {
                    if (((Hazard) hazard).getType() == ((Hazard) this.lastDiscoveredTile).getType()) {
                        unsafe = true;
                    }
                }
            }
        }
    }

    /**
     * Allow all player that will return to camp to see the path
     *
     * @param explorers List of explorer that want to return to camp
     */
    public void returnToCamp(List<Explorer> explorers) {
        path.add(lastDiscoveredTile);
    }

    void addTileToPath(Treasure treasure) {
        path.add(treasure);
    }
}
