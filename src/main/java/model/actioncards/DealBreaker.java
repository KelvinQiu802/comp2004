package model.actioncards;

import model.ActionCard;
import model.Player;
import model.PropertySet;

public class DealBreaker extends ActionCard {
    public DealBreaker() {
        super(ActionCardsName.DEAL_BREAKER, 5, "Steal a complete set of properties from any player. " +
            "(Includes any buildings.)");
    }

    @Override
    public void play(Player currentPlayer) {
        while (true) {
            // 1.confirm the player who need to pay
            Player p = currentPlayer.selectPlayer();

            // 2.confirm the full property you want to deal
            PropertySet ps = p.removeProperty(true);
            if (ps == null)
                continue;

            // 3.change the position of property set
            currentPlayer.getPropertyDeck().insertSet(ps);
            break;
        }
    }
}
