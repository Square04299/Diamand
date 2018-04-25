package be.he2b.g45502.model;

import java.util.List;

/**
 *
 * @author 45502
 */
public class Treasure implements Tile {

    private int rubies;
    private final int initNbRubies;

    /**
     * Constructor witout attribute Will generate a random number of rubies
     * between 1 and 15 to add to the treasure
     */
    public Treasure() {
        this.rubies = (int) Math.ceil(Math.random() * 15);
        this.initNbRubies = this.rubies;
    }

    /**
     * Constructor with attribute
     *
     * @param rubies Fixed number of rubies in the Treasure
     */
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
    @Override
    public void explore(List<Explorer> explorers) {
        if (!explorers.isEmpty()) {
            int rubiesPerExplorer = initNbRubies / explorers.size();
            this.rubies = this.initNbRubies % explorers.size();
            for (int i = 0; i < explorers.size(); i++) {
                explorers.get(i).addToBag(rubiesPerExplorer);
            }
        }
    }

    @Override
    public String toString() {
        return "" + rubies;
    }

    /**
     * Reset the treasure to the initial amount
     */
    public void restore(){
        rubies = initNbRubies;
    }
}
