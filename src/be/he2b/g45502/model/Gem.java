package be.he2b.g45502.model;

/**
 * Types of relic
 *
 * @author square
 */
public enum Gem {

    /**
     * Relic type ruby
     */
    RUBY(1),
    /**
     * Relic type diamond
     */
    DIAMOND(5);

    private final int value;

    private Gem(int value) {
        this.value = value;
    }

    /**
     * Get the value of the Gem
     *
     * @return Value of the Gem
     */
    public int getValue() {
        return value;
    }

}
