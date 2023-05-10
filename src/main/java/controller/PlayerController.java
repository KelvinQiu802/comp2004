package controller;

import model.*;
import model.actioncards.ActionCardsName;
import view.PlayerInputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerController {
    public static void playCards(Player player, DrawPile drawPile) {
        Map<Integer, String> allActions = getAllActionsOfCard();
        player.resetNumberOfPlays();
        List<AbstractCard> cards = player.getHandCards();
        while (player.getNumberOfPlays() < 3) {
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
    }

    private static List<Integer> getCardActions(AbstractCard card) {
        List<Integer> actions = new ArrayList<>();
        if (card instanceof ActionCard
                && !card.getName().equals(ActionCardsName.HOTEL.toString())
                && !card.getName().equals(ActionCardsName.HOUSE.toString())) {
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
