package be.he2b.g45502;

import be.he2b.g45502.model.State;
import be.he2b.g45502.model.Explorer;
import org.junit.Test;
import static org.junit.Assert.*;
public class ExplorerTest {

    @Test
    public void getPseudonyme() {
        Explorer explorer = new Explorer("Sdr");
        assertEquals("Sdr", explorer.getPseudonym());
    }

    @Test
    public void getStateBeforeTakeDecisionToLeave() {
        Explorer explorer = new Explorer("Sdr");
        assertEquals(State.CAMPING, explorer.getState());
    }

    @Test
    public void getStateAftertakeDecisionToLeave() {
        Explorer explorer = new Explorer("Sdr");
        explorer.takeDecisionToLeave();
        assertEquals(State.LEAVING, explorer.getState());
    }

    @Test
    public void getBagBeforAddingToBag() {
        Explorer explorer = new Explorer("Sdr");
        assertEquals(0, explorer.getBag().getNbRubies());
    }

    @Test
    public void addToBag1Times() {
        Explorer explorer = new Explorer("Sdr");
        explorer.addToBag(42);
        assertEquals(42, explorer.getBag().getNbRubies());
    }

    @Test
    public void addToBag2Times() {
        Explorer explorer = new Explorer("Sdr");
        explorer.addToBag(40);
        explorer.addToBag(2);
        assertEquals(42, explorer.getBag().getNbRubies());
    }

    @Test
    public void equalsTrue() {
        Explorer e1 = new Explorer("mcd");
        Explorer e2 = new Explorer("mcd");
        assertTrue(e1.equals(e2));
    }

    @Test
    public void equalsFalseDifferent() {
        Explorer e1 = new Explorer("mcd");
        Explorer e2 = new Explorer("pbt");
        assertFalse(e1.equals(e2));
    }

    @Test
    public void equalsFalseOtherObject() {
        Explorer e1 = new Explorer("mcd");
        String e2 = "mcd";
        assertFalse(e1.equals(e2));
    }

    @Test
    public void equalsFalseNull() {
        Explorer e1 = new Explorer("mcd");
        assertFalse(e1.equals(null));
    }
}