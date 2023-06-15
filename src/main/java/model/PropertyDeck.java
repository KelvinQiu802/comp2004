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

    /**
     * Remove a property card in the deck
     * @param card card
     */
    public void removeCard(IPropertyCard card) {
        for (PropertySet ps : propertySets) {
            for (IPropertyCard property : ps.getProperties()) {
                if (property == card) {
                    ps.getProperties().remove(property);
                    // If empty -> remove
                    if (ps.getProperties().size() == 0) {
                        propertySets.remove(ps);
                    }
                    return;
                }
            }
        }
    }

    /**
     * InsertSet a property set in the deck
     * @param set PropertySet
     */
    public void insertSet(PropertySet set) {
        propertySets.add(set);
    }

    /**
     * Remove a property set in the deck
     * @param set PropertySet
     */
    public void removeSet(PropertySet set) {
        propertySets.remove(set);
    }
}
