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
        String prompt = String.format("Input the Card Index (0-%d):", numOfCards);
        return getIntegerInput(prompt, 0, numOfCards - 1);
    }

    /***
     * Ask user want to move properties or play a card.
     * @return 1 for play, 2 for move, 0 for pass.
     */
    public static int moveOrPlayOrPass() {
        String prompt = "Want to PLAY(1) properties or MOVE(2) a card or PASS(0)?\n" +
                "1 for PLAY, 2 for MOVE, 0 for PASS: ";
        return getIntegerInput(prompt, 0, 2);
    }

    /***
     * A helper method to get user integer input
     * @param prompt Prompt message
     * @param min Lower bound
     * @param max Upper bound
     * @return the integer user input
     */
    private static int getIntegerInput(String prompt, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        String result;
        do {
            System.out.print(prompt);
            result = scanner.nextLine();
        } while (!StringChecker.isInteger(result) || !IntegerChecker.inRange(Integer.parseInt(result), min, max));
        return Integer.parseInt(result);
    }

}
