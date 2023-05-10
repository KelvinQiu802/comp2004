package view;

import utils.IntegerChecker;
import utils.Printer;
import utils.StringChecker;

import java.util.List;
import java.util.Map;
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
     * Get player choice from available choices
     * @param availChoices A list of integers
     * @param allChoices A map of choices
     * @return the integer user choose
     */
    public static int getPlayerChoiceFromAvailChoices(List<Integer> availChoices, Map<Integer, String> allChoices) {
        StringBuilder sb = new StringBuilder();
        sb.append("Please choose an action: \n");
        for (Integer choice : availChoices) {
            if (allChoices.containsKey(choice)) {
                sb.append(String.format("%d. %s\n", choice, allChoices.get(choice)));
            }
        }
        sb.append("Input your choice: ");
        return getIntegerInputFromList(sb.toString(), availChoices);
    }

    /***
     * A helper method to get user integer input from a choices list.
     * @param prompt Prompt message
     * @param choices A list of integer
     * @return the integer user chose
     */
    private static int getIntegerInputFromList(String prompt, List<Integer> choices) {
        Scanner scanner = new Scanner(System.in);
        String result;
        do {
            System.out.print(prompt);
            result = scanner.nextLine();
        } while (!StringChecker.isInteger(result) || !choices.contains(Integer.parseInt(result)));
        Printer.printDashLine();
        return Integer.parseInt(result);
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
        Printer.printDashLine();
        return Integer.parseInt(result);
    }
}
