package LoCCP.card.commonCard;

import LoCCP.Game;
import LoCCP.Hero;
import LoCCP.actions.Action;
import LoCCP.actions.reactions.CardReaction;
import LoCCP.exceptions.InvalidActionException;
import LoCCP.exceptions.InvalidEntityException;

public class Defence extends CommonCard implements CardReaction {

    public Defence(Game game) {
        super(game);
    }

    @Override
    public void use(Hero from, Hero to) throws InvalidActionException, InvalidEntityException {
        bothExist(from, to);
    }

    @Override
    public void react(Action action) throws InvalidActionException, InvalidEntityException {
        action.to().useCard(this, action.from());
    }

}
