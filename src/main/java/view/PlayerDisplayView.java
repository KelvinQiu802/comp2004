package view;

import com.jakewharton.fliptables.FlipTable;
import model.Player;

import java.util.List;

public class PlayerDisplayView {
    /***
     * Print all players in the table.
     * @param players all players
     */
    public static void printPlayer(List<Player> players) {
        String[] header = {"Index", "Player"};
        String[][] data = new String[players.size()][2];
        for (int i = 0; i < players.size(); i++) {
            data[i] = new String[]{String.valueOf(i), String.valueOf(players.get(i).getName())};
        }
        System.out.println(FlipTable.of(header, data));
    }
}
