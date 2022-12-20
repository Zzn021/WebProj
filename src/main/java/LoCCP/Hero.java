package LoCCP;

import java.util.List;
import java.util.function.Function;

import LoCCP.actions.ActionResponse;
import LoCCP.area.EquipmentArea;
import LoCCP.area.EventArea;
import LoCCP.area.HandCardArea;
import LoCCP.area.RetinueArea;
import LoCCP.card.Card;
import LoCCP.exceptions.InvalidActionException;
import LoCCP.exceptions.InvalidEntityException;
import LoCCP.strategies.attack.DefaultOnAttacked;
import LoCCP.strategies.attack.DefaultOnAttacking;
import LoCCP.strategies.attack.onAttacked;
import LoCCP.strategies.attack.onAttacking;


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
    private int aRange = 1;
    private int dRange = 1;

    private EquipmentArea equipments;
    private EventArea events;
    private HandCardArea handCards;
    private RetinueArea retinues;

    protected onAttacked onAttackedStrategy = new DefaultOnAttacked(this);
    protected onAttacking onAttackingStrategy = new DefaultOnAttacking();

    Function<List<Card>,List<Card>> respondeCardFilter = null;


    public Hero(int id, String name, Camp camp, int maxHealth, Game game) {
        super(id, name, game);
        this.camp = camp;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
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

    public RetinueArea getRetinues() {
        return retinues;
    }

    public void setRetinues(RetinueArea retinues) {
        this.retinues = retinues;
    }

    public int getAttackRange() {
        return aRange;
    }

    public int getDefenceRange() {
        return dRange;
    }

    public void onAttacked() {
        onAttackedStrategy.apply();
    }

    public void onAttacking() {
        onAttackingStrategy.apply();
    }

    public void useCard(Card card, Hero target) throws InvalidActionException, InvalidEntityException {
        handCards.useCard(card, this, target);
    }

    public void setResponseCardFilter(Function<List<Card>, List<Card>> filter) {
        this.respondeCardFilter = filter;
    }

    public boolean isResponding() {
        return this.respondeCardFilter != null;
    }

    public void responde(ActionResponse response) {

    }

    public void respondeWithCard(Card card) throws InvalidActionException, InvalidEntityException {
        handCards.useCard(card, this, null);
    }
}
