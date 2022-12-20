package LoCCP.area;

import java.util.ArrayList;
import java.util.List;

import LoCCP.Game;
import LoCCP.Hero;
import LoCCP.card.Card;
import LoCCP.exceptions.InvalidActionException;
import LoCCP.exceptions.InvalidEntityException;

public class HandCardArea extends Area {
    public HandCardArea(Game game) {
        super(game);
        //TODO Auto-generated constructor stub
    }


    public void useCard(Card card, Hero from, Hero to) throws InvalidActionException, InvalidEntityException {
        if (!cards.contains(card)) {
            throw new InvalidActionException("The hero does not contain the Card: {id: " + card.getId() + "}!");
        }
        card.use(from, to);
        cards.remove(card);

        getGame().getWasteCards().addCard(card);
    }
}
