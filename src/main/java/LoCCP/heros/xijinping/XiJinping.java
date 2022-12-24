package LoCCP.heros.xijinping;

import LoCCP.Game;
import LoCCP.Hero;

public class XiJinping extends Hero {

    public XiJinping(Game game) {
        super(Camp.XI, 5, game);
        abilities.add(new XijinpingAbility1(this));
    }

}
