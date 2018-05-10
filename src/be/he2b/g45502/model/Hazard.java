package be.he2b.g45502.model;

import java.util.List;

/**
 * Generate danger
 *
 * @author g44502
 */
public class Hazard implements Tile {

    private final HazardType type;
    private boolean explorersEscapeReason;

    /**
     * Constructor
     *
     * @param type Danger
     */
    public Hazard(HazardType type) {
        this.type = type;
        this.explorersEscapeReason = false;
    }

    /**
     * Get the type of danger
     *
     * @return Type of danger
     */
    public HazardType getType() {
        return type;
    }

    /**
     * Check with danger will make the explorers leave the cave
     *
     * @return true if the danger makes the player leave
     */
    public boolean isExplorersEscapeReason() {
        return explorersEscapeReason;
    }

    /**
     * Change the variable explorersEscapeReason to true
     */
    public void escape() {
        explorersEscapeReason = true;
    }

    @Override
    public void explore(List<Explorer> explorers) {
    }

}
