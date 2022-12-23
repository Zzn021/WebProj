package LoCCP.strategies.heal;

import LoCCP.Hero;

public class DefaultOnHeal implements onHeal {
    private Hero hero;

    public DefaultOnHeal(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void apply(Hero from) {
        hero.setHealth(hero.getHealth() + 1);
    }
}
