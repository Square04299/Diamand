package be.he2b.g45502.model;

/**
 * Save your rubies
 * @author Square
 */
public class Chest extends Bag {

    public Chest() {
        super();
    }
    
    public void saveBag(Bag bag){
        this.gems.addAll(bag.getGems());
    }
    
    
    
}
