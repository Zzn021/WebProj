package LoCCP.mvp;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import LoCCP.Game;
import LoCCP.card.commonCard.Attack;
import LoCCP.card.commonCard.Defence;
import LoCCP.heros.HuJintao;
import LoCCP.heros.XiJinping;

public class TestAttack {
    @Test
    @DisplayName("Testing Attack Basic Function")
    public void TestBasicAttack() {
        Game game = new Game();
        HuJintao hu = new HuJintao(0, game);
        game.addHero(hu);
        XiJinping xi = new XiJinping(1, game);
        game.addHero(xi);

        Attack attack = new Attack(101, "Attack", game);
        Defence defence = new Defence(102, "Defence", game);

        hu.getHandCards().addCard(defence);
        xi.getHandCards().addCard(attack);

        assertDoesNotThrow(() -> xi.useCard(attack, hu));

        assertEquals(0, xi.getHandCards().getCards().size());
        assertTrue(hu.waitingResponde());
        assertNotEquals(0, hu.getAvailableReaction());

        assertDoesNotThrow(() -> hu.react(hu.getAvailableReaction().get(0)));

        assertEquals(0, hu.getHandCards().getCards().size());
    }
}
