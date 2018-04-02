package be.he2b.g45502.model;

/**
 *
 * @author square
 */
public class GameException extends RuntimeException {

    /**
     * Creates a new instance of <code>GameException</code> without detail
     * message.
     */
    public GameException() {
    }

    /**
     * Constructs an instance of <code>GameException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public GameException(String msg) {
        super(msg);
    }
}
