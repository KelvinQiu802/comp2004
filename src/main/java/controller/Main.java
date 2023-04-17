package controller;

import model.AbstractCard;
import model.DrawPile;
import model.Player;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Player> players = new ArrayList<>();
    private static DrawPile drawPile;

    private static void dealCards(Player player, int num) {
        for (int i = 0; i < num; i++) {
            player.draw();
        }
    }

    public static void main(String[] args) {
        players.add(new Player("A"));
        players.add(new Player("B"));
        drawPile = new DrawPile(CardFactory.createCards());
        for(Player player: players){
            dealCards(player, 5);
        }


    }
}
