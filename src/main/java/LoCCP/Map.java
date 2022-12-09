package main.java.LoCCP;

import java.util.List;

public class Map {
    private Game game = null;

    public Map(Game game) {
        this.game = game;
    }

    public int distance(int id1, int id2) {
        int index1 = find(id1);
        int index2 = find(id2);
        if (index1 == -1 || index2 == -1) return -1;

        int dist1 = Math.abs(index1 - index2);
        int dist2 = getHeros().size() + 1 - dist1;
        return Math.min(dist1, dist2);
    }

    private int find(int id) {
        return getHeros().indexOf(getHeros().stream().filter(h -> h.getId() == id).findFirst().orElse(null));
    }

    private List<Hero> getHeros() {
        return game.getHeros();
    }

}
