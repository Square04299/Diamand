package be.he2b.g45502.model;

import java.util.List;

/**
 *
 * @author 45502
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
     * Will create a new room for the (explorers)
     *
     * @param explorers list of player
     */
    public void discoverNewTreasure(List<Explorer> explorers) {
        if (explorers.isEmpty()) {
            return;
        }
        this.lastDiscoveredTreasure = new Treasure();
        lastDiscoveredTreasure.explore(explorers);
    }

}
