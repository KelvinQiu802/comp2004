package model.actioncards;

import model.ActionCard;
import model.Player;

public class WildRent extends ActionCard {
    public WildRent() {
        super(ActionCardsName.WILD_RENT, 3, "Force one player to pay you rent for properties you own " +
                "in one of these colors.");
    }

    @Override
    public void play(Player currentPlayer) {
        // 1. 确认颜色
        // 2. 计算收多少钱
        // 3. 确认收租对象
        // TODO: input the player be rented
        // 4. 收钱
    }
}
