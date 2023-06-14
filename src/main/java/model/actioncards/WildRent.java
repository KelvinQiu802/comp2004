package model.actioncards;

import controller.Game;
import model.ActionCard;
import model.Colors;
import model.Player;
import view.PlayerDisplayView;
import view.PlayerInputView;

import java.util.ArrayList;
import java.util.List;

public class WildRent extends ActionCard {
    public WildRent() {
        super(ActionCardsName.WILD_RENT, 3, "Force one player to pay you rent for properties you own " +
                "in one of these colors.");
    }

    @Override
    public void play(Player currentPlayer, List<Player> players) {
        // choose one of the color to rent
        List<Colors> colorsList = List.of(Colors.GREEN, Colors.DARK_BLUE, Colors.LIGHT_BLUE, Colors.RED, Colors.UTILITY,
                Colors.YELLOW, Colors.ORANGE, Colors.BROWN, Colors.PURPLE, Colors.RAILROAD);
        Colors color = currentPlayer.selectColor(colorsList);

        // calculate the rent for the corresponding color property set
        int total = currentPlayer.calculateRent(color);

        // confirm the player who need to pay
        List<Player> others = players;
        others.remove(currentPlayer);
        PlayerDisplayView.printPlayer(others);
        int playerIndex = PlayerInputView.getPlayerIndex(others.size());
        Player target = others.get(playerIndex);

        // rent
        target.payTo(currentPlayer, total);
    }
}
