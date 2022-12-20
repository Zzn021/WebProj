package LoCCP.card.commonCard;

import LoCCP.exceptions.InvalidActionException;
import LoCCP.exceptions.InvalidEntityException;
import LoCCP.Game;
import LoCCP.Hero;

//杀
public class Attack extends CommonCard {

    public Attack(int id, String name, Game game) {
        super(id, name, game);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void use(Hero from, Hero to) throws InvalidActionException, InvalidEntityException {
        bothExist(from, to);
        if (! getGame().getMap().inRange(from, to)) {
            throw new InvalidActionException(
                "The attack target: {id: " + to.getIdString() + "} is not in range!"
            );
        }
        from.onAttacking(this);
        to.onAttacked(this);
    }
}
