package model.actioncards;

import model.*;
import utils.CardUtils;
import view.PlayerDisplayView;
import view.PlayerInputView;
import view.PropertyDisplayView;
import java.util.List;

public class SlyDeal extends ActionCard {
    public SlyDeal() {
        super(ActionCardsName.SLY_DEAL, 3, "Steal a property from the player of your choice." +
                "(Cannot be part of a full set.)");
    }

    @Override
    public void play(Player currentPlayer, List<Player> players) {
        // 0. Print all players without current player
        List<Player> others = players;
        others.remove(currentPlayer);
        while (true) {
            PlayerDisplayView.printPlayer(others);
            // 1. Choose a player
            int playerIndex = PlayerInputView.getPlayerIndex(others.size());
            Player target = others.get(playerIndex);
            // 2 Print the property deck
            PropertyDisplayView.printPropertyDeck(target.getPropertyDeck());
            // 3. Chose a unfilled set
            int setIndex = PlayerInputView.getTargetPropertySet(target.getPropertyDeck());
            PropertySet set = target.getPropertyDeck().getPropertySets().get(setIndex);
            if (!set.isFullSet()) {
                // 4. Chose a card in select property set
                PropertyDisplayView.printPropertySet(set);
                int cardIndex = PlayerInputView.getTargetPropertyCardInPropertySet(set);
                IPropertyCard card = CardUtils.getPropertyCardByIndexInPropertySet(set, setIndex);
                // 5. Steal it
                target.getPropertyDeck().removeCard(card);
                currentPlayer.getPropertyDeck().insertIntoNewSet(card);
                return;
            }
        }
    }
}
