package model.actioncards;

import model.ActionCard;
import model.Colors;
import model.IPropertyCard;
import model.Player;

public class House extends ActionCard implements IPropertyCard {
    public House() {
        super(ActionCardsName.HOUSE, 3, "Add onto any full set you own to add M3m to the rent value." + "(Except railroads and utilities.)");
    }

    @Override
    public void play(Player currentPlayer) {

    }

    public Colors getCurrentColor() {
        return Colors.ANY;
    }
}
