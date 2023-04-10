package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public String name;
    public boolean win;
    public List hand = new ArrayList<AbstractCard> ();
    public List bank = new ArrayList<AbstractCard> ();

    public Player(String n){
        name = n;
        win = false;
    }

    /***
     * Take two card when it's your turn to play. If there aren't enough card for you to draw, return false.
     */
    public boolean takeCard(){
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
    private boolean isWin(){
        return false;
    }
}
