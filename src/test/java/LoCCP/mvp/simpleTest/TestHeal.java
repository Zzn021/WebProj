package LoCCP.mvp.simpleTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import LoCCP.Game;
import LoCCP.card.commonCard.Attack;
import LoCCP.card.commonCard.Heal;
import LoCCP.exceptions.InvalidActionException;
import LoCCP.heros.HuJintao;
import LoCCP.heros.XiJinping;

public class TestHeal {
    @Test
    @DisplayName("Testing Heal Basic Function")
    public void testHealBasic() {
        Game game = new Game();
        HuJintao hu = new HuJintao(game);
        game.addHero(hu);
        XiJinping xi = new XiJinping(game);
        game.addHero(xi);

        int huHealth = hu.getHealth();

        Attack attack = new Attack(game);
        Heal heal = new Heal(game);
        Heal heal2 = new Heal(game);

        hu.getHandCards().addCard(heal);
        xi.getHandCards().addCard(attack);
        xi.getHandCards().addCard(heal2);
        // xi attack hu
        assertDoesNotThrow(() -> xi.useCard(attack, hu));
        assertDoesNotThrow(() -> hu.react(null));
        assertEquals(huHealth - 1, hu.getHealth());
        assertNotEquals(0, hu.getHealth());

        // cannot heal other who is not dying
        assertThrows(InvalidActionException.class, () -> hu.useCard(heal, xi));
        assertThrows(InvalidActionException.class, () -> xi.useCard(heal2, hu));
        // cannot heal self who is full health
        assertThrows(InvalidActionException.class, () -> xi.useCard(heal2, xi));
        // heal self
        assertDoesNotThrow(() -> hu.useCard(heal, hu));

    }
}
