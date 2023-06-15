package model.actioncards;

import model.ActionCard;
import model.Colors;
import model.Player;

import java.util.List;

public class Rent extends ActionCard {
    private final Colors first;
    private final Colors second;

    public Rent(Colors first, Colors second) {
        super(ActionCardsName.RENT, 1, "All players pay you rent for properties you own in one of " +
                "these colors.");
        this.first = first;
        this.second = second;
    }

    @Override
    public void play(Player currentPlayer, List<Player> players) {
        // 0. Choose one of the color to rent
        List<Colors> colorsList = List.of(first, second);
        Colors color = currentPlayer.selectColor(colorsList);

        // 1. Calculate the rent for the corresponding color property set
        int total = currentPlayer.calculateRent(color);

        // 2. Rent
        List<Player> others = players;
        others.remove(currentPlayer);
        for (Player p : others) {
            if (p == currentPlayer) continue;
            p.payTo(currentPlayer, total);
        }
    }

    public Colors getFirst() {
        return first;
    }

    public Colors getSecond() {
        return second;
    }
}
