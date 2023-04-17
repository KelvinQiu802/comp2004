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
     * Choose the card to use and modify the layout of your properties.
     */
    public void play() {

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