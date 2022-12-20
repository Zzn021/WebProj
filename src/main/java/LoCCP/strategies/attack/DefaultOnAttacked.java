package LoCCP.strategies.attack;

import LoCCP.Hero;
import LoCCP.card.commonCard.Attack;

public class DefaultOnAttacked implements onAttacked {
    private Hero hero;


    public DefaultOnAttacked(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void apply(Attack attack) {
        hero.setHealth(hero.getHealth() - 1);
    }

}
