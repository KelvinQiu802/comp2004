package model.actioncards;

import model.ActionCard;
import model.Colors;
import model.Player;
import model.PropertySet;

import java.util.List;

public class WildRent extends ActionCard {
    public WildRent() {
        super(ActionCardsName.WILD_RENT, 3, "Force one player to pay you rent for properties you own " +
            "in one of these colors.");
    }

    @Override
    public void play(Player currentPlayer) {
        // choose one of the color to rent
        List<Colors> colorsList = List.of(Colors.GREEN, Colors.DARK_BLUE, Colors.LIGHT_BLUE, Colors.RED, Colors.UTILITY,
            Colors.YELLOW, Colors.ORANGE, Colors.BROWN, Colors.PURPLE, Colors.RAILROAD);
        Colors color = currentPlayer.selectColor(colorsList);

        // calculate the rent for the corresponding color property set
        int total = currentPlayer.calculateRent(color);

        // confirm the player who need to pay
        Player p = currentPlayer.selectPlayer();

        // rent
        p.payTo(currentPlayer, total);
    }
}
