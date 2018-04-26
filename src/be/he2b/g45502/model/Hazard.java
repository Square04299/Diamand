package be.he2b.g45502.model;

import java.util.List;

/**
 * Generate danger
 *
 * @author g44502
 */
public class Hazard implements Tile {

    private final HazardType type;

    /**
     * Constructor
     *
     * @param type Danger
     */
    public Hazard(HazardType type) {
        this.type = type;
    }

    /**
     * Get the type of danger
     *
     * @return Type of danger
     */
    public HazardType getType() {
        return type;
    }

    @Override
    public void explore(List<Explorer> explorers) {
    }
}
