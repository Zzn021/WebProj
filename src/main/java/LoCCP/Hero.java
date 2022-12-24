package LoCCP;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import LoCCP.ability.Ability;
import LoCCP.ability.AbilityInfo;
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
import LoCCP.exceptions.InvalidInputException;
import LoCCP.strategies.ability.DefaultOnAbilityTarget;
import LoCCP.strategies.ability.onAbilityTarget;
import LoCCP.strategies.attack.DefaultOnAttacked;
import LoCCP.strategies.attack.DefaultOnAttacking;
import LoCCP.strategies.attack.onAttacked;
import LoCCP.strategies.attack.onAttacking;
import LoCCP.strategies.heal.DefaultOnHeal;
import LoCCP.strategies.heal.onHeal;


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
    protected onHeal onHealStrategy = new DefaultOnHeal(this);
    protected onAbilityTarget onAbilityTargetStrategy = new DefaultOnAbilityTarget();

    protected List<Ability> abilities = new ArrayList<>();

    private Action inAction = null;


    public Hero(Camp camp, int maxHealth, Game game) {
        super(game);
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

    /**
     * Setter for Hero's health.
     * If the health is greater than maxHealth then set to maxHealth.
     * @param health <= maxHealth
     */
    public void setHealth(int health) {
        this.health = Math.min(health, maxHealth);
    }

    public EquipmentArea getEquipments() {
        return equipments;
    }

    public EventArea getEvents() {
        return events;
    }

    public HandCardArea getHandCards() {
        return handCards;
    }

    public RetinueArea getRetinues() {
        return retinues;
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

    public void onHeal(Hero from) {
        onHealStrategy.apply(from);
    }

    public void onAbilityTarget(Ability ability) {
        onAbilityTargetStrategy.apply(ability);
    }

    public void useCard(Card card, Hero target) throws InvalidActionException, InvalidEntityException {
        handCards.useCard(card, this, target);
    }

    /**
     * Set the Hero in the given action, the Hero will then be in responding state until a reaction is given.
     * @param inAction
     */
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

    public List<Ability> usableAbilities() {
        return abilities.stream().filter(a -> a.usable()).collect(Collectors.toList());
    }

    public void useAbility(Ability ability, AbilityInfo info) throws InvalidInputException, InvalidEntityException {
        if (!this.abilities.contains(ability)) {
            throw new InvalidInputException("The choosen ability is currently not usable!");
        }
        ability.use(info);
    }
}
