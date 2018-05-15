package be.he2b.g45502.controller;

import be.he2b.g45502.model.Explorer;
import be.he2b.g45502.model.Game;
import be.he2b.g45502.view.View;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author g45502
 */
public class ControllerTest {

    /**
     * Test of isInvalidName method, of class Controller.
     */
    @Test
    public void testIsInvalidName_valid() {
        System.out.println("isInvalidName_valid");
        Game game = new Game();
        View view = new View(game);
        int i = 0;
        Explorer explorer1 = new Explorer("e1");
        Explorer explorer2 = new Explorer("e2");
        Explorer explorer3 = new Explorer("e3");
        Explorer explorer4 = new Explorer("e4");
        
        List<Explorer> checkName = new ArrayList<>();
        checkName.add(explorer1);
        checkName.add(explorer2);
        checkName.add(explorer3);
        checkName.add(explorer4);
        
        Explorer validName = new Explorer("e5");
        
        Controller instance = new Controller(game, view);
        boolean expResult = false;
        boolean result = instance.isInvalidName(checkName, validName, i);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isInvalidName method, of class Controller.
     */
    @Test
    public void testIsInvalidName_invalid() {
        System.out.println("isInvalidName_invalid");
        Game game = new Game();
        View view = new View(game);
        int i = 0;
        Explorer explorer1 = new Explorer("e1");
        Explorer explorer2 = new Explorer("e2");
        Explorer explorer3 = new Explorer("e3");
        Explorer explorer4 = new Explorer("e4");
        
        List<Explorer> checkName = new ArrayList<>();
        checkName.add(explorer1);
        checkName.add(explorer2);
        checkName.add(explorer3);
        checkName.add(explorer4);
        
        Explorer validName = new Explorer("e1");
        
        Controller instance = new Controller(game, view);
        boolean expResult = true;
        boolean result = instance.isInvalidName(checkName, validName, i);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isInvalidName method, of class Controller.
     */
    @Test
    public void testIsInvalidName_first() {
        System.out.println("isInvalidName_first");
        Game game = new Game();
        View view = new View(game);
        int i = 0;
        Explorer explorer1 = new Explorer("e1");
        
        List<Explorer> checkName = new ArrayList<>();
        checkName.add(explorer1);
        
        Explorer validName = new Explorer("e1");
        
        Controller instance = new Controller(game, view);
        boolean expResult = true;
        boolean result = instance.isInvalidName(checkName, validName, i);
        assertEquals(expResult, result);
    }
    
}
