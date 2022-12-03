package main.java;

import java.util.List;

import main.java.area.EquipmentArea;
import main.java.area.EventArea;
import main.java.area.HandCardArea;
import main.java.area.RetinueArea;


public class Hero extends Entity {
    public enum Camp {
        MAO,
        JIANG,
        TUAN,
        XI,
        FOREIGN
    }

    private Camp camp;
    private int maxHealth;
    private int health;

    private EquipmentArea equipments;
    private EventArea events;
    private HandCardArea handCards;
    private RetinueArea retinues;


    public Hero(int id, String name, Camp camp, int maxHealth) {
        super(id, name);
        this.camp = camp;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }


    public Camp getCamp() {
        return camp;
    }


    public int getMaxHealth() {
        return maxHealth;
    }


    public int getHealth() {
        return health;
    }
}
