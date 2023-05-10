package view;

import utils.IntegerChecker;
import utils.StringChecker;

import java.util.Scanner;

public class PlayerInputView {
    /***
     * Get the number of players.
     * @return the number of players
     */
    public static int getNumberOfPlayer() {
        int number;
        while (true) {
            number = getAnyNumberOfPlayer();
            if (number > 1) {
                break;
            }
            System.out.println("The number of players MUST greater then 2. PLEASE TRY AGAIN!");
        }
        return number;
    }

    private static int getAnyNumberOfPlayer() {
        Scanner scanner = new Scanner(System.in);
        String numberOfPlayer = "";
        do {
            System.out.print("The Number of Players: ");
            numberOfPlayer = scanner.nextLine();
        } while (!StringChecker.isInteger(numberOfPlayer));
        return Integer.parseInt(numberOfPlayer);
    }

    /***
     * Get player name from console.
     * @return player name
     */
    public static String getPlayerName() {
        Scanner scanner = new Scanner(System.in);
        String playerName;
        do {
            System.out.print("Input Player Name: ");
            playerName = scanner.nextLine();
        } while (playerName.isBlank());
        return playerName;
    }

    /***
     * Get the index of card that player want to play.
     * @param numOfCards The number of cards.
     * @return Card index.
     */
    public static int getCardIndex(int numOfCards) {
        Scanner scanner = new Scanner(System.in);
        String index;
        do {
            System.out.printf("Input Card Index (0-%d): ", numOfCards);
            index = scanner.nextLine();
        } while (!StringChecker.isInteger(index) && IntegerChecker.inRange(Integer.parseInt(index), 0, numOfCards));
        return Integer.parseInt(index);
    }
}
