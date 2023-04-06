package model;

public class MoneyCard extends AbstractCard {

    public MoneyCard(int value) {
        super("Money", CardTypes.MONEY, value, "Money");
    }

    @Override
    public void play() {

    }
}
