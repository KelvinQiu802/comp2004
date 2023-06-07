package model;

public class MoneyCard extends AbstractCard implements IBankCard {
    public MoneyCard(int value) {
        super("Money", CardTypes.MONEY, value, "Money");
    }

    @Override
    public void play(Player currentPlayer) {

    }
}
