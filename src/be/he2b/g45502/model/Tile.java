package be.he2b.g45502.model;

import java.util.List;

/**
 *
 * @author g45502
 */
public interface Tile {

    /**
     * Add a equal amount of rubies to all explorer that are on the treasure
     *
     * @param explorers List of explorer
     */
    void explore(List<Explorer> explorers);

}
