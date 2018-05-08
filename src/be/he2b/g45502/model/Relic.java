package be.he2b.g45502.model;

import java.util.List;

/**
 *
 * @author square
 */
public class Relic implements Tile {
    
    @Override
    public void explore(List<Explorer> explorers) {
        
    }
    
    /**
     * 
     * @param explorers
     * @return true if list contain 1 explorer and he is in the state of leaving
     */
    public boolean canBeTaken(List<Explorer> explorers){
        return explorers.size() == 1 && explorers.get(0).getState().equals(State.LEAVING);
    }
    
}
