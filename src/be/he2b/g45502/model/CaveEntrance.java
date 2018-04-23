package be.he2b.g45502.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 45502
 */
public class CaveEntrance {

    private Treasure lastDiscoveredTreasure;
    private List<Treasure> path;
    private boolean lockedOut;

    /**
     *Contructor of the class CaveEntrave
     */
    public CaveEntrance (){
        this.path = new ArrayList();
        this.lockedOut = false;
    }

    /**
     *See if lockedOut is true or false
     * @return true if the cave is locked
     */
    public boolean isLockedOut() {
        return lockedOut;
    }
    
    /**
     *Set the value of lockOut to true
     */
    public void lockOut(){
        lockedOut = true;
    }
    /**
     * Get the List(path)
     * @return The path
     */
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
        path.add(lastDiscoveredTreasure);
    }
    
    void addTreasureToPath(Treasure treasure){
        path.add(treasure);
    }
}
