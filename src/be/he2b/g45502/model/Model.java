package be.he2b.g45502.model;

import java.util.List;

/**
 * Facade of Diamant.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Facade_pattern">
 * Facade pattern
 * </a>
 * @see
 * <a href="https://fr.wikipedia.org/wiki/Fa%C3%A7ade_(patron_de_conception)">
 * Façade (patron de conception)
 * </a>
 * @author EsiProf
 */
public interface Model {

    /**
     * This methode can be used to add new player (explorer) in the game.
     *
     * @param explorer the explorer to add.
     * @throws GameException If you can't enter anymore player.
     */
    void addExplorer(Explorer explorer);

    /**
     * Make all exploring explorers move forward in the cave. The explorers
     * share what they found.
     */
    void moveForward();

    /**
     * Declares if it's the end of the game.
     *
     * @return true if it's the end of the game.
     */
    boolean isExplorationPhaseOver();

    /**
     * Return the cave of the game.
     *
     * @return the game's cave.
     */
    Cave getCave();

    /**
     * Give all explorers of the game. They could be exploring or leaving.
     *
     * @return all the explorers of the game.
     */
    List<Explorer> getExplorers();

    /**
     * Give all explorers which are exploring.
     *
     * @return explorers in the cave.
     */
    List<Explorer> getExploringExplorers();

    /**
     * Consider the choice of the explorer to leave the cave.
     *
     * @param explorer The explorer who make the choice to leave.
     * @throws RuntimeException If the explorer is not in the current game.
     */
    void handleExplorerDecisionToLeave(Explorer explorer);

    /**
     * Consider if the number of explorer respect the rules.
     *
     * @throws GameException If the rules are not respected.
     */
    void start();

    /**
     * Check the amount of player (explorer).
     *
     * @return True If 3 explorer or more are entered.
     */
    boolean isThereEnoughExplorer();

    /**
     * Verifie if you can enter a new player (explorer) to the game.
     *
     * @return true If you can add a new player (explorer).
     */
    boolean isItPossibleToAddExplorer();
    
    /**
     * Check the winner of the game
     * @return The explorer with the biggest Forturne
     * @exception GameException if it's called before the end of the game
     */
    Explorer getWinner();
    
    /**
     * Make Explorer to leave the cave and go back to camp
     */
    void makeExplorersLeave();
    
    /**
     * Create a new entrance to the cave change the state of explorer
     */
    void startNewExplorationPhase();
    
    /**
     * End the exploration phase and lockout the current cave
     */
    void endExplorationPhase();
    
    /**
     * Check if there is any Entrance that can be open
     * @return true if game is over
     */
    boolean isOver();
}
