package be.he2b.g45502.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author square
 */
public class Game implements Model{
    
    private Cave cave;
    private List<Explorer> explorers;

    public Game() {
        this.cave = new Cave();
        this.explorers = new ArrayList();
    }    
    
    @Override
    public void addExplorer(Explorer explorer) {
        explorers.add(explorer);
    }

    @Override
    public void moveForward() {
        cave.discoverNewTreasure(explorers);
    }

    @Override
    public boolean isOver() {
        boolean isOver = true;
        int i = 0;
        while(isOver && i < explorers.size()){
            if (explorers.get(i).getState() == State.EXPLORING) {
                isOver = false;
            }
            i++;
        }
        return isOver;
    }

    @Override
    public Cave getCave() {
        return cave;
    }

    @Override
    public List<Explorer> getExplorers() {
        return explorers;
    }

    @Override
    public List<Explorer> getExploringExplorers() {
        List<Explorer> exploringExplorers = new ArrayList<>();
        for (int i = 0; i < explorers.size(); i++) {
            if (explorers.get(i).getState() == State.EXPLORING) {
                exploringExplorers.add(explorers.get(i));
            }
        }
        return exploringExplorers;
    }

    @Override
    public void handleExplorerDecisionToLeave(Explorer explorer) {
        if (explorers.isEmpty()) {
            throw new RuntimeException();
        }
        explorer.takeDecisionToLeave();
    }
    
}
