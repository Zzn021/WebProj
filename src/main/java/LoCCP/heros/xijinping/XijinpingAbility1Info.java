package LoCCP.heros.xijinping;

import LoCCP.Hero;
import LoCCP.ability.AbilityInfo;

public class XijinpingAbility1Info implements AbilityInfo {
    private Hero target;

    public XijinpingAbility1Info(Hero target) {
        this.target = target;
    }

    public Hero getTarget() {
        return target;
    }
}
