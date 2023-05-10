package controller;

import model.*;
import model.actioncards.ActionCardsName;
import view.PlayerInputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerController {
    public static void playCards(Player player) {
        Map<Integer, String> allChoices = getAllChoicesOfCard();
        player.resetNumberOfPlays();
        List<AbstractCard> cards = player.getHandCards();
        while (player.getNumberOfPlays() < 3) {
            /**
             * 1. 出牌次数归0, 选牌
             * 2. 涉及三个操作： 放到bank，放到property，打出到center
             *    1. 放到bank的只能是BankCard
             *    2. 放到Property的只能是Property
             * 3. 出牌次数加1
             */
            int cardIndex = PlayerInputView.getCardIndex(cards.size());
            AbstractCard cardToPlay = cards.get(cardIndex);

            List<Integer> availChoices = getCardChoices(cardToPlay);
            int action;
            if (availChoices.size() == 1) {
                action = availChoices.get(0);
            } else {
                action = PlayerInputView.getPlayerChoiceFromAvailChoices(availChoices, allChoices);
            }
        }
    }

    private static List<Integer> getCardChoices(AbstractCard card) {
        List<Integer> choices = new ArrayList<>();
        if (card instanceof ActionCard
                && !card.getName().equals(ActionCardsName.HOTEL.toString())
                && !card.getName().equals(ActionCardsName.HOUSE.toString())) {
            // All action cards except HOTEL and HOUSE can be played in to center.
            choices.add(0);
        }
        if (card instanceof IBankCard) {
            choices.add(1);
        }
        if (card instanceof IPropertyCard) {
            choices.add(2);
        }
        return choices;
    }

    /***
     * Get all choices how a card can be played.
     * @return Choices Map
     */
    private static Map<Integer, String> getAllChoicesOfCard() {
        Map<Integer, String> choices = new HashMap<>();
        choices.put(0, "Play into center");
        choices.put(1, "Play into bank");
        choices.put(2, "Play into properties");
        return choices;
    }
}
