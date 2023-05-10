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
            outerHeader[i] = sets.get(i).getColor().toString();
        }
        String[] innerHeader = {"Index", "Name"};
        int counter = 0;
        for (int i = 0; i < sets.size(); i++) {
            String[][] innerData = new String[sets.size()][2];
            PropertySet ps = sets.get(i);
            List<IPropertyCard> properties = ps.getProperties();
            for (int j = 0; j < properties.size(); j++) {
                AbstractCard prop = (AbstractCard) properties.get(i);
                innerData[i] = new String[]{String.valueOf(counter++), prop.getName()};
            }
            String inner = FlipTable.of(innerHeader, innerData);
            outerData[1][i] = inner;
        }
        System.out.println(FlipTable.of(outerHeader, outerData));
    }

    public static void printPropertySet(PropertySet ps) {
        List<IPropertyCard> properties = ps.getProperties();
        String[] header = {"Index", "Name"};
        String[][] data = new String[properties.size()][2];
        for (int i = 0; i < properties.size(); i++) {
            AbstractCard prop = (AbstractCard) properties.get(i);
            data[i] = new String[]{String.valueOf(i), prop.getName()};
        }
        System.out.printf("###%s###\n", ps.getColor());
        System.out.println(FlipTable.of(header, data));
        Printer.printDashLine();
    }
}
