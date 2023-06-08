package model.actioncards;

import controller.Game;
import model.*;

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
    public void play(Player currentPlayer) {
        // choose one of the color to rent
        List<Colors> colorsList = List.of(first, second);
        int colorIndex = currentPlayer.selectColor(colorsList);
        Colors color = colorsList.get(colorIndex);

        // calculate the rent for the corresponding color property set
        int total = 0;
        List<PropertySet> propertySets = currentPlayer.getPropertyDeck().getPropertySets();
        for (PropertySet set : propertySets) {
            if (set.getColor() == color)
                total = total + set.getRent();
        }

        // rent
        List<Player> players = Game.getPlayers();
        for (Player p : players) {
            if (p == currentPlayer) continue;
            p.payTo(currentPlayer, total);
        }
    }
}
