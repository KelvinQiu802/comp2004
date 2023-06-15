package model.actioncards;

import model.ActionCard;
import model.IPropertyCard;
import model.Player;
import model.PropertySet;
import utils.CardUtils;
import view.PlayerDisplayView;
import view.PlayerInputView;
import view.PropertyDisplayView;

import java.util.List;

public class ForcedDeal extends ActionCard {
    public ForcedDeal() {
        super(ActionCardsName.FORCED_DEAL, 3, "Swap any property with another player." +
                "(Cannot be part of a full set.)");
    }

    @Override
    public void play(Player currentPlayer, List<Player> players) {
        // Print all players without current player
        List<Player> others = players;
        others.remove(currentPlayer);
        while (true) {
            PlayerDisplayView.printPlayer(others);
            // Choose a player
            int playerIndex = PlayerInputView.getPlayerIndex(others.size());
            Player target = others.get(playerIndex);
            if (target.sayNo()) {
                return;
            }
            // Print the property deck
            PropertyDisplayView.printPropertyDeck(target.getPropertyDeck());
            // Choose a property set of target player which cannot be part of a full set
            int setIndexTarget = PlayerInputView.getTargetPropertySet(target.getPropertyDeck());
            PropertySet setTarget = target.getPropertyDeck().getPropertySets().get(setIndexTarget);
            if (!setTarget.isFullSet()) {
                // Choose a property card in this property set
                PropertyDisplayView.printPropertySet(setTarget);
                int cardIndexTarget = PlayerInputView.getTargetPropertyCardInPropertySet(setTarget);
                IPropertyCard cardTarget = CardUtils.getPropertyCardByIndexInPropertySet(setTarget, setIndexTarget);
                // Take it
                target.getPropertyDeck().removeCard(cardTarget);
                currentPlayer.getPropertyDeck().insertIntoNewSet(cardTarget);

                // Print the property deck of current player
                PropertyDisplayView.printPropertyDeck(currentPlayer.getPropertyDeck());
                // Choose a property set of current player
                int setIndexCurrent = PlayerInputView.getTargetPropertySet(currentPlayer.getPropertyDeck());
                PropertySet setCurrent = currentPlayer.getPropertyDeck().getPropertySets().get(setIndexCurrent);
                //Choose a property card in this property set
                int cardIndexCurrent = PlayerInputView.getTargetPropertyCardInPropertySet(setCurrent);
                IPropertyCard cardCurrent = CardUtils.getPropertyCardByIndexInPropertySet(setCurrent, setIndexCurrent);
                // Give it to target player
                currentPlayer.getPropertyDeck().removeCard(cardCurrent);
                target.getPropertyDeck().insertIntoNewSet(cardCurrent);
                return;
            }
            System.out.println("This is a full set, please try again!");
        }
    }
}