package LoCCP.heros.xijinping;

import java.util.List;
import java.util.stream.Collectors;

import LoCCP.Hero;
import LoCCP.ability.Ability;
import LoCCP.ability.AbilityInfo;
import LoCCP.exceptions.InvalidEntityException;
import LoCCP.exceptions.InvalidInputException;

public class XijinpingAbility1 extends Ability {

    public XijinpingAbility1(XiJinping self) {
        super(self);
    }

    @Override
    public boolean usable() {
        return true;
    }

    @Override
    public void use(AbilityInfo info) throws InvalidInputException, InvalidEntityException {
        if (!(info instanceof XijinpingAbility1Info)) {
            throw new InvalidInputException("The AbilityInfo is not of correct type!");
        }

        Hero target = ((XijinpingAbility1Info) info).getTarget();
        validTarget(target);

        target.onAbilityTarget(this);
        target.getHandCards().discardAll();
    }

    @Override
    public List<Hero> feasibleTarget() {
        int minCard = Integer.MAX_VALUE;
        List<Hero> heros = self.getGame().getHeros();

        for (Hero h : heros) {
            if (h != self && h.getHandCards().getSize() < minCard) {
                minCard = h.getHandCards().getSize();
            }
        }
        final int min = minCard;

        return heros.stream().filter(h -> h.getHandCards().getSize() == min).collect(Collectors.toList());
    }

    @Override
    public String name() {
        return "Zero-COVID Policy";
    }

    @Override
    public String description() {
        return "Empty the hand card of the player with the least hand card among all other players.";
    }

}
