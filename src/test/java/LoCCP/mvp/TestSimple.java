package test.java.LoCCP.mvp;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import main.java.LoCCP.Game;
import main.java.LoCCP.heros.HuJintao;
import main.java.LoCCP.heros.XiJinping;

public class TestSimple {
    @Test
    @DisplayName("胡锦涛回血")
    public void HujintaoHeal() {
        Game game = new Game();
        HuJintao hu = new HuJintao(0, game);
        game.addHero(hu);
        XiJinping xi = new XiJinping(1, game);
        game.addHero(xi);

        assertEquals(hu.getMaxHealth(), hu.getHealth());
        hu.setHealth(2);

        xi.setHealth(1);

        hu.ability();

        assertEquals(2, xi.getHealth());
    }
}
