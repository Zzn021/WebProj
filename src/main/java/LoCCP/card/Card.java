package main.java.LoCCP.card;

import exceptions.InvalidActionException;
import exceptions.InvalidEntityException;
import main.java.LoCCP.Entity;
import main.java.LoCCP.Game;
import main.java.LoCCP.Hero;

public abstract class Card extends Entity {
    private String description;

    public String getDescription() {
        return description;
    }

    public Card(int id, String name, Game game) {
        super(id, name, game);
    }

    public void bothExist(Hero from, Hero to) throws InvalidEntityException {
        Game game = getGame();
        if (! game.heroExist(from)) {
            throw new InvalidEntityException("Invalid Hero: {id: " + from.getIdString() + "}!");
        }
        if (! game.heroExist(to)) {
            throw new InvalidEntityException("Invalid Hero: {id: " + to.getIdString() + "}!");
        }
    }

    public abstract void use(Hero from, Hero to) throws InvalidActionException, InvalidEntityException;
}
