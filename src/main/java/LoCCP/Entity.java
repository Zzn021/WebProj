package LoCCP;

public abstract class Entity {
    private int id;
    private String name;
    private Game game;

    /**
     * @Precondition a unique id is given
     * @param id
     * @param name
     */
    public Entity(int id, String name, Game game) {
        this.id = id;
        this.name = name;
        this.game = game;
    }

    public int getId() {
        return id;
    }

    public String getIdString() {
        return Integer.toString(id);
    }

    public String getName() {
        return name;
    }

    public Game getGame() {
        return game;
    }

}
