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
    private Chest chest;

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
        this.state = State.CAMPING;
        this.chest = new Chest();
    }

    /**
     * Getter of the variable chest
     *
     * @return
     */
    public Chest getChest() {
        return chest;
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
     * @return State of the player
     */
    public State getState() {
        return state;
    }

    /**
     * Add a amount of rubbies to the bag
     *
     * @param gem Number of gem to add
     */
    public void addToBag(Gem gem) {
        bag.addGems(gem);
    }

    /**
     * Set the State of the explorer to leave
     */
    public void takeDecisionToLeave() {
        this.state = State.LEAVING;
    }

    /**
     * Get the amount of rubies of the explorer
     *
     * @return The amount of rubies
     */
    public int getFortune() {
        return bag.getValue();
    }

    /**
     * Set the State of the explorer to camping
     */
    public void reachCamp() {
        this.state = State.CAMPING;
        this.chest.saveBag(this.bag);
        this.bag.gems.clear();
    }

    /**
     * Change the state of explorer to
     */
    public void startExploration() {
        this.state = State.EXPLORING;
    }

    /**
     * Lose content of bag and go back to camp
     */
    public void runAway() {
        this.bag.loseContent();
        this.reachCamp();
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
