package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DrawPile {
    private List<AbstractCard> usingCard;
    private List<AbstractCard> usedCard;

    public DrawPile() {
        usingCard = new ArrayList<>();
        usedCard = new ArrayList<>();
    }

    /***
     * Swap the using cards and the used cards.
     */
    public void swap() {
        List<AbstractCard> temp = usingCard;
        usingCard = usedCard;
        usedCard = temp;
    }

    /***
     * Put the card into  used cards.
     * @param abstractCard the card that player used
     */
    public void add(AbstractCard abstractCard) {
        usedCard.add(abstractCard);
    }

    /***
     * Take a card from using cards.
     * @return the card that player will take
     */
    public AbstractCard remove() {
        AbstractCard card = usingCard.get(0);
        usingCard.remove(0);
        return card;
    }

    /***
     * Shuffle the using cards
     */
    public void shuffle() {
        Collections.shuffle(usingCard);
    }

    /***
     * Getter of using cards.
     * @return using cards
     */
    public List<AbstractCard> getUsingCard() {
        return new ArrayList<>(usingCard);
    }

    /***
     * Getter of used cards.
     * @return used cards
     */
    public List<AbstractCard> getUsedCard() {
        return new ArrayList<>(usedCard);
    }
}
