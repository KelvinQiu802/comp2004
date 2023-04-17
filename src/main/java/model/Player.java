package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<AbstractCard> handCards;
    private Bank bank;

    public Player(String name) {
        this.name = name;
        handCards = new ArrayList<>();
        bank = new Bank();
    }

    /***
     * Draw a card from draw pile.
     * @param pile the draw pile
     */
    public void draw(DrawPile pile) {
        handCards.add(pile.takeCard());
    }

    /***
     * Choose the card to play and drop it to the center.
     */
    public void playAndDrop(AbstractCard card, DrawPile pile) {
        // TODO
        dropToCenter(card, pile);
    }

    /***
     * Put the card from hand into bank.
     * @param card the card want to put
     */
    public void putIntoBank(IBankCard card) {
        handCards.remove(card);
        bank.add(card);
    }

    /***
     * Put the card from hand into property.
     * @param card the card want to put
     */
    public void putIntoProperty(PropertyCard card) {
        // TODO
    }

    /***
     * Drop the card to the center.
     * @param card the card want to drop
     * @param pile the draw pile
     */
    private void dropToCenter(AbstractCard card, DrawPile pile) {
        handCards.remove(card);
        pile.add(card);
    }

    /***
     * Judge if you have won the game.
     */
    public boolean isWin() {
        return false;
    }

    public List<AbstractCard> getHandCards() {
        return handCards;
    }
}