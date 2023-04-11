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
    public void swap() {
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
     * Take a card from using cards.
     * @return the card that player will take
     */
    public AbstractCard take() {
        return usingCards.remove(0);
    }

    /***
     * Shuffle the using cards
     */
    public void shuffle() {
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
