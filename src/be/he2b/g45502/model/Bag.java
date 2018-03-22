package be.he2b.g45502.model;

/**
 *
 * @author square
 */
public class Bag {
    
    private int nbRubies;

    public Bag() {
        this.nbRubies = 0;
    }
    
    public void addRubies(int nbRubies){
        this.nbRubies += nbRubies;
    }
    /**
     * Get the amount of rubuies
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
