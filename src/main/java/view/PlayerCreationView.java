package view;

import java.util.Scanner;

public class PlayerCreationView {
    public static void main(String[] args) {
        getNumberOfPlayer();
    }

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
            System.out.println("The Number of Players: ");
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
}
