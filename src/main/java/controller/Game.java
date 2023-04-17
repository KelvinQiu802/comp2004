package controller;

import model.DrawPile;
import model.Player;
import view.PlayerCreationView;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static List<Player> players = new ArrayList<>();
    private static DrawPile drawPile = new DrawPile(CardFactory.createCards());

    public static void main(String[] args) {
        createPlayers();
        dealFiveCardsToAllPlayer();
    }

    /***
     * Create players list.
     */
    public static void createPlayers() {
        int numberOfPlayer = PlayerCreationView.getNumberOfPlayer();
        for (int i = 0; i < numberOfPlayer; i++) {
            createUniquePlayer();
        }
    }

    /***
     * Create player without name repetition.
     */
    private static void createUniquePlayer() {
        while (true) {
            String name = PlayerCreationView.getPlayerName();
            if (!haveSameName(name)) {
                players.add(new Player(name));
                break;
            }
            System.out.println("The player's name cannot be repeated!");
        }
    }

    /***
     * Check whether the name is repeated.
     * @param name the name want to use
     * @return true if the name is repeated.
     */
    private static boolean haveSameName(String name) {
        for (Player p : players) {
            if (p.getName().equals(name)) {
                return true;
            }
        }
        return false;
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