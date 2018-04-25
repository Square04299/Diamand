package be.he2b.g45502.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 45502
 */
public class Game implements Model {

    private final Cave cave;
    private final List<Explorer> explorers;
    private List<Explorer> exploringExplorers;

    /**
     * Contructor Game will create the cave and the list of player
     */
    public Game() {
        this.cave = new Cave();
        this.explorers = new ArrayList();
    }

    @Override
    public void addExplorer(Explorer explorer) {
        if (getExplorers().size() < 8) {
            explorers.add(explorer);
        } else {
            throw new GameException("Too much player");
        }
    }

    @Override
    public void moveForward() {
        cave.getCurrentEntrance().discoverNewTreasure(getExploringExplorers());    
    }

    @Override
    public boolean isExplorationPhaseOver() {
        return getExploringExplorers().isEmpty();
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
        exploringExplorers = new ArrayList<>();
        for (Explorer explorer : explorers) {
            if (explorer.getState() == State.EXPLORING) {
                exploringExplorers.add(explorer);
            }
        }
        return exploringExplorers;
    }

    @Override
    public void handleExplorerDecisionToLeave(Explorer explorer) {
        if (explorers.isEmpty()) {
            throw new GameException();
        }
        explorer.takeDecisionToLeave();
    }
    
    /**
     *Check what is the last treasure you discord of the current entrance
     * @return the last treasure discovered
     */
    public Treasure getLastDiscoveredTreasure() {
        return cave.getCurrentEntrance().getLastDiscoveredTreasure();
    }

    @Override
    public void start() {
        if (getExplorers().size() > 8) {
            throw new GameException();
        }
    }

    @Override
    public boolean isThereEnoughExplorer() {
        return getExplorers().size() >= 3;
    }

    @Override
    public boolean isItPossibleToAddExplorer() {
        return getExplorers().size() < 8;
    }

    @Override
    public Explorer getWinner() {
        int valueI = 0;
        if (isExplorationPhaseOver()) {
            int max = getExplorers().get(0).getFortune();
            for (int i = 0; i < getExplorers().size(); i++) {
                if (max < getExplorers().get(i).getFortune()) {
                    max = getExplorers().get(i).getFortune();
                    valueI = i;
                }
            }
        } else {
            throw new GameException("You can show the winner util you finish the game");
        }
        return getExplorers().get(valueI);
    }
    
    @Override
    public void makeExplorersLeave() {
        for (Explorer explorer : getExplorers()) {
            if(explorer.getState() == State.LEAVING){
                explorer.reachCamp();
            }
        }
    }

    @Override
    public void startNewExplorationPhase() {
        
        if (!cave.hasNewEntranceToExplore()) {
            throw new GameException("You can't start a new exploration phase");
        }
        cave.openNewEntrance();
        for (Explorer explorer : explorers) {
            explorer.startExploration();
        }
    }

    @Override
    public void endExplorationPhase() {
        cave.getCurrentEntrance().lockOut();
    }

    @Override
    public boolean isOver() {
        return (!cave.hasNewEntranceToExplore());
    }

}
