package model;

import controller.Game;
import model.actioncards.*;
import utils.CardUtils;
import view.CardDisplayView;
import view.PlayerInputView;
import view.PropertyDisplayView;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<AbstractCard> handCards;
    private Bank bank;
    private PropertyDeck propertyDeck;
    private int numberOfPlays;
    private boolean doubleTheRent;

    public Player(String name) {
        this.name = name;
        handCards = new ArrayList<>();
        bank = new Bank();
        numberOfPlays = 0;
        propertyDeck = new PropertyDeck();
        doubleTheRent = false;
    }

    /***
     * Draw a card from draw pile.
     * @param pile the draw pile
     */
    public void draw(DrawPile pile) {
        handCards.add(pile.takeCard());
    }

    /***
     * Choose the card to play and drop it to the center.
     */
    public void playIntoCenter(AbstractCard card, DrawPile pile) {
        // EXCEPTION
        // can not play double the rent before the rent card
        if (card instanceof DoubleTheRent) {
            System.out.println("You cannot play Double The Rent before playing the Rent card!");
            return;
        }
        // if the card is Rent and player have Double The Rent, ask whether play it.
        if (card instanceof Rent
                && hasCard(ActionCardsName.DOUBLE_THE_RENT.toString())
        ) {
            System.out.println("Do you want to use Double The Rent?");
            if (PlayerInputView.yesOrNo()) {
                System.out.println("Rent is doubled!");
                doubleTheRent = true;
            }
        }

        card.play(this, Game.getPlayers());
        dropToCenter(card, pile);
        numberOfPlays++;
    }

    /***
     * Search player card by card name
     * @param cardName card name
     * @return true iff has the card, else false
     */
    private boolean hasCard(String cardName) {
        for (AbstractCard card : handCards) {
            if (card.getName().equals(cardName)) {
                return true;
            }
        }
        return false;
    }

    /***
     * Put the card from hand into bank.
     * @param card the card want to put
     */
    public void putIntoBank(IBankCard card) {
        handCards.remove((AbstractCard) card);
        bank.add(card);
        numberOfPlays++;
    }

    /***
     * Put the card from hand into property.
     * @param card the card want to put
     */
    public void putIntoProperty(IPropertyCard card) {
        if (propertyDeck.getPropertySets().size() != 0) {
            PropertyDisplayView.printPropertyDeck(propertyDeck);
            // Add card to a property set
            while (true) {
                int target = PlayerInputView.getTargetPropertySet(propertyDeck);
                if (target == -1) {
                    // Insert to a new set
                    propertyDeck.insertIntoNewSet(card);
                    break;
                } else {
                    PropertySet targetSet = propertyDeck.getPropertySets().get(target);
                    if (canAddToTargetPropertySet(card, targetSet)) {
                        targetSet.add(card);
                        break;
                    }
                    System.out.println("You cannot add this card into this property set.");
                }
            }
        } else {
            // Insert to a new set
            propertyDeck.insertIntoNewSet(card);
        }
        PropertyDisplayView.printPropertyDeck(propertyDeck);
        handCards.remove(card);
        numberOfPlays++;
    }

    /***
     * Moving card in the property deck
     * @param card card
     */
    public void moveCardInProperty(IPropertyCard card) {
        // Move to an existing set OR Create a new set
        System.out.println("Would you like to move to an existing property set or create a new set?");
        while (true) {
            int targetIndex = PlayerInputView.getTargetPropertySet(propertyDeck);
            if (targetIndex != -1) {
                // Moving to an existing set
                PropertySet ps = propertyDeck.getPropertySets().get(targetIndex);
                if (canAddToTargetPropertySet(card, ps)) {
                    propertyDeck.removeCard(card);
                    ps.add(card);
                    break;
                }
                System.out.println("You cannot add this card into this property set.");
            } else {
                // Moving to a new set
                propertyDeck.removeCard(card);
                propertyDeck.insertIntoNewSet(card);
                break;
            }
        }
    }

    /***
     * A helper method to add a property card into an existing property set
     * @param card card
     * @param targetSet target set
     * @return true iff can insert
     */
    private boolean canAddToTargetPropertySet(IPropertyCard card, PropertySet targetSet) {
        if (checkColor(card, targetSet)
                && checkHouse(card, targetSet)
                && checkHotel(card, targetSet)) {
            // can insert
            return true;
        }
        System.out.println("Cannot add this card in to this property set.");
        return false;
    }

    /***
     * A helper to method to check the color integrity of a property set
     * @param card card
     * @param targetSet set
     * @return true iff can add, else false
     */
    private boolean checkColor(IPropertyCard card, PropertySet targetSet) {
        // TODO: 暂时没有加入手动切换双色牌颜色的功能 （不是在这里添加，就在这里随便记一下）
        if (card.getCurrentColor() == Colors.ANY || targetSet.getColor() == Colors.ANY) {
            return true;
        }
        if (card instanceof DoubleColorProperty) {
            // Two Colors Wild Card
            DoubleColorProperty prop = (DoubleColorProperty) card;
            if (prop.getFirstColor().equals(targetSet.getColor())
                    || prop.getSecondColor().equals(targetSet.getColor())) {
                prop.setCurrentColor(targetSet.getColor());
                return true;
            }
        } else {
            // One color property
            return targetSet.getColor().equals(card.getCurrentColor());
        }
        return false;
    }

    /***
     * A helper method to check the house card rule
     * @param card card
     * @param targetSet set
     * @return true iff can build a house on this set
     */
    private boolean checkHouse(IPropertyCard card, PropertySet targetSet) {
        if (!(card instanceof House)) {
            return true;
        }
        if (targetSet.getProperties().get(targetSet.getProperties().size() - 1) instanceof House) {
            // already have a house
            return false;
        }
        return targetSet.isFullSet();
    }

    /***
     * A helper method to check the hotel card rule
     * @param card card
     * @param targetSet set
     * @return true iff can build a hotel on this set
     */
    private boolean checkHotel(IPropertyCard card, PropertySet targetSet) {
        if (!(card instanceof Hotel)) {
            return true;
        }
        return targetSet.getProperties().get(targetSet.getProperties().size() - 1) instanceof House;
    }

    /***
     * Drop the card to the center.
     * @param card the card want to drop
     * @param pile the draw pile
     */
    public void dropToCenter(AbstractCard card, DrawPile pile) {
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

    public String getName() {
        return name;
    }

    /***
     * Check whether player can keep playing card.
     * @return true if player can keep playing card.
     */
    public boolean canPlayCard() {
        return numberOfPlays < 3;
    }

    /***
     * Set number of plays to 0.
     */
    public void resetNumberOfPlays() {
        numberOfPlays = 0;
    }

    public int getNumberOfPlays() {
        return numberOfPlays;
    }

    public PropertyDeck getPropertyDeck() {
        return propertyDeck;
    }

    public void payTo(Player target, int price) {
        int count = 0;
        while (count < price) {
            // No cards in the bank and the property, pass
            if (bank.getBankCards().size() == 0 && propertyDeck.getPropertySets().size() == 0) {
                System.out.println("There are no cards in the bank and the property deck -> PASS");
                return;
            }
            // Print bank and properties
            System.out.println("==Bank==");
            CardDisplayView.printCard((AbstractCard) bank.getBankCards());
            System.out.println("==Properties==");
            PropertyDisplayView.printPropertyDeck(propertyDeck);
            // Choose bank or properties
            int source = PlayerInputView.getBankOrProperty();
            if (source == 0) {
                //From bank
                if (bank.getBankCards().size() == 0) {
                    System.out.println("You do not have any card in the bank");
                    continue;
                }
                // Choose which card
                int cardIndex = PlayerInputView.getCardIndex(bank.getBankCards().size());
                AbstractCard card = (AbstractCard) bank.getBankCards().get(cardIndex);
                count += card.getValue();
                // Give this card to target
                bank.remove((IBankCard) card);
                target.bank.add((IBankCard) card);
            } else {
                // From properties
                if (propertyDeck.getPropertySets().size() == 0) {
                    System.out.println("You do not have any card in the properties");
                    continue;
                }
                // Choose which card
                int cardIndex = PlayerInputView.getTargetPropertyCard(propertyDeck);
                IPropertyCard card = CardUtils.getPropertyCardByIndex(propertyDeck, cardIndex);
                count += ((AbstractCard) card).getValue();
                // Give this card to target
                propertyDeck.removeCard(card);
                putIntoProperty(card);
            }
        }
    }

    public Colors selectColor(List<Colors> AvailableColor) {
        // Print colors
        CardDisplayView.printColor(AvailableColor);

        // Choose the color
        return AvailableColor.get(PlayerInputView.getColorIndex(AvailableColor.size()));
    }

    public int calculateRent(Colors color) {
        int count = 0;
        List<PropertySet> propertySets = this.getPropertyDeck().getPropertySets();
        for (PropertySet set : propertySets) {
            if (set.getColor() == color)
                count = count + set.getRent();
        }
        if (doubleTheRent) {
            return count * 2;
        }
        return count;
    }
}