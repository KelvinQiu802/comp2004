package model.actioncards;

import controller.Game;
import model.ActionCard;
import model.Player;
import view.PlayerInputView;

import java.util.ArrayList;
import java.util.List;

public class DebtCollector extends ActionCard {
    public DebtCollector() {
        super(ActionCardsName.DEBT_COLLECTOR, 3, "Force any player to pay you 5M");
    }

    @Override
    public void play(Player currentPlayer) {
        // Print all players without current player
        List<Player> others = new ArrayList<>(Game.getPlayers());
        others.remove(currentPlayer);

        // Choose a player
        int playerIndex = PlayerInputView.getPlayerIndex(others.size());
        Player target = others.get(playerIndex);

        // Force the target player to pay
        target.payTo(currentPlayer, 5);
    }
}
