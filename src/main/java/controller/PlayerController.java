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
        Map<Integer, String> allChoices = getAllChoicesOfCard();
        player.resetNumberOfPlays();
        List<AbstractCard> cards = player.getHandCards();
        while (player.getNumberOfPlays() < 3) {
            // select card
            int cardIndex = PlayerInputView.getCardIndex(cards.size());
            AbstractCard cardToPlay = cards.get(cardIndex);

            // select action
            List<Integer> availChoices = getCardChoices(cardToPlay);
            int action;
            if (availChoices.size() == 1) {
                action = availChoices.get(0);
            } else {
                action = PlayerInputView.getPlayerChoiceFromAvailChoices(availChoices, allChoices);
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
        choices.put(0, "Play into CENTER");
        choices.put(1, "Play into BANK");
        choices.put(2, "Play into PROPERTIES");
        return choices;
    }
}
