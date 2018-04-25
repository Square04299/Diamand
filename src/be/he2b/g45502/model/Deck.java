package be.he2b.g45502.model;

import java.util.List;

/**
 *Where all the tiles are
 * @author g45502
 */
public class Deck {
    private List<Treasure> tiles;

    public Deck() {
        this.tiles.add(new Treasure(1));
        this.tiles.add(new Treasure(2));
        this.tiles.add(new Treasure(3));
        this.tiles.add(new Treasure(4));
        this.tiles.add(new Treasure(5));
        this.tiles.add(new Treasure(5));
        this.tiles.add(new Treasure(7));
        this.tiles.add(new Treasure(7));
        this.tiles.add(new Treasure(9));
        this.tiles.add(new Treasure(11));
        this.tiles.add(new Treasure(11));
        this.tiles.add(new Treasure(13));
        this.tiles.add(new Treasure(14));
        this.tiles.add(new Treasure(15));
        this.tiles.add(new Treasure(17));
    }
    
    public Treasure getTreasure(){
        int tile = (int) (Math.random() * (tiles.size()-1));
        return tiles.get(tile);
    }
    
    public void putBack(Treasure treasure){
        treasure.restore();
    }
}
