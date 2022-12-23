package LoCCP.area;

import LoCCP.Game;
import LoCCP.Hero;
import LoCCP.card.Card;

/**
 * CardPile is where all Hero get their new cards from.
 * The top of the CardPile is at index [size - 1]
 * The bottom of the CardPile is at index 0.
 */
public class CardPile extends Area {


    public CardPile(Game game) {
        super(game);
        //TODO Auto-generated constructor stub
    }

    public void dealCards(Hero receiver, int numCard) {
        HandCardArea handCard = receiver.getHandCards();
        int idx = getSize() - 1;
        for (int i = 0; i < numCard; i++) {
            Card card = cards.get(idx);
            handCard.addCard(card);
        }
    }
}
