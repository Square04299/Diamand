package be.he2b.g45502.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 45502
 */
public class Cave {

    private Treasure lastDiscoveredTreasure;
    private List<Treasure> path;

    public Cave() {
        this.path = new ArrayList();
    }

    public List<Treasure> getPath() {
        return path;
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
    
    /**
     * Allow all player that will return to camp to see the path
     * @param explorers List of explorer that want to return to camp
     */
    public void returnToCamp(List<Explorer> explorers){
        
    }
}
