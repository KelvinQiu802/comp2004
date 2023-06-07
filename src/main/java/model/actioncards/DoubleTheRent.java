package model.actioncards;

import model.ActionCard;
import model.Player;

public class DoubleTheRent extends ActionCard {
    public DoubleTheRent() {
        super(ActionCardsName.DOUBLE_THE_RENT, 1, "Needs to be played with a rent card.");
    }

    @Override
    public void play(Player currentPlayer) {

    }
}
