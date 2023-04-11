package model;

import java.util.ArrayList;
import java.util.List;

public class PropertySet {
    private List<PropertyCard> properties;
    private Colors color;

    public PropertySet(Colors color) {
        properties = new ArrayList<>();
        this.color = color;
    }

    /***
     * Add property to set.
     * @param card card will be added
     */
    public void add(PropertyCard card) {
        properties.add(card);
    }

    /***
     * Remove property from set.
     * @param index The index want to remove.
     * @return Removed property.
     */
    public PropertyCard remove(int index) {
        return properties.remove(index);
    }

    /***
     * Check weather this set is a full set.
     * @return true if is full set, rather false.
     */
    public boolean isFullSet() {
        return false;
    }
}
