package be.he2b.g45502.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 45502
 */
public class Treasure implements Tile {

    private final List<Gem> gems;
    private final int initNbGems;

    /**
     * Constructor with attribute
     *
     * @param rubies Fixed number of gems in the Treasure
     */
    public Treasure(int rubies) {
        this.initNbGems = rubies;
        this.gems = new ArrayList<>();
        for (int i = 0; i < initNbGems; i++) {
            gems.add(Gem.RUBY);
        }

    }

    /**
     * List of gems and return them
     *
     * @return List of gems
     */
    public List<Gem> getGems() {
        return gems;
    }

    /**
     * Get the initial amount of gems in the treasure
     *
     * @return The inital amount of gems
     */
    public int getInitNbRubies() {
        return initNbGems;
    }

    @Override
    public void explore(List<Explorer> explorers) {
        if (!explorers.isEmpty()) {
            int rubiesPerExplorer = gems.size() / explorers.size();
            for (Explorer explorer : explorers) {
                for (int i = 0; i < rubiesPerExplorer; i++) {
                    explorer.addToBag(gems.get(0));
                    gems.remove(0);
                }
//                for (Gem gemGive : gems) {
//                    explorer.addToBag(gemGive);
//                    gems.remove(gemGive);
//                }
                
            }
        }
    }

    @Override
    public String toString() {
        return "" + gems;
    }

    /**
     * Reset the treasure to the initial amount
     */
    public void restore() {
        while (gems.size() < initNbGems) {
            gems.add(Gem.RUBY);
        }
    }

    /**
     * Add all your gems to your bag
     *
     * @param o
     */
    public void transferGemsFrom(Treasure o) {
        this.gems.addAll(o.gems);
        o.gems.clear();
    }
}
