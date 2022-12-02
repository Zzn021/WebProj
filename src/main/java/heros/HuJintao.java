package main.java.heros;

import main.java.Game;
import main.java.Hero;

public class HuJintao extends Hero {
    public HuJintao(int id, Game game) {
        super(id, "Hu Jintao", Camp.TUAN, 3, game);
    }

    public boolean abilityCondition() {
        if (getHealth() == 2) {
            return true;
        } 
        return false;
    }

    public void ability() {
        if (this.abilityCondition()) {
            for(Hero hero : getGame().getHero()) {
                if (hero.getHealth() < hero.getMaxHealth()) {
                    hero.setHealth(hero.getHealth() + 1);
                }
            }
        }
    }
}
