package be.he2b.g45502.controller;

import be.he2b.g45502.model.Game;
import be.he2b.g45502.model.Model;
import be.he2b.g45502.view.View;

/**
 *
 * @author square
 */
public class Controller {

    private Game game;
    private View view;

    /**
     * Contructor with attributes
     *
     * @param game Create the treasure and cave
     * @param view Create the text the player will see
     */
    public Controller(Game game, View view) {
        this.game = game;
        this.view = view;
    }

    /**
     * Will start the game. Will ask the name and amount of player and check if they want to continue or not will end the game if everyone is out of the cave
     */
    public void startGame() {
        boolean newExplorer = true;
        boolean choiceToContinue;

        while (game.isOver()) {
            while (newExplorer) {
                game.addExplorer(view.askExplorer());
                newExplorer = view.isThereNewExplorerToAdd();
            }
            game.moveForward();
            int nbExplorer = game.getExploringExplorers().size();
            for (int i = 0; i < nbExplorer; i++) {
                choiceToContinue = view.askExplorerChoiceToContinue(game.getExploringExplorers().get(i));
                if (!choiceToContinue) {
                    game.handleExplorerDecisionToLeave(game.getExploringExplorers().get(i));
                    i--;
                    nbExplorer--;
                }
            }       
            view.displayGame();
        }

    }

    public static void main(String[] args) {
        Game game = new Game();
        View view = new View(game);
        Controller diamant = new Controller(game, view);

        diamant.startGame();
    }
}
