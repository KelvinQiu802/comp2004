package model;

import java.util.ArrayList;
import java.util.List;

public class PropertyDeck {
    private List<PropertySet> propertySets;

    public PropertyDeck() {
        propertySets = new ArrayList<>();
    }

    public List<PropertySet> getPropertySets() {
        return propertySets;
    }

    public void insertIntoNewSet(IPropertyCard card) {
        PropertySet set = new PropertySet(card.getCurrentColor());
        set.add(card);
        propertySets.add(set);
    }
}
