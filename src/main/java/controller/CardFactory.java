package controller;

import model.AbstractCard;
import model.ActionCard;
import model.MoneyCard;

import java.util.ArrayList;
import java.util.List;

public class CardFactory {
    public List<AbstractCard> createCards() {
        List<AbstractCard> cards = new ArrayList<>();
        cards.addAll(getAllMoneyCards());

        return cards;
    }

    private List<AbstractCard> createMoneyCards(int value, int num) {
        List<AbstractCard> cards = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            cards.add(new MoneyCard(value));
        }
        return cards;
    }

    private List<AbstractCard> getAllMoneyCards() {
        List<AbstractCard> cards = new ArrayList<>();
        cards.addAll(createMoneyCards(10, 1));
        cards.addAll(createMoneyCards(5, 2));
        cards.addAll(createMoneyCards(4, 3));
        cards.addAll(createMoneyCards(3, 3));
        cards.addAll(createMoneyCards(2, 5));
        cards.addAll(createMoneyCards(1, 6));
        return cards;
    }
}
