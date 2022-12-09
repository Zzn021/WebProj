package main.java.LoCCP;

import java.util.ArrayList;

import main.java.LoCCP.card.Card;

public class Game {
    private ArrayList<Hero> heros = new ArrayList<>();
    private ArrayList<Card> cards = new ArrayList<>();
    
    public Game() {
        
    }

    public void addHero(Hero hero) {
        heros.add(hero);
    }

    public ArrayList<Hero> getHero() {
        return heros;
    }

    public ArrayList<Card> geCards() {
        return cards;
    }
}
