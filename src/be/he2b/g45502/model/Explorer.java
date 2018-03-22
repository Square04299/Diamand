package be.he2b.g45502.model;

import java.util.Objects;

/**
 *
 * @author square
 */
public class Explorer {


    private String pseudonym;
    private Bag bag;
    private State state;

    public Explorer(String pseudonym) {
        if (pseudonym == null) {
            throw new IllegalArgumentException("No name has been given");
        }
        this.pseudonym = pseudonym;
        this.bag = new Bag();
        this.state = State.EXPLORING;
    }
    /**
     * Get the name of the player
     * @return name of the player given
     */
    public String getPseudonym() {
        return pseudonym;
    }
    /**
     * Retreive the bag
     * @return Return the bag
     */
    public Bag getBag() {
        return bag;
    }
    /**
     * Get the State 
     * @return 
     */
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void addToBag(int nbRubies) {
        bag.addRubies(nbRubies);
    }

    public void takeDecisionToLeave() {
        setState(State.LEAVING);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.pseudonym);
        hash = 71 * hash + Objects.hashCode(this.bag);
        hash = 71 * hash + Objects.hashCode(this.state);
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
        final Explorer other = (Explorer) obj;
        if (!Objects.equals(this.pseudonym, other.pseudonym)) {
            return false;
        }
        if (!Objects.equals(this.bag, other.bag)) {
            return false;
        }
        return this.state == other.state;
    } 
}
