package view;

import com.jakewharton.fliptables.FlipTable;
import model.AbstractCard;
import model.Colors;
import model.DoubleColorProperty;
import model.IPropertyCard;
import model.actioncards.Rent;

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
        String[] header = {"Index", "Name", "Value", "Type", "Description", "Color"};
        String[][] data = new String[cards.size()][6];
        for (int i = 0; i < cards.size(); i++) {
            AbstractCard card = cards.get(i);
            String color = "NULL";
            // Special Card
            if (card instanceof IPropertyCard) {
                color = ((IPropertyCard) card).getCurrentColor().toString();
            }
            if (card instanceof Rent) {
                Rent rent = (Rent) card;
                color = rent.getFirst() + " OR " + rent.getSecond();
            }
            if (card instanceof DoubleColorProperty) {
                DoubleColorProperty prop = (DoubleColorProperty) card;
                color = prop.getFirstColor() + " OR " + prop.getSecondColor();
            }
            data[i] = new String[]{String.valueOf(i), card.getName(), String.valueOf(card.getValue()),
                    card.getType().toString(), card.getDescription(), color};
        }
        System.out.println(FlipTable.of(header, data));
    }

    /***
     * Print all colors in the table
     * @param colors all colors
     */
    public static void printColor(List<Colors> colors) {
        String[] header = {"Index", "Color"};
        String[][] data = new String[colors.size()][2];
        for (int i = 0; i < colors.size(); i++) {
            data[i] = new String[]{String.valueOf(i), String.valueOf(colors.get(i))};
        }
        System.out.println(FlipTable.of(header, data));
    }

}
