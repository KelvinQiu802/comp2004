package controller;

import model.AbstractCard;
import model.actioncards.ActionCardsName;
import model.actioncards.DealBreaker;

public class ActionCardFactory {
    public AbstractCard create(ActionCardsName cardName) {
        if (cardName == ActionCardsName.DEAL_BREAKER) {
            return new DealBreaker();
        }
        return null;
    }
}
