package be.he2b.g45502.model;

/**
 * Save your rubies
 *
 * @author Square
 */
public class Chest extends Bag {

    /**
     * Construtor of the class Chest
     */
    public Chest() {
        super();
    }

    /**
     * Save the gems found and put them into the explorer's bag
     *
     * @param bag the bag of the current player
     */
    public void saveBag(Bag bag) {
        this.gems.addAll(bag.getGems());
    }

}
