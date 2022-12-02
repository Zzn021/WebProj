package main.java.card;

import main.java.Entity;

public abstract class Card extends Entity {
    private String description;

    public String getDescription() {
        return description;
    }

    public Card(int id, String name) {
        super(id, name);
    }

    public abstract void use();
}
