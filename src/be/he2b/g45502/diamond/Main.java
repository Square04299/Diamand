package be.he2b.g45502.diamond;

import be.he2b.g45502.controller.Controller;
import be.he2b.g45502.model.Game;
import be.he2b.g45502.view.View;

/**
 *
 * @author 45502
 */
public class Main {

    /**
     * Will launch the game
     *
     * @param args
     */
    public static void main(String[] args) {
        Game game = new Game();
        View view = new View(game);
        Controller diamant = new Controller(game, view);

        diamant.startGame();
    }
}
