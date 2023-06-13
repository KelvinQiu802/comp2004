package view;

import model.IPropertyCard;
import model.PropertyDeck;
import model.PropertySet;
import utils.IntegerChecker;
import utils.Printer;
import utils.StringChecker;

import java.util.ArrayList;
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
            System.out.println("The number of players MUST greater than 2. PLEASE TRY AGAIN!");
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
        String prompt = String.format("Input the Card Index (0-%d):", numOfCards - 1);
        return getIntegerInput(prompt, 0, numOfCards - 1);
    }

    /***
     * Ask users select bank or  properties
     * @return 0 for  bank, 1 for properties
     */
    public static Integer getBankOrProperty() {
        String prompt = "Select card from Bank(0) or Properties(1): ";
        return getIntegerInput(prompt, 0, 1);
    }

    /***
     * Get the index of color that player want to choose.
     * @param numOfColors The number of colors player can select.
     * @return Color index
     */
    public static Integer getColorIndex(int numOfColors) {
        String prompt = String.format("Input the color index (0-%d)", numOfColors - 1);
        return getIntegerInput(prompt, 0, numOfColors - 1);
    }

    public static Integer getPlayerIndex(int numOfPlayers) {
        String prompt = String.format("Input the player index (0-%d):", numOfPlayers - 1);
        return getIntegerInput(prompt, 0, numOfPlayers - 1);
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
     * Get the index of the property set which player wants to add card
     * @param pd property deck
     * @return the index of the target set
     */
    public static int getTargetPropertySet(PropertyDeck pd) {
        String prompt = "Select the property set, or enter -1 to create a new set:";
        return getIntegerInput(prompt, -1, pd.getPropertySets().size() - 1);
    }

    /***
     * Get the index of the property set which player wants to add card
     * @param pd property deck
     * @return the index of the target set
     */
    public static int getFetchPropertySet(PropertyDeck pd) {
        String prompt = "Select the property set, or enter -1 to go back:";
        return getIntegerInput(prompt, -1, pd.getPropertySets().size() - 1);
    }

    /***
     * Get the index of the property card which player choose
     * @param pd property deck
     * @return the index of the property card
     */
    public static int getTargetPropertyCard(PropertyDeck pd) {
        String prompt = "Select the property card: ";
        int num = getNumOfAllPropertyCards(pd);
        return getIntegerInput(prompt, 0, num - 1);
    }

    /***
     * Get the index of the property card which player choose
     * @param ps property deck
     * @return the index of the property card
     */
    public static int getTargetPropertyCardInPropertySet(PropertySet ps) {
        String prompt = "Select the property card: ";
        int num = ps.getSize();
        return getIntegerInput(prompt, 0, num - 1);
    }

    /***
     * Get yes or no
     * @return true iff yes, else no
     */
    public static boolean yesOrNo() {
        int num = getIntegerInput("Yes(1), No(0): ", 0, 1);
        return num == 1;
    }

    /***
     * Ask user moving to an existing set or create a new set;
     * @return 0 if moving to an existing set; 1 if moving to an new set;
     */
    public static int moveToExistOrNew() {
        String prompt = "Would you like to move to an existing property set (0) or create a new set (1): ";
        List<Integer> choices = new ArrayList<>();
        choices.add(0);
        choices.add(1);
        return getIntegerInputFromList(prompt, choices);
    }

    /***
     * Get the number of all property cards
     * @param pd property deck
     * @return the number of all property cards
     */
    private static int getNumOfAllPropertyCards(PropertyDeck pd) {
        int count = 0;
        for (PropertySet ps : pd.getPropertySets()) {
            for (IPropertyCard card : ps.getProperties()) {
                count++;
            }
        }
        return count;
    }

    /***
     * Get player action from available actions
     * @param availChoices A list of integers
     * @param allChoices A map of actions
     * @return the integer user action
     */
    public static int getPlayerActionFromAvailActions(List<Integer> availChoices, Map<Integer, String> allChoices) {
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
        System.out.println("\n");
        Printer.printDashLine();
        return Integer.parseInt(result);
    }
}
