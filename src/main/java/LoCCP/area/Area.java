package LoCCP.area;

import java.util.ArrayList;
import java.util.List;

import LoCCP.Game;
import LoCCP.card.Card;

public abstract class Area {
    protected List<Card> cards = new ArrayList<>();
    private Game game = null;

    public Area(Game game) {
        this.game = game;
    }

    public void addCard(Card card) {
        cards.add(card);
        card.setArea(this);
    }

    public void addCard(List<Card> newCards) {
        cards.addAll(newCards);
        newCards.stream().forEach(c -> c.setArea(this));
    }

    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }

    public int getSize() {
        return cards.size();
    }

    public Game getGame() {
        return game;
    }
}
