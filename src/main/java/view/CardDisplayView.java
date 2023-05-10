package view;

import com.jakewharton.fliptables.FlipTable;
import model.AbstractCard;

import java.util.ArrayList;
import java.util.List;

public class CardDisplayView {
    /***
     * Print a card in a table.
     * @param card Card
     */
    public static void printCard(AbstractCard card) {
        List<AbstractCard> cards = new ArrayList<>();
        cards.add(card);
        printCard(cards);
    }

    /***
     * Print a list of cards in a table.
     * @param cards Cards want to print
     */
    public static void printCard(List<AbstractCard> cards) {
        String[] header = {"Index", "Name", "Value", "Type"};
        String[][] data = new String[cards.size()][4];
        for (int i = 0; i < cards.size(); i++) {
            AbstractCard card = cards.get(i);
            data[i] = new String[]{String.valueOf(i), card.getName(), String.valueOf(card.getValue()),
                    card.getType().toString()};
        }
        System.out.println(FlipTable.of(header, data));
    }
}
