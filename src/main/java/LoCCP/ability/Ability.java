package LoCCP.ability;

import java.util.List;

import LoCCP.Hero;
import LoCCP.exceptions.InvalidEntityException;
import LoCCP.exceptions.InvalidInputException;

public abstract class Ability {
    protected Hero self;

    public Ability(Hero self) {
        this.self = self;
    }
    public abstract boolean usable();
    public abstract List<Hero> feasibleTarget();
    public abstract void use(AbilityInfo info) throws InvalidInputException, InvalidEntityException;
    public abstract String name();
    public abstract String description();

    protected void validTarget(Hero target) throws InvalidEntityException {
        if (!self.getGame().heroExist(target)) {
            throw new InvalidEntityException("The given target: {id: " + target.getId() + "} does not exist!");
        }
        if (!feasibleTarget().contains(target)) {
            throw new InvalidEntityException("The given target: {id: " + target.getId() + "} is not a feasible target!");
        }
    }

}
