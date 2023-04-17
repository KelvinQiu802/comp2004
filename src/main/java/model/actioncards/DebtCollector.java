package model.actioncards;

import model.ActionCard;

public class DebtCollector extends ActionCard {
    public DebtCollector() {
        super(ActionCardsName.DEBT_COLLECTOR, 3, "Force any player to pay you 5M");
    }

    @Override
    public void play() {

    }
}
