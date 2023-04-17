package controller;

import model.AbstractCard;
import model.actioncards.*;

public class ActionCardFactory {
    public static AbstractCard create(ActionCardsName cardName) {
        switch (cardName) {
            case DEAL_BREAKER:
                return new DealBreaker();
            case DEBT_COLLECTOR:
                return new DebtCollector();
            case DOUBLE_THE_RENT:
                return new DoubleTheRent();
            case FORCED_DEAL:
                return new ForcedDeal();
            case HOTEL:
                return new Hotel();
            case HOUSE:
                return new House();
            case ITS_MY_BIRTHDAY:
                return new MyBirthday();
            case JUST_SAY_NO:
                return new JustSayNo();
            case PASS_GO:
                return new PassGo();
            case SLY_DEAL:
                return new SlyDeal();
            default:
                return null;
        }
    }
}
