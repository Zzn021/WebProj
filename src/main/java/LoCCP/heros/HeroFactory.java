package LoCCP.heros;

import LoCCP.Game;
import LoCCP.Hero;
import LoCCP.exceptions.InvalidInputException;

public class HeroFactory {
    public static Hero newHero(Game game, String type) throws InvalidInputException {
        switch (type) {
            case "xijinping":
                return new XiJinping(game);
            case "hujintao":
                return new HuJintao(game);
            default:
                throw new InvalidInputException("Invalid Card Type: " + type);
        }
    }
}
