package model;

import model.actioncards.ActionCardsName;

import java.util.List;

public abstract class ActionCard extends AbstractCard implements IBankCard {
    private ActionCardsName actionName;

    public ActionCard(ActionCardsName actionName, int value, String description) {
        super(actionName.getCardName(), CardTypes.ACTION, value, description);
        this.actionName = actionName;
    }

    @Override
    abstract public void play(Player currentPlayer, List<Player> players, DrawPile pile);
}
