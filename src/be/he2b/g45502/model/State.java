package be.he2b.g45502.model;

/**
 * @enum EXPLORING Player that are still in the cave
 * @enum LEAVING Player that left the cave
 * @enum CAMPING Player that left the cave and saw the path
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
