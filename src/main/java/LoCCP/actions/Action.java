package LoCCP.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import LoCCP.Hero;
import LoCCP.actions.reactions.Reaction;

/**
 * Action from one Hero against another Hero.
 */
public class Action {
    private Hero from;
    private Hero to;
    private List<Reaction> availableReactions = new ArrayList<>();
    private Reaction reaction = null;
    private Consumer<Hero> effectOnTarget;


    public Action(Hero from, Hero to, List<Reaction> availableReactions, Consumer<Hero> effectOnTarget) {
        this.from = from;
        this.to = to;
        this.availableReactions = availableReactions;
        this.effectOnTarget = effectOnTarget;
    }

    public Action(Hero from, Hero to, List<Reaction> availableReactions) {
        this.from = from;
        this.to = to;
        this.availableReactions = availableReactions;
    }

    public Hero from() {
        return from;
    }

    public Hero to() {
        return to;
    }

    public List<Reaction> getAvailableReactions() {
        return availableReactions;
    }

    public Reaction getReaction() {
        return reaction;
    }

    public void setReaction(Reaction reaction) {
        this.reaction = reaction;
    }

    public boolean waitingReaction() {
        return reaction == null;
    }

    public void effective() {
        effectOnTarget.accept(to);
    }

}
