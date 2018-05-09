package be.he2b.g45502.model;

import java.util.List;

/**
 *
 * @author square
 */
public class Relic implements Tile {

    private int valueInDiamonds;

    /**
     * Construtor of the class Relic will initialiser valueInDiamond to 1
     */
    public Relic() {
        this.valueInDiamonds = 1;
    }

    @Override
    public void explore(List<Explorer> explorers) {
        if (!explorers.isEmpty()) {
            for (Explorer explorer : explorers) {
                for (int i = 0; i < this.valueInDiamonds; i++) {
                    explorer.addToBag(Gem.DIAMOND);
                }
            }
        }
    }

    /**
     *
     * @param explorers
     * @return true if list contain 1 explorer and he is in the state of leaving
     */
    public boolean canBeTaken(List<Explorer> explorers) {
        return explorers.size() == 1 && explorers.get(0).getState().equals(State.LEAVING);
    }

    /**
     * Will chane the value of the diamond
     *
     * @param nbTakenRelics amount of relic found
     */
    public void convertGemValue(int nbTakenRelics) {
        if (nbTakenRelics >= 3) {
            this.valueInDiamonds = 2;
        }
    }

}
