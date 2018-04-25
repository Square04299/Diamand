package be.he2b.g45502.model;

import java.util.List;

/**
 *
 * @author g44502
 */
public class Hazard implements Tile {
    private HazardType type;

    public Hazard(HazardType type) {
        this.type = type;
    }

    public HazardType getType() {
        return type;
    }


    @Override
    public void explore(List<Explorer> explorers) {
    }
}
