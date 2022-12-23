package LoCCP;

import java.util.ArrayList;

import LoCCP.area.CardPile;
import LoCCP.area.WasteCardPile;
import LoCCP.card.Card;

public class Game {
    private ArrayList<Hero> heros = new ArrayList<>();
    private ArrayList<Card> cards = new ArrayList<>();
    private Map map = new Map(this);
    private CardPile cardPile = new CardPile(this);
    private WasteCardPile wasteCards = new WasteCardPile(this);
    private IDGenerator idGenerator = new IDGenerator();

    public Game() {
    }

    public void addHero(Hero hero) {
        heros.add(hero);
    }

    public ArrayList<Hero> getHeros() {
        return heros;
    }

    public boolean heroExist(Hero h) {
        return heros.contains(h);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Map getMap() {
        return map;
    }

    public CardPile getCardPile() {
        return cardPile;
    }

    public WasteCardPile getWasteCards() {
        return wasteCards;
    }

    public boolean waitingResponde() {
        return heros.stream().anyMatch(Hero::waitingResponde);
    }

    public String generateID() {
        return idGenerator.newID();
    }

}
