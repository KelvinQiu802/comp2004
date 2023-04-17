package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<AbstractCard> handCards;
    private Bank bank;
    private int numberOfPlays;

    public Player(String name) {
        this.name = name;
        handCards = new ArrayList<>();
        bank = new Bank();
        numberOfPlays = 0;
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
        numberOfPlays++;
    }

    /***
     * Put the card from hand into bank.
     * @param card the card want to put
     */
    public void putIntoBank(IBankCard card) {
        handCards.remove(card);
        bank.add(card);
        numberOfPlays++;
    }

    /***
     * Put the card from hand into property.
     * @param card the card want to put
     */
    public void putIntoProperty(PropertyCard card) {
        // TODO
        numberOfPlays++;
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

    public String getName() {
        return name;
    }

    /***
     * Check whether player can keep playing card.
     * @return true if player can keep playing card.
     */
    public boolean canPlayCard() {
        return numberOfPlays < 3;
    }

    /***
     * Set number of plays to 0.
     */
    public void resetNumberOfPlays() {
        numberOfPlays = 0;
    }
}