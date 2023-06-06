package view;

import com.jakewharton.fliptables.FlipTable;
import model.AbstractCard;
import model.IPropertyCard;
import model.PropertyDeck;
import model.PropertySet;
import utils.Printer;

import java.util.List;

public class PropertyDisplayView {
    public static void printPropertyDeck(PropertyDeck pd) {
        List<PropertySet> sets = pd.getPropertySets();
        String[] outerHeader = new String[sets.size()];
        String[][] outerData = new String[1][sets.size()];
        for (int i = 0; i < sets.size(); i++) {
            outerHeader[i] = i + ": " + sets.get(i).getColor().toString();
        }

        String[] innerHeader = {"Index", "Name"};
        int counter = 0;
        for (int i = 0; i < sets.size(); i++) {
            PropertySet ps = sets.get(i);
            String[][] innerData = getPropertySetData(ps, counter);
            counter += ps.getProperties().size();
            String inner = FlipTable.of(innerHeader, innerData);
            outerData[0][i] = inner;
        }
        System.out.println(FlipTable.of(outerHeader, outerData));
    }

    public static void printPropertySet(PropertySet ps) {
        String[] header = {"Index", "Name"};
        String[][] data = getPropertySetData(ps, 0);
        System.out.printf("###%s###\n", ps.getColor());
        System.out.println(FlipTable.of(header, data));
        Printer.printDashLine();
    }

    private static String[][] getPropertySetData(PropertySet ps, int counter) {
        List<IPropertyCard> properties = ps.getProperties();
        String[][] data = new String[properties.size()][2];
        for (int i = 0; i < properties.size(); i++) {
            AbstractCard prop = (AbstractCard) properties.get(i);
            data[i] = new String[]{String.valueOf(counter++), prop.getName()};
        }
        return data;
    }
}
