package main.java;

import java.util.List;

import main.java.area.EquipmentArea;
import main.java.area.EventArea;
import main.java.area.HandCardArea;
import main.java.area.RetinueArea;


public abstract class Hero extends Entity {
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

    private Game game;

    public Hero(int id, String name, Camp camp, int maxHealth, Game game) {
        super(id, name);
        this.camp = camp;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.game = game;
    }

    public abstract boolean abilityCondition();
    public abstract void ability();

    public Camp getCamp() {
        return camp;
    }


    public int getMaxHealth() {
        return maxHealth;
    }


    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }


    public int getHealth() {
        return health;
    }


    public void setHealth(int health) {
        this.health = health;
    }


    public EquipmentArea getEquipments() {
        return equipments;
    }


    public void setEquipments(EquipmentArea equipments) {
        this.equipments = equipments;
    }


    public EventArea getEvents() {
        return events;
    }


    public void setEvents(EventArea events) {
        this.events = events;
    }


    public HandCardArea getHandCards() {
        return handCards;
    }


    public void setHandCards(HandCardArea handCards) {
        this.handCards = handCards;
    }


    public RetinueArea getRetinues() {
        return retinues;
    }


    public void setRetinues(RetinueArea retinues) {
        this.retinues = retinues;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
