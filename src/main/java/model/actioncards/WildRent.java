package model.actioncards;

import model.ActionCard;

public class WildRent extends ActionCard {
    public WildRent() {
        super(ActionCardsName.WILD_RENT, 3, "Force one player to pay you rent for properties you own " +
                "in one of these colors.");
    }

    @Override
    public void play() {

    }
}
