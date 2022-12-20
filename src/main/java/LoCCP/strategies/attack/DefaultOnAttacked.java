package LoCCP.strategies.attack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import LoCCP.Hero;
import LoCCP.card.commonCard.Defence;

public class DefaultOnAttacked implements onAttacked {
    private Hero hero;

    public DefaultOnAttacked(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void apply() {
        hero.setResponseCardFilter(cards -> cards.stream().filter(c -> c instanceof Defence).collect(Collectors.toList()));
    }

}
