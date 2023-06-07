package model.actioncards;

import model.ActionCard;
import model.Colors;
import model.DrawPile;
import model.Player;

import java.util.List;

public class Rent extends ActionCard {
    private Colors first;
    private Colors second;

    public Rent(Colors first, Colors second) {
        super(ActionCardsName.RENT, 1, "All players pay you rent for properties you own in one of " +
                "these colors.");
        this.first = first;
        this.second = second;
    }

    @Override
    public void play(Player currentPlayer, List<Player> players, DrawPile pile) {

    }
}
