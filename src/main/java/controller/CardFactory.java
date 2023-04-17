package controller;

import model.*;
import model.actioncards.ActionCardsName;
import model.actioncards.Rent;

import java.util.ArrayList;
import java.util.List;

public class CardFactory {
    public static List<AbstractCard> createCards() {
        List<AbstractCard> cards = new ArrayList<>();
        cards.addAll(getAllMoneyCards());
        cards.addAll(getAllActionCards());
        cards.addAll(getAllPropertyCards());
        return cards;
    }

    private static List<AbstractCard> createMoneyCards(int value, int num) {
        List<AbstractCard> cards = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            cards.add(new MoneyCard(value));
        }
        return cards;
    }

    private static List<AbstractCard> getAllMoneyCards() {
        List<AbstractCard> cards = new ArrayList<>();
        cards.addAll(createMoneyCards(10, 1));
        cards.addAll(createMoneyCards(5, 2));
        cards.addAll(createMoneyCards(4, 3));
        cards.addAll(createMoneyCards(3, 3));
        cards.addAll(createMoneyCards(2, 5));
        cards.addAll(createMoneyCards(1, 6));
        return cards;
    }

    private static List<AbstractCard> createActionCards(ActionCardsName cardName, int num) {
        List<AbstractCard> cards = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            cards.add(ActionCardFactory.create(cardName));
        }
        return cards;
    }

    private static List<AbstractCard> getAllActionCards() {
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

        cards.addAll(createActionCards(ActionCardsName.WILD_RENT, 3));
        cards.add(new Rent(Colors.DARK_BLUE, Colors.GREEN));
        cards.add(new Rent(Colors.DARK_BLUE, Colors.GREEN));
        cards.add(new Rent(Colors.BROWN, Colors.LIGHT_BLUE));
        cards.add(new Rent(Colors.BROWN, Colors.LIGHT_BLUE));
        cards.add(new Rent(Colors.ORANGE, Colors.PURPLE));
        cards.add(new Rent(Colors.ORANGE, Colors.PURPLE));
        cards.add(new Rent(Colors.RAILROAD, Colors.UTILITY));
        cards.add(new Rent(Colors.RAILROAD, Colors.UTILITY));
        cards.add(new Rent(Colors.RED, Colors.YELLOW));
        cards.add(new Rent(Colors.RED, Colors.YELLOW));
        return cards;
    }

    private static List<AbstractCard> getAllPropertyCards() {
        List<AbstractCard> cards = new ArrayList<>();
        cards.add(new SingleColorProperty("BALTIC AVENUE", 1, Colors.BROWN));
        cards.add(new SingleColorProperty("MEDITERRANEAN AVENUE", 1, Colors.BROWN));
        cards.add(new SingleColorProperty("BOARDWALK", 4, Colors.DARK_BLUE));
        cards.add(new SingleColorProperty("PARK PLACE", 4, Colors.DARK_BLUE));
        cards.add(new SingleColorProperty("NORTH CAROLINA AVENUE", 4, Colors.GREEN));
        cards.add(new SingleColorProperty("PACIFIC AVENUE", 4, Colors.GREEN));
        cards.add(new SingleColorProperty("PENNSYLVANIA AVENUE", 4, Colors.GREEN));
        cards.add(new SingleColorProperty("CONNECTICUT AVENUE", 1, Colors.LIGHT_BLUE));
        cards.add(new SingleColorProperty("ORIENTAL AVENUE", 1, Colors.LIGHT_BLUE));
        cards.add(new SingleColorProperty("VERMONT AVENUE", 1, Colors.LIGHT_BLUE));
        cards.add(new SingleColorProperty("NEW YORK AVENUE", 2, Colors.ORANGE));
        cards.add(new SingleColorProperty("ST.JAMES PLACE", 2, Colors.ORANGE));
        cards.add(new SingleColorProperty("TENNESSEE AVENUE", 2, Colors.ORANGE));
        cards.add(new SingleColorProperty("ST.CHARLES PLACE", 2, Colors.PURPLE));
        cards.add(new SingleColorProperty("VIRGINIA AVENUE", 2, Colors.PURPLE));
        cards.add(new SingleColorProperty("STATES AVENUE", 2, Colors.PURPLE));
        cards.add(new SingleColorProperty("SHORT LINE", 2, Colors.RAILROAD));
        cards.add(new SingleColorProperty("B.&O. RAILROAD", 2, Colors.RAILROAD));
        cards.add(new SingleColorProperty("READING RAILROAD", 2, Colors.RAILROAD));
        cards.add(new SingleColorProperty("PENNSYLVANIA RAILROAD", 2, Colors.RAILROAD));
        cards.add(new SingleColorProperty("KENTUCKY AVENUE", 3, Colors.RED));
        cards.add(new SingleColorProperty("INDIANA AVENUE", 3, Colors.RED));
        cards.add(new SingleColorProperty("ILLINOIS AVENUE", 3, Colors.RED));
        cards.add(new SingleColorProperty("WATER WORKS", 2, Colors.UTILITY));
        cards.add(new SingleColorProperty("ELECTRIC COMPANY", 2, Colors.UTILITY));
        cards.add(new SingleColorProperty("VENTNOR AVENUE", 3, Colors.YELLOW));
        cards.add(new SingleColorProperty("MARVIN GARDENS", 3, Colors.YELLOW));
        cards.add(new SingleColorProperty("ATLANTIC AVENUE", 3, Colors.YELLOW));

        cards.add(new DoubleColorProperty(2, Colors.ORANGE, Colors.PURPLE));
        cards.add(new DoubleColorProperty(2, Colors.ORANGE, Colors.PURPLE));
        cards.add(new DoubleColorProperty(1, Colors.LIGHT_BLUE, Colors.BROWN));
        cards.add(new DoubleColorProperty(4, Colors.LIGHT_BLUE, Colors.RAILROAD));
        cards.add(new DoubleColorProperty(4, Colors.DARK_BLUE, Colors.GREEN));
        cards.add(new DoubleColorProperty(4, Colors.GREEN, Colors.RAILROAD));
        cards.add(new DoubleColorProperty(3, Colors.RED, Colors.YELLOW));
        cards.add(new DoubleColorProperty(3, Colors.RED, Colors.YELLOW));
        cards.add(new DoubleColorProperty(2, Colors.UTILITY, Colors.RAILROAD));

        cards.add(new WildCard());
        cards.add(new WildCard());
        return cards;
    }
}
