package LoCCP.card.commonCard;

import LoCCP.Game;
import LoCCP.Hero;
import LoCCP.exceptions.InvalidActionException;
import LoCCP.exceptions.InvalidEntityException;

public class Heal extends CommonCard {

    public Heal(Game game) {
        super(game);
    }

    @Override
    public void use(Hero from, Hero to) throws InvalidActionException, InvalidEntityException {
        bothExist(from, to);
        if (from == to) {
            if (to.getHealth() == to.getMaxHealth())
                throw new InvalidActionException(
                    "The target: {id: " + to.getId() + " is at full health!");
        } else {
            if (to.getHealth() != 0)
                throw new InvalidActionException(
                    "The target: {id: " + to.getId() + " is not dying!");
        }
        to.onHeal(from);
    }

}
