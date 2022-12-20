package LoCCP.actions.reactions;

import LoCCP.actions.Action;
import LoCCP.exceptions.InvalidActionException;
import LoCCP.exceptions.InvalidEntityException;

/**
 * The response from a Hero to an Action from another Hero.
 */
public interface Reaction {
    public void react(Action action) throws InvalidActionException, InvalidEntityException;
}
