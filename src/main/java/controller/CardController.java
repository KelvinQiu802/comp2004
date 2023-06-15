package controller;

import model.AbstractCard;

public class CardController {
    /***
     * Drop the card to the center.
     * @param card the card want to drop
     */
    public static void dropToCenter(AbstractCard card) {
        Game.getDrawPile().add(card);
    }
}
