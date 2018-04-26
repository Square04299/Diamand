package be.he2b.g45502.model;

/**
 * State in which the player is
 * @author 45502
 */
public enum State {

    /**
     * Player is in the cave
     */
    EXPLORING,
    /**
     * Player wants to leave the cave
     */
    LEAVING,
    /**
     * Player that left the cave and are on the camping
     */
    CAMPING;
}
