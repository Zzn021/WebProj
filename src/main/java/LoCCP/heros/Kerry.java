package LoCCP.heros;

import LoCCP.Game;
import LoCCP.Hero;

public class Kerry extends Hero {
    public Kerry(int id, Game game) {
        super(id, "Kerry", Camp.FOREIGN, 20, game);
    }

    public boolean abilityCondition() {
        return true;
    }

    public void ability() {
        if (this.abilityCondition()) {
            
        }
    }
}
