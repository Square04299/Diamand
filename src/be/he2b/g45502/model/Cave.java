package be.he2b.g45502.model;

/**
 *
 * @author 45502
 */
public class Cave {

    private int nbExploredEntrance;
    private CaveEntrance currentEntrance;
    private final Deck deck;
    private int nbTakenRelics;

    /**
     * Controctor set the nbExploredEntrance to 0
     */
    public Cave() {
        this.nbExploredEntrance = 0;
        this.deck = new Deck();
        this.nbTakenRelics = 0;
    }

    public int getNbTakenRelics() {
        return nbTakenRelics;
    }

    /**
     * Get deck
     *
     * @return the deck
     */
    public Deck getDeck() {
        return this.deck;
    }

    /**
     * Get the amount of Cave explored
     *
     * @return amount of cave explored
     */
    public int getNbExploredEntrance() {
        return nbExploredEntrance;
    }

    /**
     * Get the currentEntrance
     *
     * @return CurrentEntrance
     */
    public CaveEntrance getCurrentEntrance() {
        return currentEntrance;
    }

    /**
     * Check if they is a entrance too be added
     *
     * @return true if less then 5
     */
    public boolean hasNewEntranceToExplore() {
        return this.nbExploredEntrance < 5;

    }

    /**
     * Open a new entrance
     *
     * @throws GameException if 5 cave already open or last phase didn't end
     */
    public void openNewEntrance() {
        if (this.currentEntrance != null && !this.currentEntrance.isLockedOut()) {
            throw new GameException("The last phase isn't over");
        }
        if (!hasNewEntranceToExplore()) {
            throw new GameException("You already have 5 cave open");
        }
        this.currentEntrance = new CaveEntrance(this);
    }

    /**
     * LockOut the currentEntrance
     *
     * @throws GameException if no game phase was found
     */
    public void lockOutCurrentEntrance() {
        if (nbExploredEntrance == 5 && getCurrentEntrance().isLockedOut()) {
            throw new GameException("No game phase in progress found");
        }
        currentEntrance.lockOut();
        this.nbExploredEntrance++;
    }

    /**
     * check if the last entrance is lockedout
     *
     * @return true if safe
     */
    public boolean isLastEntranceUnsafe() {
        return this.currentEntrance.isUnsafe();
    }
    
    public void incrementNbTakenRelics(){
        this.nbTakenRelics ++;
    }
}
