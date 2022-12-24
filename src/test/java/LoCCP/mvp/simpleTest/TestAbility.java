package LoCCP.mvp.simpleTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import LoCCP.Game;
import LoCCP.ability.Ability;
import LoCCP.ability.AbilityInfo;
import LoCCP.card.commonCard.Attack;
import LoCCP.card.commonCard.Defence;
import LoCCP.heros.hujintao.HuJintao;
import LoCCP.heros.xijinping.XiJinping;
import LoCCP.heros.xijinping.XijinpingAbility1Info;

public class TestAbility {
    @Test
    @DisplayName("Testing ability can be used")
    public void testBasicAbility() {
        Game game = new Game();
        HuJintao hu = new HuJintao(game);
        game.addHero(hu);
        XiJinping xi = new XiJinping(game);
        game.addHero(xi);

        Attack attack = new Attack(game);
        Defence defence = new Defence(game);

        hu.getHandCards().addCard(defence);
        xi.getHandCards().addCard(attack);

        assertEquals(1, hu.getHandCards().getSize());

        Ability ab = xi.usableAbilities().get(0);
        AbilityInfo info = new XijinpingAbility1Info(ab.feasibleTarget().get(0));

        assertDoesNotThrow(() -> xi.useAbility(ab, info));
        assertEquals(0, hu.getHandCards().getSize());
    }
}
