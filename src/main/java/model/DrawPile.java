package model;

import java.util.ArrayList;
import java.util.Collections;

public class DrawPile {
    ArrayList<AbstractCard> usingCard=new ArrayList<>();
    ArrayList<AbstractCard> usedCard=new ArrayList<>();

    /***
     * swap the using cards and the used cards when the using cards is empty
     */
    public void swap(){
        if(usingCard.isEmpty()){
            ArrayList<AbstractCard> temp=usingCard;
            usingCard=usedCard;
            usedCard=temp;
        }
    }

    /***
     * put the card into  used cards
     * @param abstractCard the card that player used
     */
    public void add(AbstractCard abstractCard){
        usedCard.add(abstractCard);
    }

    /***
     * take a card from using cards
     * @return the card that player will take
     */
    public AbstractCard remove(){
        AbstractCard card=usingCard.get(0);
        usingCard.remove(0);
        return card;
    }

    /***
     * shuffle the using cards
     */
    public void shuffle(){
        Collections.shuffle(usingCard);
    }
}
