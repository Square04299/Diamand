package be.he2b.g45502.model;

import java.util.List;

/**
 *
 * @author square
 */
public class Cave {

    private Treasure lastDiscoveredTreasure;

    public Cave() {
    }

    /**
     * Create a new treasure
     *
     * @return return the new treasure created
     */
    public Treasure getLastDiscoveredTreasure() {
        return lastDiscoveredTreasure;
    }

    /**
     * Set a new treasure with a specified amount
     *
     * @param lastDiscoveredTreasure
     */
    public void setLastDiscoveredTreasure(Treasure lastDiscoveredTreasure) {
        this.lastDiscoveredTreasure = lastDiscoveredTreasure;
    }

    /**
     * Will create a new room for the (explorers)
     *
     * @param explorers list of player
     */
    public void discoverNewTreasure(List<Explorer> explorers) {
        if (explorers.isEmpty()) {
            return;
        }
        Treasure newTreasure = new Treasure();
        newTreasure.explore(explorers);
        setLastDiscoveredTreasure(newTreasure);
    }

}
