package be.he2b.g45502.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Entrance of the cave
 *
 * @author 45502
 */
public class CaveEntrance {

    private Tile lastDiscoveredTile;
    private final List<Tile> path;
    private boolean lockedOut;
    private final Cave cave;
    private boolean unsafe;
    private boolean treasureFound;
    private Treasure firstTreasureTile;

    /**
     * Contructor of the class CaveEntrave
     *
     * @param cave current cave
     */
    public CaveEntrance(Cave cave) {
        this.path = new ArrayList();
        this.lockedOut = false;
        this.cave = cave;
        this.unsafe = false;
        this.treasureFound = false;
    }

    /**
     * See if lockedOut is true or false
     *
     * @return true if the cave is locked
     */
    public boolean isLockedOut() {
        return lockedOut;
    }

    /**
     * Check if the cave is unsafe
     *
     * @return true if it's safe
     */
    public boolean isUnsafe() {
        return unsafe;
    }

    /**
     * Set the value of lockOut to true
     */
    public void lockOut() {
        this.lockedOut = true;
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
        if (this.lastDiscoveredTile instanceof Hazard) {
            for (Tile hazard : this.path) {
                if (hazard instanceof Hazard) {
                    if (((Hazard) hazard).getType().equals(((Hazard) this.lastDiscoveredTile).getType())) {
                        unsafe = true;
                        ((Hazard) hazard).escape();
                    }
                }
            }
        } else if (this.lastDiscoveredTile instanceof Relic) {
            this.cave.incrementNbTakenRelics();
            ((Relic) this.lastDiscoveredTile).convertGemValue(this.cave.getNbTakenRelics());
        }
        addTileToPath(this.lastDiscoveredTile);
        if (this.lastDiscoveredTile instanceof Treasure) {
            this.treasureFound = true;
            this.firstTreasureTile = ((Treasure) this.lastDiscoveredTile);
            lastDiscoveredTile.explore(explorers);
        }
        path.add(lastDiscoveredTile);
    }

    /**
     * Allow all player that will return to camp to see the path
     *
     * @param explorers List of explorer that want to return to camp
     */
    public void returnToCamp(List<Explorer> explorers) {
        for (Tile tile : path) {
            if (tile instanceof Treasure) {
                tile.explore(explorers);
            } else if (tile instanceof Relic && ((Relic) tile).canBeTaken(explorers)) {
                tile.explore(explorers);
                path.remove(tile);
            }
        }
    }

    void addTileToPath(Tile tiles) {
        path.add(tiles);
    }

    /**
     * Will take the last treasure discovered and put it on the first one
     */
    public void makeLastTileExplored() {
        if (this.lastDiscoveredTile instanceof Treasure && !this.firstTreasureTile.equals(this.lastDiscoveredTile)) {
            this.firstTreasureTile.transferGemsFrom((Treasure) this.lastDiscoveredTile);
        }
    }

}
