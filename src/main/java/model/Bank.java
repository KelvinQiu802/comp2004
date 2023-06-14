package model;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<AbstractCard> bankCards;

    public Bank() {
        bankCards = new ArrayList<>();
    }

    /***
     * Add card to bank.
     * @param card The card want to add.
     */
    public void add(AbstractCard card) {
        bankCards.add(card);
    }

    /***
     * Remove card from bank and return it.
     * @param card The card want to remove.
     * @return The card removed.
     */
    public IBankCard remove(IBankCard card) {
        bankCards.remove(card);
        return card;
    }

    /***
     * Getter of bank cards list.
     * @return bank cards list
     */
    public List<AbstractCard> getBankCards() {
        return new ArrayList<>(bankCards);
    }
}
