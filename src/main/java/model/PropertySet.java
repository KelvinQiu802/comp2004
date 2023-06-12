package model;

import model.actioncards.ActionCardsName;
import model.actioncards.Hotel;
import model.actioncards.House;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PropertySet {
    private List<IPropertyCard> properties;
    private Colors color;

    public PropertySet(Colors color) {
        properties = new ArrayList<>();
        this.color = color;
    }

    /***
     * Add property to set.
     * @param card card will be added
     */
    public void add(IPropertyCard card) {
        if (color == Colors.ANY && card.getCurrentColor() != Colors.ANY) {
            color = card.getCurrentColor();
        }
        properties.add(card);
    }

    /***
     * Remove property from set.
     * @param index The index want to remove.
     * @return Removed property.
     */
    public IPropertyCard remove(int index) {
        return properties.remove(index);
    }

    /***
     * Check weather this set is a full set.
     * @return true if is full set, rather false.
     */
    public boolean isFullSet() {
        if (color == Colors.ANY) {
            return false;
        }
        Map<Integer, Integer> info = PropertyInfo.getByColor(color);
        return properties.size() >= info.size();
    }

    public List<IPropertyCard> getProperties() {
        return properties;
    }

    public Colors getColor() {
        return color;
    }

    /***
     * Calculate the rent of a property set
     * @return price
     */
    public int getRent() {
        Map<Integer, Integer> info = PropertyInfo.getByColor(color);
        // has a house
        if (((AbstractCard) properties.get(properties.size() - 1)).getName().equals(ActionCardsName.HOUSE.toString())) {
            return info.get(properties.size() - 1) + new House().getValue();
        } else if (((AbstractCard) properties.get(properties.size() - 1)).getName().equals(ActionCardsName.HOTEL.toString())) {
            return info.get(properties.size() - 2) + new House().getValue() + new Hotel().getValue();
        } else {
            return info.get(properties.size());
        }
    }
}