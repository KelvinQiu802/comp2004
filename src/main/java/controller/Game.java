package controller;

import model.DrawPile;
import model.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static List<Player> players = new ArrayList<>();
    private static DrawPile drawPile;

    public static void main(String[] args) {
        drawPile = new DrawPile(CardFactory.createCards());

        //TODO: Create Player
        players.add(new Player("A"));
        players.add(new Player("B"));

        dealFiveCardsToAllPlayer();
    }

    public static void dealCards(Player player, int num) {
        for (int i = 0; i < num; i++) {
            player.draw(drawPile);
        }
    }

    public static void dealFiveCardsToAllPlayer() {
        for (Player player : players) {
            dealCards(player, 5);
        }
    }

    public static List<Player> getPlayers() {
        return players;
    }

    public static DrawPile getDrawPile() {
        return drawPile;
    }
}