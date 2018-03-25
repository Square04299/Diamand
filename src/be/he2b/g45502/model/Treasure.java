package be.he2b.g45502.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author square
 */
public class Treasure {

    private int rubies;
    private final int initNbRubies;

    public Treasure() {
        this.rubies = (int) Math.ceil(Math.random() * 15);
        this.initNbRubies = this.rubies;
    }

    public Treasure(int rubies) {
        this.initNbRubies = rubies;
        this.rubies = initNbRubies;

    }

    /**
     * Get the amount of rubies in the treasure
     *
     * @return The amount of rubies in the treasure
     */
    public int getRubies() {
        return rubies;
    }

    /**
     * Get the initial amount of rubies in the treasure
     *
     * @return The inital amount of rubies
     */
    public int getInitNbRubies() {
        return initNbRubies;
    }

    /**
     * Add a equal amount of rubies to all explorer that are on the treasure
     *
     * @param explorers List of explorer
     */
    public void explore(List<Explorer> explorers) {
        if (!explorers.isEmpty()) {
            List<Explorer> isExploring = new ArrayList<>();
            for (int i = 0; i < explorers.size(); i++) {
                if (explorers.get(i).getState() == State.EXPLORING) {
                    isExploring.add(explorers.get(i));
                }
            }
            int rubiesToGiven = initNbRubies / isExploring.size();
            rubies = initNbRubies - isExploring.size() * rubiesToGiven;
            for (Explorer explorer : isExploring) {
                explorer.addToBag(rubiesToGiven);
            }
        }
    }

}
