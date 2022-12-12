package main.java.LoCCP;

import java.util.List;

import exceptions.InvalidEntityException;

public class Map {
    private Game game = null;

    public Map(Game game) {
        this.game = game;
    }

    /**
     * Calculate minimum distance between two heros.
     * Assume both heros are in the game map.
     * @param executor
     * @param target
     * @return minimum distance >= 0.
     */
    public int distance(Hero executor, Hero target) {
        int index1 = find(executor);
        int index2 = find(target);
        int dist1 = Math.abs(index1 - index2);
        int dist2 = getHeros().size() + 1 - dist1;
        return Math.min(dist1, dist2) + target.getDefenceRange();
    }

    public boolean inRange(Hero attacker, Hero target) {
        return attacker.getAttackRange() >= distance(attacker, target);
    }

    private int find(Hero h) {
        return getHeros().indexOf(h);
    }

    private List<Hero> getHeros() {
        return game.getHeros();
    }

}
