package model.actioncards;

import model.ActionCard;

public class ForcedDeal extends ActionCard {
    public ForcedDeal() {
        super("Forced Deal", 3, "Swap any property with another player."
            + "(Cannot be part of a full set.)");
    }

    @Override
    public void play() {

    }
}
