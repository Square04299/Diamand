package be.he2b.g45502.model;

/**
 *
 * @author 45502
 */
public class Bag {

    private int nbRubies;

    /**
     * Contructor with no attribute Will initialise the amount of rubies in the
     * bag to 0
     */
    public Bag() {
        this.nbRubies = 0;
    }

    /**
     * Add rubies to the bag of the player
     *
     * @param nbRubies Number of rubies to add
     */
    public void addRubies(int nbRubies) {
        this.nbRubies += nbRubies;
    }

    /**
     * Get the amount of rubuies
     *
     * @return return the amount of rubies
     */
    public int getNbRubies() {
        return nbRubies;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.nbRubies;
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
        return this.nbRubies == other.nbRubies;
    }
}
