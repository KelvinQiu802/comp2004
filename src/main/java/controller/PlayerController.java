package controller;

import model.*;
import model.actioncards.Hotel;
import model.actioncards.House;
import utils.CardUtils;
import view.PlayerInputView;
import view.PropertyDisplayView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerController {
    /***
     * Player choose a card, select the action and play the card.
     * @param player Player
     * @param drawPile Draw Pile
     */
    public static void playCard(Player player, DrawPile drawPile) {
        Map<Integer, String> allActions = getAllActionsOfCard();
        List<AbstractCard> cards = player.getHandCards();
        // select card
        int cardIndex = PlayerInputView.getCardIndex(cards.size());
        AbstractCard cardToPlay = cards.get(cardIndex);

        // select action
        List<Integer> availActions = getCardActions(cardToPlay);
        int action;
        if (availActions.size() == 1) {
            action = availActions.get(0);
        } else {
            action = PlayerInputView.getPlayerActionFromAvailActions(availActions, allActions);
        }

        switch (action) {
            case 0:
                player.playIntoCenter(cardToPlay, drawPile);
                break;
            case 1:
                player.putIntoBank((IBankCard) cardToPlay);
                break;
            case 2:
                player.putIntoProperty((IPropertyCard) cardToPlay);
                break;
        }
    }

    public static void moveProperty(Player player) {
        PropertyDeck pd = player.getPropertyDeck();
        if (pd.getPropertySets().size() == 0) {
            System.out.println("No card to move.");
            return;
        }
        // Get the card
        PropertyDisplayView.printPropertyDeck(pd);
        int target = PlayerInputView.getTargetPropertyCard(pd);
        IPropertyCard card = CardUtils.getPropertyCardByIndex(pd, target);
        player.moveCardInProperty(card);
    }

    private static List<Integer> getCardActions(AbstractCard card) {
        List<Integer> actions = new ArrayList<>();
        if (card instanceof ActionCard
                && !(card instanceof Hotel)
                && !(card instanceof House)) {
            // All action cards except HOTEL and HOUSE can be played in to center.
            actions.add(0);
        }
        if (card instanceof IBankCard) {
            actions.add(1);
        }
        if (card instanceof IPropertyCard) {
            actions.add(2);
        }
        return actions;
    }

    /***
     * Get all choices how a card can be played.
     * @return Choices Map
     */
    private static Map<Integer, String> getAllActionsOfCard() {
        Map<Integer, String> actions = new HashMap<>();
        actions.put(0, "Play into CENTER");
        actions.put(1, "Play into BANK");
        actions.put(2, "Play into PROPERTIES");
        return actions;
    }
}
