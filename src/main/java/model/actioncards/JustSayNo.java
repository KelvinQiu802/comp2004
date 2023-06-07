package model.actioncards;

import model.ActionCard;
import model.DrawPile;
import model.Player;

import java.util.List;

public class JustSayNo extends ActionCard {
    public JustSayNo() {
        super(ActionCardsName.JUST_SAY_NO, 4, "Use any time when an action card is played against you.");
    }

    @Override
    public void play(Player currentPlayer, List<Player> players, DrawPile pile) {

    }
}
