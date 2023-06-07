package model.actioncards;

import controller.Game;
import model.ActionCard;
import model.DrawPile;
import model.Player;

public class PassGo extends ActionCard {

    public PassGo() {
        super(ActionCardsName.PASS_GO, 1, "Draw 2 extra cards.");
    }

    @Override
    public void play(Player currentPlayer) {
        DrawPile pile = Game.getDrawPile();
        currentPlayer.draw(pile);
        currentPlayer.draw(pile);
    }
}
