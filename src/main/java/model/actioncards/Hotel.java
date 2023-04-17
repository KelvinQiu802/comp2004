package model.actioncards;

import model.ActionCard;

public class Hotel extends ActionCard {
    public Hotel() {
        super(ActionCardsName.HOTEL, 4, "Add onto any full set you own to add M4m to the rent value." + "(Except railroads and utilities.)");
    }

    @Override
    public void play() {

    }
}
