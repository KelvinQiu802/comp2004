package model.actioncards;

import controller.Game;
import model.ActionCard;
import model.Colors;
import model.Player;

import java.util.List;

public class Rent extends ActionCard {
    private Colors first;
    private Colors second;

    public Rent(Colors first, Colors second) {
        super(ActionCardsName.RENT, 1, "All players pay you rent for properties you own in one of " +
            "these colors.");
        this.first = first;
        this.second = second;
    }

    @Override
    public void play(Player currentPlayer) {
        // 1. 选择某个颜色进行Rent
        List<Colors> colorsList = List.of(first, second);
        int colorIndex = currentPlayer.selectColor(colorsList);

        // 2. 计算每人收多少钱
        // 3. 收钱
    }
}
