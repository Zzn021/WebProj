package main.java.area;

import java.util.ArrayList;
import java.util.List;

import main.java.card.Card;

public abstract class Area {
    private List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }

    public int getSize() {
        return cards.size();
    }
}
