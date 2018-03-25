package be.he2b.g45502.controller;

import be.he2b.g45502.model.Game;
import be.he2b.g45502.model.Model;
import be.he2b.g45502.view.View;

/**
 *
 * @author square
 */
public class Controller {
    private Model game;
    private View view;

    public Controller(Model game, View view) {
        this.game = new Game();
        this.view = new View(game);
    }
    
    public void startGame(){
        
        boolean newExplorer = true;
        boolean choiceToContinue;
        
        while (game.isOver()) {            
            while (newExplorer) {            
                game.addExplorer(view.askExplorer());
                newExplorer = view.isThereNewExplorerToAdd();
            }
            game.moveForward();
            for (int i = 0; i < game.getExploringExplorers().size(); i++) {
                choiceToContinue = view.askExplorerChoiceToContinue(game.getExploringExplorers().get(i));
                if (!choiceToContinue) {
                    game.handleExplorerDecisionToLeave(game.getExploringExplorers().get(i));
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
