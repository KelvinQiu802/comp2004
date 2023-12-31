package model.actioncards;

import model.ActionCard;
import model.Colors;
import model.IPropertyCard;
import model.Player;

import java.util.List;

public class Hotel extends ActionCard implements IPropertyCard {
    public Hotel() {
        super(ActionCardsName.HOTEL, 4, "Add onto any full set you own to add M4m to the rent value." + "(Except railroads and utilities.)");
    }

    @Override
    public void play(Player currentPlayer, List<Player> players) {

    }

    public Colors getCurrentColor() {
        return Colors.ANY;
    }
}
