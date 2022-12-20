package LoCCP.card.commonCard;

import LoCCP.Game;
import LoCCP.Hero;
import LoCCP.actions.ActionResponse;
import LoCCP.exceptions.InvalidActionException;
import LoCCP.exceptions.InvalidEntityException;

public class Defence extends CommonCard implements ActionResponse {

    public Defence(int id, String name, Game game) {
        super(id, name, game);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void use(Hero from, Hero to) throws InvalidActionException, InvalidEntityException {
        // TODO Auto-generated method stub
        
    }
    
}
