package main.java.LoCCP.card;

import main.java.LoCCP.Entity;
import main.java.LoCCP.Hero;

public abstract class Card extends Entity {
    private String description;

    public String getDescription() {
        return description;
    }

    public Card(int id, String name) {
        super(id, name);
    }

    public abstract void use(Hero from, Hero to);
}
