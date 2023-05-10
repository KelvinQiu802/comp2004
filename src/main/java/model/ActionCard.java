package model;

import model.actioncards.ActionCardsName;

public abstract class ActionCard extends AbstractCard implements IBankCard {
    private ActionCardsName actionName;

    public ActionCard(ActionCardsName actionName, int value, String description) {
        super(actionName.getCardName(), CardTypes.ACTION, value, description);
        this.actionName = actionName;
    }

    @Override
    abstract public void play();
}
