package model;

import java.util.List;

public class MoneyCard extends AbstractCard implements IBankCard {
    public MoneyCard(int value) {
        super("Money", CardTypes.MONEY, value, "Money");
    }

    @Override
    public void play(Player currentPlayer, List<Player> players, DrawPile pile) {

    }
}
