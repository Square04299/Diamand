package be.he2b.g45502.controller;

import be.he2b.g45502.model.Explorer;
import be.he2b.g45502.model.Game;
import be.he2b.g45502.view.View;

/**
 *
 * @author 45502
 */
public class Controller {

    private Game game;
    private View view;
    private boolean newExplorer;
    private boolean choiceToContinue;

    /**
     * Contructor with attributes
     *
     * @param game Create the treasure and cave
     * @param view Create the text the player will see
     */
    public Controller(Game game, View view) {
        this.game = game;
        this.view = view;
        this.newExplorer = true;
    }

    /**
     * Will start the game. Will ask the name and amount of player and check if
     * they want to continue or not will end the game if everyone is out of the
     * cave
     */
    public void startGame() {

        while (!game.isThereEnoughExplorer() || newExplorer ) {
            game.addExplorer(view.askExplorer());
            if (game.isItPossibleToAddExplorer()) {
                newExplorer = view.isThereNewExplorerToAdd();
            }else{
                newExplorer = false;
            }
        }

        while (!game.isOver()) {
            game.moveForward();
            view.displayGame();
            for (Explorer explorer : game.getExploringExplorers()) {
                choiceToContinue = view.askExplorerChoiceToContinue(explorer);
                if (!choiceToContinue) {
                    game.handleExplorerDecisionToLeave(explorer);
                }
            }
        }
        view.displayWinner();
    }

}
