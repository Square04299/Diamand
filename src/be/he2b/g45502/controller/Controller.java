package be.he2b.g45502.controller;

import be.he2b.g45502.model.Explorer;
import be.he2b.g45502.model.Game;
import be.he2b.g45502.view.View;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 45502
 */
public class Controller {

    private final Game game;
    private final View view;
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

        Explorer namePlayerChecking;
        List<Explorer> checkName = new ArrayList<>();
        int i = 0;

        while (!game.isThereEnoughExplorer() || newExplorer) {

            namePlayerChecking = view.askExplorer();
            System.out.println("Ask 1");
            checkName.add(namePlayerChecking);
            if (checkName.size() != 1) {
               while (isInvalidName(checkName, namePlayerChecking, i)){
                   view.playerAlreadyExist();
                    namePlayerChecking = view.askExplorer();
                    System.out.println("Ask 2");
                    checkName.add(namePlayerChecking);
                    checkName.remove(i);
                    for (Explorer explorer : checkName) {
                        System.out.println(explorer.getPseudonym());
                   }
                } 
            }else{
                game.addExplorer(namePlayerChecking);
            }
            i++;
              
System.out.println("pass checking");
            if (game.isItPossibleToAddExplorer() && game.isThereEnoughExplorer()) {
                newExplorer = view.isThereNewExplorerToAdd();
            } else {
                newExplorer = false;
            }
        }

        while (!game.isOver()) {
            game.startNewExplorationPhase();
            view.getWhereAreExplorerCave();
            while (!game.isExplorationPhaseOver() && !game.isExploreationPhaseAborted()) {
                game.moveForward();
                view.displayGame();
                if (!game.isExploreationPhaseAborted()) {
                    for (Explorer explorer : game.getExploringExplorers()) {
                        choiceToContinue = view.askExplorerChoiceToContinue(explorer);
                        if (!choiceToContinue) {
                            game.handleExplorerDecisionToLeave(explorer);
                        }
                    }
                }

                game.makeExplorersLeave();
            }
            view.displayRunAway();
            game.endExplorationPhase();
        }
        view.displayWinner();
    }

    public boolean isInvalidName(List<Explorer> checkName, Explorer validName, int j) {
        boolean invalideName = false;
        for (int i = j; i < checkName.size(); i++) {
            if (!invalideName) {
                if (checkName.get(i).equals(validName)) {
                    invalideName = true;
                }
            }
        }
        return invalideName;
    }

}
