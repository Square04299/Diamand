package be.he2b.g45502.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author square
 */
public class Treasure {

    private int rubies;
    private final int initNbRubies;

    public Treasure() {
        this.rubies = (int) Math.ceil(Math.random() * 15);
        this.initNbRubies = this.rubies;
    }

    public Treasure(int rubies) {
        this.initNbRubies = rubies;
        this.rubies = initNbRubies;

    }

    public int getRubies() {
        return rubies;
    }

    public int getInitNbRubies() {
        return initNbRubies;
    }

    public void explore(List<Explorer> explorers) {
        if (!explorers.isEmpty()) {
            List<Explorer> isExploring = new ArrayList<>();
            for (int i = 0; i < explorers.size(); i++) {
                if (explorers.get(i).getState() == State.EXPLORING) {
                    isExploring.add(explorers.get(i));
                }
            }
        
            int rubiesToGiven = initNbRubies / isExploring.size();
            rubies = initNbRubies - isExploring.size() * rubiesToGiven;
            for (Explorer explorer : isExploring) {
                explorer.addToBag(rubiesToGiven);
            }
        }
    }

}
