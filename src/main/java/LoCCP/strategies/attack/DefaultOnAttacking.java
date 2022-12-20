package LoCCP.strategies.attack;

import java.util.ArrayList;
import java.util.List;

import LoCCP.Hero;
import LoCCP.actions.Action;
import LoCCP.actions.reactions.Reaction;
import LoCCP.card.commonCard.Attack;
import LoCCP.card.commonCard.Defence;

public class DefaultOnAttacking implements onAttacking {
    private Hero hero;

    public DefaultOnAttacking(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void apply(Attack attack) {
        Hero target = attack.getTarget();
        List<Reaction> reactions = new ArrayList<>();
        target.getHandCards().getCards().stream().forEach(c -> {
            if (c instanceof Defence) {
                Defence d = (Defence) c;
                reactions.add(d);
            }
        });
        Action action = new Action(hero, target, reactions, h -> h.onAttacked(attack));
        hero.setInAction(action);
        target.setInAction(action);
    }

}
