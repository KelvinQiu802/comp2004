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
        shuffle();
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
     * Take one cards from the draw pile.
     * @return the card that was taken out.
     */
    public AbstractCard takeCard() {
        AbstractCard card = usingCards.remove(0);
        if (usingCards.size() == 0) {
            swap();
            shuffle();
        }
        return card;
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
