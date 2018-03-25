package be.he2b.g45502.view;

import be.he2b.g45502.model.Explorer;
import be.he2b.g45502.model.Game;
import be.he2b.g45502.model.Model;
import java.util.Scanner;

/**
 *
 * @author square
 */
public class View {
    
    private Scanner in;
    private Model game;

    public View(Model game) {
        this.in = new Scanner(System.in);
        this.game = new Game();
    }
    /**
     * Ask the name of the explorer
     * @return The name added
     */
    public Explorer askExplorer(){
        System.out.println("Name of the new Explorer");
        Explorer e = new Explorer(in.nextLine());
        return e;
    }
    /**
     * Check if you want to add another player
     * @return True if there is another player to add
     */
    public boolean isThereNewExplorerToAdd(){
        System.out.println("Is there a new Explorer to add to the game");
        System.out.println("\"YES\" or \"NO\"");
        String response = in.nextLine();
        String toUpperCase = response.toUpperCase();
        
        while (!toUpperCase.equals("YES") || !toUpperCase.equals("NO")) {            
            System.out.println("The response need to be \"YES\" or \"NO\" !!");
            System.out.println("Is there a new Explorer to add to the game");
            response = in.nextLine();
            toUpperCase = response.toUpperCase();
        }
        return toUpperCase.equals("YES");
    }
    /**
     * Ask if the explorer wants to continue exploring
     * @param explorer Explorer we are asking the question
     * @return True if he wants to continue
     */
    public boolean askExplorerChoiceToContinue(Explorer explorer){
        System.out.println(explorer.getPseudonym() + 
                " do you want to continue ?");
        System.out.println("\"YES\" or \"NO\"");
        String response = in.nextLine();
        String toUpperCase = response.toUpperCase();
        
        while (!toUpperCase.equals("YES") || !toUpperCase.equals("NO")) {            
            System.out.println("The response need to be \"YES\" or \"NO\" !!");
            System.out.println(explorer.getPseudonym() + 
                    " do you want to continue ?");
            response = in.nextLine();
            toUpperCase = response.toUpperCase();
        }
        return toUpperCase.equals("YES");
    }
    /**
     * Display the current state of the game with the name and amount of rubies each player own in they bags
     */
    public void displayGame(){
        System.out.println("Last tile discovered : " 
                + game.getCave().getLastDiscoveredTreasure());
        for (int i = 0; i < game.getExplorers().size(); i++) {
            System.out.println(game.getExplorers().get(i).getPseudonym() + " : "
                    + game.getExplorers().get(i).getBag().getNbRubies());
        }
    }
    /**
     * Display the end screen with the total amount of rubies each player has
     */
    public void displayEnd(){
        System.out.println("Thank you for playing");
        System.out.println("Score : ");
        for (int i = 0; i < game.getExplorers().size(); i++) {
            System.out.println("Name : " 
                    + game.getExplorers().get(i).getPseudonym());
            System.out.println("Rubis : " 
                    + game.getExplorers().get(i).getBag().getNbRubies());
        }
    }
 
}
