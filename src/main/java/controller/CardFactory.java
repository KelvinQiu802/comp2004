package controller;

import model.AbstractCard;
import model.ActionCard;
import model.MoneyCard;
import model.actioncards.ActionCardsName;

import java.util.ArrayList;
import java.util.List;

public class CardFactory {
    public List<AbstractCard> createCards() {
        List<AbstractCard> cards = new ArrayList<>();
        cards.addAll(getAllMoneyCards());
        cards.addAll(getAllActionCards());
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

    private List<AbstractCard> createActionCards(ActionCardsName cardName, int num) {
        List<AbstractCard> cards = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            cards.add(ActionCardFactory.create(cardName));
        }
        return cards;
    }

    private List<AbstractCard> getAllActionCards() {
        List<AbstractCard> cards = new ArrayList<>();
        cards.addAll(createActionCards(ActionCardsName.DEAL_BREAKER, 2));
        cards.addAll(createActionCards(ActionCardsName.JUST_SAY_NO, 3));
        cards.addAll(createActionCards(ActionCardsName.SLY_DEAL, 3));
        cards.addAll(createActionCards(ActionCardsName.FORCED_DEAL, 4));
        cards.addAll(createActionCards(ActionCardsName.DEBT_COLLECTOR, 3));
        cards.addAll(createActionCards(ActionCardsName.ITS_MY_BIRTHDAY, 3));
        cards.addAll(createActionCards(ActionCardsName.PASS_GO, 10));
        cards.addAll(createActionCards(ActionCardsName.HOUSE, 3));
        cards.addAll(createActionCards(ActionCardsName.HOTEL, 3));
        cards.addAll(createActionCards(ActionCardsName.DOUBLE_THE_RENT, 2));
        return cards;
    }
}
