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
    
    public Explorer askExplorer(){
        System.out.println("Name of the new Explorer");
        Explorer e = new Explorer(in.nextLine());
        return e;
    }
    
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
    
    public void displayGame(){
        System.out.println("Last tile discovered : " 
                + game.getCave().getLastDiscoveredTreasure());
        for (int i = 0; i < game.getExplorers().size(); i++) {
            System.out.println(game.getExplorers().get(i).getPseudonym() + " : "
                    + game.getExplorers().get(i).getBag().getNbRubies());
        }
    }
    
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
