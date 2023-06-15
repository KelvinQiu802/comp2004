package model.actioncards;

import model.ActionCard;
import model.Player;
import view.PlayerDisplayView;
import view.PlayerInputView;

import java.util.List;

public class DebtCollector extends ActionCard {
    public DebtCollector() {
        super(ActionCardsName.DEBT_COLLECTOR, 3, "Force any player to pay you 5M");
    }

    @Override
    public void play(Player currentPlayer, List<Player> players) {
        // Print all players without current player
        List<Player> others = players;
        others.remove(currentPlayer);
        PlayerDisplayView.printPlayer(others);

        // Choose a player
        int playerIndex = PlayerInputView.getPlayerIndex(others.size());
        Player target = others.get(playerIndex);
        if (target.sayNo()) {
            return;
        }

        // Force the target player to pay
        target.payTo(currentPlayer, 5);
    }
}
