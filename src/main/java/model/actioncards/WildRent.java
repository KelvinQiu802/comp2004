package model.actioncards;

import model.ActionCard;
import model.DrawPile;
import model.Player;

import java.util.List;

public class WildRent extends ActionCard {
    public WildRent() {
        super(ActionCardsName.WILD_RENT, 3, "Force one player to pay you rent for properties you own " +
                "in one of these colors.");
    }

    @Override
    public void play(Player currentPlayer, List<Player> players, DrawPile pile) {

    }
}
