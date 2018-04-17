package be.he2b.g45502.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 45502
 */
public class Game implements Model {

    private Cave cave;
    private List<Explorer> explorers;
    private List<Explorer> exploringExplorers;

    /**
     * Contructor Game will create the cave and the list of player
     */
    public Game() {
        this.cave = new Cave();
        this.explorers = new ArrayList();
    }

    /**
     * Add an explorer to a list of explorers
     *
     * @param explorer New explorer to add in the list
     */
    @Override
    public void addExplorer(Explorer explorer) {
        if (getExplorers().size() < 8) {
            explorers.add(explorer);
        } else {
            throw new GameException("Too much player");
        }
    }

    /**
     * Move the explorer to the next treasure
     */
    @Override
    public void moveForward() {
        cave.discoverNewTreasure(getExploringExplorers());
    }

    /**
     * Check if every explorer left the cave
     *
     * @return False if explorer are still in the cave
     */
    @Override
    public boolean isOver() {
        boolean isOver = true;
        int i = 0;
        while (isOver && i < explorers.size()) {
            if (explorers.get(i).getState() == State.EXPLORING) {
                isOver = false;
            }
            i++;
        }
        return isOver;
    }

    /**
     * Get the current cave the explorer are in
     *
     * @return The cave
     */
    @Override
    public Cave getCave() {
        return cave;
    }

    /**
     * Get the list of explorers to the game
     *
     * @return the list of explorers
     */
    @Override
    public List<Explorer> getExplorers() {
        return explorers;
    }

    /**
     * Get the list of explorers that are still exploring
     *
     * @return The explorer that are exploring
     */
    @Override
    public List<Explorer> getExploringExplorers() {
        exploringExplorers = new ArrayList<>();
        for (int i = 0; i < explorers.size(); i++) {
            if (explorers.get(i).getState() == State.EXPLORING) {
                exploringExplorers.add(explorers.get(i));
            }
        }
        return exploringExplorers;
    }

    /**
     * Change the state of the explorer to "LEAVING"
     *
     * @param explorer Name of the explorer that is taking the decision
     */
    @Override
    public void handleExplorerDecisionToLeave(Explorer explorer) {
        if (explorers.isEmpty()) {
            throw new GameException();
        }
        explorer.takeDecisionToLeave();
    }

    public Treasure getLastDiscoveredTreasure() {
        return cave.getLastDiscoveredTreasure();
    }

    /**
     * Consider if the number of explorer respect the rules.
     *
     * @throws GameException If the rules are not respected.
     */
    @Override
    public void start() {
        if (getExplorers().size() > 8) {
            throw new GameException();
        }
    }

    /**
     * Check the amount of player (explorer).
     *
     * @return True If 3 explorer or more are entered.
     */
    @Override
    public boolean isThereEnoughExplorer() {
        return getExplorers().size() >= 3;
    }

    /**
     * Verifie if you can enter a new player (explorer) to the game.
     *
     * @return true If you can add a new player (explorer).
     */
    @Override
    public boolean isItPossibleToAddExplorer() {
        return getExplorers().size() < 8;
    }

}
