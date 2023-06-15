package model.actioncards;

import model.ActionCard;
import model.Player;
import model.PropertySet;
import view.PlayerDisplayView;
import view.PlayerInputView;
import view.PropertyDisplayView;

import java.util.List;

public class DealBreaker extends ActionCard {
    public DealBreaker() {
        super(ActionCardsName.DEAL_BREAKER, 5, "Steal a complete set of properties from any player. " +
                "(Includes any buildings.)");
    }

    @Override
    public void play(Player currentPlayer, List<Player> players) {
        // 0. Print all players without current player
        List<Player> others = players;
        others.remove(currentPlayer);
        while (true) {
            PlayerDisplayView.printPlayer(others);
            // 1. Choose a player
            int playerIndex = PlayerInputView.getPlayerIndex(others.size());
            Player target = others.get(playerIndex);
            if (target.sayNo()) {
                return;
            }
            // 2. Print the property deck
            PropertyDisplayView.printPropertyDeck(target.getPropertyDeck());
            // 3. Choose a full set
            int setIndex = PlayerInputView.getTargetPropertySet(target.getPropertyDeck());
            PropertySet set = target.getPropertyDeck().getPropertySets().get(setIndex);
            if (set.isFullSet()) {
                // 4. Steal it
                target.getPropertyDeck().removeSet(set);
                currentPlayer.getPropertyDeck().insertSet(set);
                return;
            }
            System.out.println("This is NOT a full set, please try again!");
        }
    }
}
