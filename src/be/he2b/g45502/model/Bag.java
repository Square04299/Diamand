package be.he2b.g45502.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author 45502
 */
public class Bag {

    protected List<Gem> gems;

    /**
     * Contructor with no attribute Will initialise the amount of gems
     */
    public Bag() {
        this.gems = new ArrayList<>();
    }

    /**
     * Add gem to the bag of the player
     *
     * @param gem Number of gems to add
     */
    public void addGems(Gem gem) {
        this.gems.add(gem);
    }

    /**
     * Get the list of gems
     *
     * @return return the gems
     */
    public List<Gem> getGems() {
        return gems;
    }

    /**
     * Set the bad to 0 rubies
     */
    public void loseContent() {
        this.gems.clear();
    }
    
    public int getValue(){
        int somme = 0;
        for (Gem gem : gems) {
            somme += gem.getValue();
        }
        return somme;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.gems);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bag other = (Bag) obj;
        if (!Objects.equals(this.gems, other.gems)) {
            return false;
        }
        return true;
    }

    
}
