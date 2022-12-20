package LoCCP.strategies.attack;

import java.util.ArrayList;
import java.util.List;

import LoCCP.Hero;
import LoCCP.actions.Action;
import LoCCP.actions.reactions.Reaction;
import LoCCP.card.commonCard.Attack;
import LoCCP.card.commonCard.Defence;

public class DefaultOnAttacked implements onAttacked {
    private Hero hero;


    public DefaultOnAttacked(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void apply(Attack attack) {
        attack.setTarget(hero);

        List<Reaction> reactions = new ArrayList<>();
        hero.getHandCards().getCards().stream().forEach(c -> {
            if (c instanceof Defence) {
                Defence d = (Defence) c;
                reactions.add(d);
            }
        });
        hero.setInAction(new Action(attack.getUser(), hero, reactions));
    }

}
