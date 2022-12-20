package LoCCP.card;

import LoCCP.exceptions.InvalidActionException;
import LoCCP.exceptions.InvalidEntityException;
import LoCCP.Entity;
import LoCCP.Game;
import LoCCP.Hero;
import LoCCP.area.Area;

public abstract class Card extends Entity {
    protected String description;
    private Area area;
    private Hero user = null;
    private Hero target = null;

    public String getDescription() {
        return description;
    }

    public Card(int id, String name, Game game) {
        super(id, name, game);
        game.getCardPile().addCard(this);
        setArea(game.getCardPile());
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Hero getUser() {
        return user;
    }

    public void setUser(Hero user) {
        this.user = user;
    }

    public Hero getTarget() {
        return target;
    }

    public void setTarget(Hero target) {
        this.target = target;
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
