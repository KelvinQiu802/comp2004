package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public String name;
    public List<AbstractCard> handCards;
    public Bank bank;

    public Player(String name) {
        this.name = name;
        handCards = new ArrayList<>();
        bank = new Bank();
    }

    /***
     * Draw a card from draw pile.
     */
    public boolean draw() {
        return false;
    }

    /***
     * Choose the card to use and modify the layout of your properties.
     */
    public void play() {

    }

    /***
     * Drop the card to the center.
     */
    private void dropToCenter() {

    }

    /***
     * Judge if you have won the game.
     */
    public boolean isWin() {
        return false;
    }
}