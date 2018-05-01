package be.he2b.g45502.view;

import be.he2b.g45502.model.Explorer;
import be.he2b.g45502.model.Game;
import be.he2b.g45502.model.Hazard;
import be.he2b.g45502.model.Tile;
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
        System.out.println(Color.toPurple("Name of the Explorer"));
        e = new Explorer(in.next());
        return e;
    }

    /**
     * Check if you want to add another player
     *
     * @return True if there is another player to add
     */
    public boolean isThereNewExplorerToAdd() {
        System.out.println(Color.toPurple("Want to add another player ?"));
        String response = in.next();
        String toUpperCase = response.toUpperCase();

        while (!toUpperCase.equals("YES") && !toUpperCase.equals("NO")) {
            System.out.println("");
            System.out.println(Color.toRed("Answer either \"YES\" or \"NO\" "));
            System.out.println("");
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
        System.out.println(Color.toBlue(explorer.getPseudonym() + " do you want to continue ?"));
        String response = in.next();
        System.out.println("");
        String toUpperCase = response.toUpperCase();

        while (!toUpperCase.equals("YES") && !toUpperCase.equals("NO")) {
            System.out.println(Color.toRed("Answer either \"YES\" or \"NO\" !!"));
            System.out.println(Color.toBlue(explorer.getPseudonym() + " do you want to continue ?"));
            response = in.next();
            System.out.println("");
            toUpperCase = response.toUpperCase();
        }
        return toUpperCase.contains("YES");
    }

    /**
     * Display the current state of the game with the name and amount of rubies
     * each player own in they bags
     */
    public void displayGame() {
        System.out.println(Color.toYellow("-------------------"));
        System.out.println("");
        if (game.getCave().getCurrentEntrance().getLastDiscoveredTile() instanceof Treasure) {
            System.out.println(Color.toBlue("Last treasure discovered : ")
                    + ((Treasure) game.getCave().getCurrentEntrance().getLastDiscoveredTile()).getInitNbRubies());
        } else {
            System.out.println(Color.toRed("Last danger discovered : ")
                    + ((Hazard) game.getCave().getCurrentEntrance().getLastDiscoveredTile()).getType());
        }
        System.out.println("");
        for (Explorer explorer : game.getExplorers()) {
            System.out.println(Color.toGreen(explorer.getPseudonym()) + " : " + Color.toPurple(explorer.getNbRubies() + " rubies"));
            System.out.println(Color.toBlue("State :") + explorer.getState());
        }
        System.out.println("");
    }

    /**
     * Display the end screen with the total amount of rubies each player has
     */
    public void displayWinner() {
        System.out.println(Color.toGreen("Winner"));
        System.out.println(Color.toGreen("Name : " + game.getWinner()));
        System.out.println(Color.toPurple("Rubies : " + game.getWinner().getFortune()));
        System.out.println("");
        System.out.println("Thank you for playing");
        System.out.println("");
    }

    /**
     * Display the path and the current state of all player
     */
    public void turnResumeDisplay() {
        System.out.print(game.getCave().getCurrentEntrance().getPath());

    }

    /**
     * Display when you have incountered to many danger
     */
    public void displayRunAway() {
        System.out.println(Color.toRed("The exploration has ended"));
        System.out.println("");
    }

    /**
     * Display in with cave you are
     */
    public void getWhereAreExplorerCave() {
        System.out.println(Color.toYellow("-------------------"));
        System.out.println(Color.toYellow("Cave N°" + (game.getCave().getNbExploredEntrance() + 1)));
    }

}
