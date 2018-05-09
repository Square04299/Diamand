package be.he2b.g45502.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Where all the tiles are
 *
 * @author g45502
 */
public class Deck {

    private final List<Tile> tiles;

    /**
     * Construtor
     */
    public Deck() {
        this.tiles = new ArrayList<>();
        int[] val = {1, 2, 3, 4, 5, 5, 7, 7, 9, 11, 11, 13, 14, 15, 17};
        for (int i = 0; i < val.length; i++) {
            tiles.add(new Treasure(val[i]));
        }
        for (HazardType type : HazardType.values()) {
            for (int i = 0; i < 3; i++) {
                tiles.add(new Hazard(type));
            }
        }
        for (int i = 0; i < 5; i++) {
            tiles.add(new Relic());
        }
    }

    /**
     * Generate a random number to remove that tile
     *
     * @return tile that was removed
     */
    public Tile getTile() {
        int random = (int) (Math.random() * (tiles.size() - 1));
        Tile tile = tiles.get(random);
        tiles.remove(random);
        return tile;
    }

    /**
     * Put back the tile in the deck
     *
     * @param tile tile to put back
     */
    public void putBack(Tile tile) {
        tiles.add(tile);
    }

    void tileList() {

    }
}
