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
        // confirm the player who need to pay
        List<Player> others = new ArrayList<>(Game.getPlayers());
        others.remove(currentPlayer);
        int playerIndex = PlayerInputView.getPlayerIndex(others.size());
        Player target = others.get(playerIndex);

        // rent
        target.payTo(currentPlayer, 5);
    }
}
