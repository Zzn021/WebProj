package LoCCP.heros;

import LoCCP.Game;
import LoCCP.Hero;

public class XiJinping extends Hero {
    public XiJinping(Game game) {
        super(Camp.XI, 5, game);
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
