package be.he2b.g45502.model;

import java.util.Objects;

/**
 *
 * @author 45502
 */
public class Explorer {

    private String pseudonym;
    private Bag bag;
    private State state;

    /**
     * Constructor with attribute
     *
     * @param pseudonym Name of the explorer
     */
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
     *
     * @return name of the player given
     */
    public String getPseudonym() {
        return pseudonym;
    }

    /**
     * Retreive the bag
     *
     * @return Return the bag
     */
    public Bag getBag() {
        return bag;
    }

    /**
     * Get the State
     *
     * @return
     */
    public State getState() {
        return state;
    }

    /**
     * Going to set the state of the explorer
     *
     * @param state New state he is going to be in
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * Get the amount of rubies in the bag
     *
     * @return Nomber of rubies
     */
    public int getNbRubies() {
        return bag.getNbRubies();
    }

    /**
     * Add a amount of rubbies to the bag
     *
     * @param nbRubies Number of rubies to add
     */
    public void addToBag(int nbRubies) {
        bag.addRubies(nbRubies);
    }

    /**
     * Set the State of the explorer to leave
     */
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
