package main.java.LoCCP;

public abstract class Entity {
    private int id;
    private String name;

    /**
     * @Precondition a unique id is given
     * @param id
     * @param name
     */
    public Entity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
