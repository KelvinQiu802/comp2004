package model.actioncards;

import model.ActionCard;
import model.Player;

public class JustSayNo extends ActionCard {
    public JustSayNo() {
        super(ActionCardsName.JUST_SAY_NO, 4, "Use any time when an action card is played against you.");
    }

    @Override
    public void play(Player currentPlayer) {

    }
}
