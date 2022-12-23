package LoCCP;

public abstract class Entity {
    private String id;
    private Game game;

    /**
     * @Precondition a unique id is given
     * @param id
     * @param name
     */
    public Entity(Game game) {
        this.game = game;
        this.id = game.generateID();
    }

    public String getId() {
        return id;
    }

    public Game getGame() {
        return game;
    }

}
