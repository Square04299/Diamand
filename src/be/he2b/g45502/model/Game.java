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
    private final int MAXPLAYER;
    private final int MINPLAYER;

    /**
     * Contructor Game will create the cave and the list of player
     */
    public Game() {
        this.cave = new Cave();
        this.explorers = new ArrayList();
        this.MAXPLAYER = 8;
        this.MINPLAYER = 3;
    }

    @Override
    public void addExplorer(Explorer explorer) {
        if (getExplorers().size() < MAXPLAYER) {
            explorers.add(explorer);
        } else {
            throw new GameException("Too much player");
        }
    }

    @Override
    public void moveForward() {
        cave.getCurrentEntrance().discorverNewTile(getExploringExplorers());
        if (cave.getCurrentEntrance().isUnsafe()) {
            for (Explorer explorer : getExploringExplorers()) {
                explorer.runAway();
            }
        }
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
        List<Explorer> exploringExplorers = new ArrayList<>();
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
     * Check what is the last treasure you discord of the current entrance
     *
     * @return the last treasure discovered
     */
    public Tile getLastDiscoveredTreasure() {
        return cave.getCurrentEntrance().getLastDiscoveredTile();
    }

    @Override
    public void start() {
        if (getExplorers().size() > MAXPLAYER) {
            throw new GameException();
        }
    }

    @Override
    public boolean isThereEnoughExplorer() {
        return getExplorers().size() >= MINPLAYER;
    }

    @Override
    public boolean isItPossibleToAddExplorer() {
        return getExplorers().size() < MAXPLAYER;
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
        List<Explorer> leavingExplorer = new ArrayList<>();
        this.cave.getCurrentEntrance().makeLastTileExplored();
        for (Explorer explorer : getExplorers()) {
            if (explorer.getState() == State.LEAVING) {
                leavingExplorer.add(explorer);
            }
        }
        this.cave.getCurrentEntrance().returnToCamp(leavingExplorer);
        for (Explorer explorer : getExplorers()) {
            if (explorer.getState() == State.LEAVING) {
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
        cave.lockOutCurrentEntrance();
        Tile danger = cave.getCurrentEntrance().getLastDiscoveredTile();
        if ((danger instanceof Hazard) && !((Hazard) danger).isExplorersEscapeReason()) {
            for (Tile tile : cave.getCurrentEntrance().getPath()) {
                if (tile instanceof Treasure) {
                    ((Treasure) tile).restore();
                }
                cave.getDeck().putBack(tile);
            }

        }

    }

    @Override
    public boolean isOver() {
        return (!cave.hasNewEntranceToExplore());
    }

    @Override
    public boolean isExploreationPhaseAborted() {
        return cave.isLastEntranceUnsafe();
    }

}
