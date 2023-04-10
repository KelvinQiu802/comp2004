package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public String name;
    public List<AbstractCard> hand;
    public List<AbstractCard> bank;

    public Player(String name){
        this.name = name;
        hand = new ArrayList<> ();
        bank = new ArrayList<> ();
    }

    /***
     * Draw a card from draw pile.
     */
    public boolean draw(){
        return false;
    }

    /***
     * Choose the card to use and modify the layout of your properties.
     */
    public void play(){

    }

    /***
     * Drop the card to the center.
     */
    private void dropToCenter(){

    }

    /***
     * Judge if you have won the game.
     */
    public boolean isWin(){
        return false;
    }
}
