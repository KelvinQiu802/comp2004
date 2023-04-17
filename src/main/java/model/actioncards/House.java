package model.actioncards;

import model.ActionCard;

public class House extends ActionCard {
    public House() {
        super(ActionCardsName.HOUSE, 3, "Add onto any full set you own to add M3m to the rent value." + "(Except railroads and utilities.)");
    }

    @Override
    public void play() {

    }
}
