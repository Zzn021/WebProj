package main.java.heros;

import main.java.Game;
import main.java.Hero;

public class XiJinping extends Hero {
    public XiJinping(int id, Game game) {
        super(id, "Xi Jinping", Camp.XI, 5, game);
    }

    public boolean abilityCondition() {
        if (this.getHealth() == 1) {
            return true;
        }
        return false;
    }

    public void ability() {
        if (this.abilityCondition()) {
            this.setHealth(getMaxHealth());
        }
    }
}
