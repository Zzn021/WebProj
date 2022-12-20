package LoCCP;

import java.util.List;

import LoCCP.actions.Action;
import LoCCP.actions.reactions.Reaction;
import LoCCP.area.EquipmentArea;
import LoCCP.area.EventArea;
import LoCCP.area.HandCardArea;
import LoCCP.area.RetinueArea;
import LoCCP.card.Card;
import LoCCP.card.commonCard.Attack;
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
    private int dRange = 0;

    private EquipmentArea equipments = new EquipmentArea(getGame());
    private EventArea events = new EventArea(getGame());
    private HandCardArea handCards = new HandCardArea(getGame());
    private RetinueArea retinues = new RetinueArea(getGame());

    protected onAttacked onAttackedStrategy = new DefaultOnAttacked(this);
    protected onAttacking onAttackingStrategy = new DefaultOnAttacking(this);

    private Action inAction = null;


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

    public void onAttacked(Attack attack) {
        onAttackedStrategy.apply(attack);
    }

    public void onAttacking(Attack attack) {
        onAttackingStrategy.apply(attack);
    }

    public void useCard(Card card, Hero target) throws InvalidActionException, InvalidEntityException {
        handCards.useCard(card, this, target);
    }

    public void setInAction(Action inAction) {
        this.inAction = inAction;
    }

    public boolean waitingResponde() {
        return inAction != null && inAction.waitingReaction();
    }

    public List<Reaction> getAvailableReaction() {
        return inAction.getAvailableReactions();
    }

    public void react(Reaction reaction) throws InvalidActionException, InvalidEntityException {
        if (reaction == null) {
            inAction.effective();
        } else {
            reaction.react(inAction);
        }
        inAction = null;
    }
}
