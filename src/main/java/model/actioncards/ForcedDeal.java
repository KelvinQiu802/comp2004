package model.actioncards;

import controller.Game;
import model.*;
import view.PlayerDisplayView;
import view.PlayerInputView;
import view.PropertyDisplayView;

import java.util.ArrayList;
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

            // Print the property deck
            PropertyDisplayView.printPropertyDeck(target.getPropertyDeck());

            // Choose a property set of target player which cannot be part of a full set
            int setIndexTarget = PlayerInputView.getTargetPropertySet(target.getPropertyDeck());
            PropertySet setTarget = target.getPropertyDeck().getPropertySets().get(setIndexTarget);
            if (!setTarget.isFullSet()) {
                // Choose a property card in this property set
                int propertyIndexTarget = PlayerInputView.getTargetPropertyCardInPropertySet(setTarget);
                IPropertyCard propertyTarget = setTarget.getProperties().get(propertyIndexTarget);
                // Take it
                target.getPropertyDeck().removeCard(propertyTarget);
                currentPlayer.getPropertyDeck().insertIntoNewSet(propertyTarget);

                // Print the property deck of current player
                PropertyDisplayView.printPropertyDeck(currentPlayer.getPropertyDeck());
                // Choose a property set of current player
                int setIndexCurrent = PlayerInputView.getTargetPropertySet(currentPlayer.getPropertyDeck());
                PropertySet setCurrent = currentPlayer.getPropertyDeck().getPropertySets().get(setIndexCurrent);
                //Choose a property card in this property set
                int propertyIndexCurrent = PlayerInputView.getTargetPropertyCardInPropertySet(setCurrent);
                IPropertyCard propertyCurrent = setCurrent.getProperties().get(propertyIndexCurrent);
                // Give it to target player
                currentPlayer.getPropertyDeck().removeCard(propertyCurrent);
                target.getPropertyDeck().insertIntoNewSet(propertyCurrent);
                return;
            }
            System.out.println("This is a full set, please try again!");
        }
    }
}