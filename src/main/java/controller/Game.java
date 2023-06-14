package controller;

import model.AbstractCard;
import model.DrawPile;
import model.Player;
import utils.Printer;
import view.CardDisplayView;
import view.PlayerInputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private static List<Player> players = new ArrayList<>();
    private static DrawPile drawPile = new DrawPile(Printer.CardFactory.createCards());
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        createPlayers();
        dealFiveCardsToAllPlayer();
        Player winner = gameLoop();
        gameOver(winner);
    }

    /***
     * Create players list.
     */
    public static void createPlayers() {
        int numberOfPlayer = PlayerInputView.getNumberOfPlayer();
        for (int i = 0; i < numberOfPlayer; i++) {
            createUniquePlayer();
        }
    }

    /***
     * Create player without name repetition.
     */
    private static void createUniquePlayer() {
        while (true) {
            String name = PlayerInputView.getPlayerName();
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

    /***
     * Main game loop
     * @return The winner player
     */
    public static Player gameLoop() {
        while (true) {
            for (Player player : players) {
                playerTurn(player);
                if (player.isWin()) {
                    return player;
                }
            }
        }
    }

    public static void playerTurn(Player player) {
        player.resetNumberOfPlays();
        dealCards(player ,2);
        List<AbstractCard> handCards = player.getHandCards();
        while (true) {
            System.out.println(player.getName());
            CardDisplayView.printCard(handCards);
            // Play / Move / Pass
            int choice = PlayerInputView.moveOrPlayOrPass();
            if (choice == 0) {
                // Drop cards if more than seven
                dropCardsIfMore(player);
                // PASS
                System.out.println("PASS");
                break;
            } else if (choice == 1) {
                // PLAY
                if (player.getNumberOfPlays() < 3) {
                    PlayerController.playCard(player, drawPile);
                } else {
                    System.out.println("You're out of turns to play.");
                }
            } else {
                // Move Property
                PlayerController.moveProperty(player);
            }
        }
    }

    /***
     * Drop cards if more than seven
     * @param player current player
     */
    private static void dropCardsIfMore(Player player) {
        while (player.getHandCards().size() > 7) {
            int numOfCards = player.getHandCards().size();
            // Print all cards
            CardDisplayView.printCard(player.getHandCards());
            System.out.printf("You have %d cards, please drop %d cards.\n", numOfCards, numOfCards - 7);
            // Ask to drop which card
            int cardIndex = PlayerInputView.getCardIndex(player.getHandCards().size());
            // Drop the card to the center
            player.dropToCenter(player.getHandCards().get(cardIndex), drawPile);
        }
    }

    /***
     * To announce gamer is over
     * @param winner The winner
     */
    public static void gameOver(Player winner) {
        System.out.printf("GAME OVER! The WINNER IS %s", winner.getName().toUpperCase());
    }

    public static List<Player> getPlayers() {
        return players;
    }

    public static DrawPile getDrawPile() {
        return drawPile;
    }

    public static Scanner getScanner() {
        return scanner;
    }
}