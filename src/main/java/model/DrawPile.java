package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DrawPile {
    private List<AbstractCard> usingCards;
    private List<AbstractCard> usedCards;

    public DrawPile(List<AbstractCard> cardList) {
        usingCards = cardList;
        usedCards = new ArrayList<>();
    }

    /***
     * Swap the using cards and the used cards.
     */
    private void swap() {
        List<AbstractCard> temp = usingCards;
        usingCards = usedCards;
        usedCards = temp;
    }

    /***
     * Put the card into  used cards.
     * @param abstractCard the card that player used
     */
    public void add(AbstractCard abstractCard) {
        usedCards.add(abstractCard);
    }

    /***
     * Take num cards at one time
     * @param num the number of the cards that the player takes at one time
     * @return a list of cards that the player takes
     */
    public List<AbstractCard> takeCards(int num) {
        List<AbstractCard> cards=new ArrayList<>();
        for (int i=0;i<num;i++){
            AbstractCard card=usingCards.remove(0);
            usedCards.add(card);
            cards.add(card);
            if(usingCards.size()==0){
                swap();
                shuffle();
            }
        }
        return cards;
    }

    /***
     * Shuffle the using cards
     */
    private void shuffle() {
        Collections.shuffle(usingCards);
    }

    /***
     * Getter of using cards.
     * @return using cards
     */
    public List<AbstractCard> getUsingCards() {
        return new ArrayList<>(usingCards);
    }

    /***
     * Getter of used cards.
     * @return used cards
     */
    public List<AbstractCard> getUsedCards() {
        return new ArrayList<>(usedCards);
    }
}
