package be.he2b.g45502.view;

import be.he2b.g45502.model.Explorer;
import be.he2b.g45502.model.Game;
import be.he2b.g45502.model.Hazard;
import be.he2b.g45502.model.Treasure;
import java.util.Scanner;

/**
 *
 * @author 45502
 */
public class View {

    private final Scanner in;
    private final Game game;
    private Explorer e;

    /**
     * Create an other View with the model Game
     *
     * @param game instance of the game
     */
    public View(Game game) {
        this.in = new Scanner(System.in);
        this.game = game;
    }

    /**
     * Ask the name of the explorer
     *
     * @return The name added
     */
    public Explorer askExplorer() {
        System.out.println("Name of the new Explorer");
        e = new Explorer(in.next());
        return e;
    }

    /**
     * Check if you want to add another player
     *
     * @return True if there is another player to add
     */
    public boolean isThereNewExplorerToAdd() {
        System.out.println("Is there a new Explorer to add to the game");
        System.out.println("\"YES\" or \"NO\"");
        String response = in.next();
        String toUpperCase = response.toUpperCase();

        while (!toUpperCase.equals("YES") && !toUpperCase.equals("NO")) {
            System.out.println("The response need to be \"YES\" or \"NO\" !!");
            System.out.println("Is there a new Explorer to add to the game");
            response = in.next();
            toUpperCase = response.toUpperCase();
        }
        return toUpperCase.equals("YES");
    }

    /**
     * Ask if the explorer wants to continue exploring
     *
     * @param explorer Explorer we are asking the question
     * @return True if he wants to continue
     */
    public boolean askExplorerChoiceToContinue(Explorer explorer) {
        System.out.println(explorer.getPseudonym() + " do you want to continue ?");
        System.out.println("\"YES\" or \"NO\"");
        String response = in.next();
        String toUpperCase = response.toUpperCase();

        while (!toUpperCase.equals("YES") && !toUpperCase.equals("NO")) {
            System.out.println("The response need to be \"YES\" or \"NO\" !!");
            System.out.println(explorer.getPseudonym() + " do you want to continue ?");
            response = in.next();
            toUpperCase = response.toUpperCase();
        }
        return toUpperCase.contains("YES");
    }

    /**
     * Display the current state of the game with the name and amount of rubies
     * each player own in they bags
     */
    public void displayGame() {
        if (game.getCave().getCurrentEntrance().getLastDiscoveredTile() instanceof Treasure) {
            System.out.println("Last treasure discovered : "
                    + ((Treasure) game.getCave().getCurrentEntrance().getLastDiscoveredTile()).getInitNbRubies());
        } else {
            System.out.println("Last danger discovered : "
                    + ((Hazard) game.getCave().getCurrentEntrance().getLastDiscoveredTile()).getType());
        }

        for (Explorer explorer : game.getExplorers()) {
            System.out.println(explorer.getPseudonym() + " : " + explorer.getNbRubies());
        }
    }

    /**
     * Display the end screen with the total amount of rubies each player has
     */
    public void displayWinner() {
        System.out.println("Thank you for playing");
        System.out.println("Winner");
        System.out.println("Name : " + game.getWinner());
        System.out.println("Rubis : " + game.getWinner().getFortune());
    }

    /**
     * Display the path and the current state of all player
     */
    public void turnResumeDisplay() {
        for (int i = 0; i < game.getCave().getCurrentEntrance().getPath().size(); i++) {
            System.out.println("Treasure " + i + ": " + game.getCave().getCurrentEntrance().getPath().get(i));
        }
        for (Explorer explorer : game.getExplorers()) {
            System.out.println("Explorer :" + explorer);
            System.out.println("State :" + explorer.getState());
        }
    }

    /**
     * Display when you have incountered to many danger
     */
    public void displayRunAway() {
        System.out.println("The exploration has ended");
    }

}
