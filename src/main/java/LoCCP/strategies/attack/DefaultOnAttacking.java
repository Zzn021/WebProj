package LoCCP.strategies.attack;

import LoCCP.Hero;
import LoCCP.card.commonCard.Attack;

public class DefaultOnAttacking implements onAttacking {
    private Hero hero;

    public DefaultOnAttacking(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void apply(Attack attack) {
        attack.setUser(hero);
    }

}
