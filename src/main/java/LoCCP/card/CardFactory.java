package LoCCP.card;

import LoCCP.Game;
import LoCCP.card.commonCard.Attack;
import LoCCP.card.commonCard.Defence;
import LoCCP.card.commonCard.Heal;
import LoCCP.exceptions.InvalidInputException;

public class CardFactory {
    public static Card newCard(Game game, String type) throws InvalidInputException {
        switch (type) {
            case "attack":
                return new Attack(game);
            case "defence":
                return new Defence(game);
            case "heal":
                return new Heal(game);

            default:
                throw new InvalidInputException("Invalid Card Type: " + type);
        }
    }
}
