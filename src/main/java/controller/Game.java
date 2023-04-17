package controller;

import model.DrawPile;
import model.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static List<Player> players = new ArrayList<>();
    private static DrawPile drawPile = new DrawPile(CardFactory.createCards());

    public static void main(String[] args) {
        //TODO: Create Player
        players.add(new Player("A"));
        players.add(new Player("B"));

        dealFiveCardsToAllPlayer();
    }

    /***
     * Deal any number of cards to a player.
     * @param player the target
     * @param num number of cards
     */
    public static void dealCards(Player player, int num) {
        for (int i = 0; i < num; i++) {
            player.draw(drawPile);
        }
    }

    /***
     * Deal five cards to every player at the begining of the game.
     */
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