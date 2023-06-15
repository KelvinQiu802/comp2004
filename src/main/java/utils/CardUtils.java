package utils;

import model.Colors;
import model.IPropertyCard;
import model.PropertyDeck;
import model.PropertySet;

public class CardUtils {
    /***
     * Get property card by index
     * @param pd
     * @param target
     * @return card
     */
    public static IPropertyCard getPropertyCardByIndex(PropertyDeck pd, int target) {
        int count = 0;
        for (PropertySet ps : pd.getPropertySets()) {
            for (IPropertyCard card : ps.getProperties()) {
                if (count == target) {
                    return card;
                }
                count++;
            }
        }
        return null;
    }

    /***
     * Get property card by index in property set
     * @param ps
     * @param target
     * @return card
     */
    public static IPropertyCard getPropertyCardByIndexInPropertySet(PropertySet ps, int target) {
        int count = 0;
        for (IPropertyCard card : ps.getProperties()) {
            if (count == target) {
                return card;
            }
            count++;
        }
        return null;
    }

    /***
     * Check if it is same color unfilled set
     * @param pd
     * @param color
     * @return true or false
     */
    public static boolean IsSameColorUnfilledSet(PropertyDeck pd, Colors color) {
        for (PropertySet set : pd.getPropertySets()) {
            if (set.getColor() == color && !set.isFullSet())
                return true;
        }
        return false;
    }
}
