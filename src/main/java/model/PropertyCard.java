package model;

import java.util.List;

public class PropertyCard extends AbstractCard implements IPropertyCard {
    private Colors currentColor;

    public PropertyCard(String name, int value, String description, Colors currentColor) {
        super(name, CardTypes.PROPERTY, value, description);
        this.currentColor = currentColor;
    }

    @Override
    public void play(Player currentPlayer, List<Player> players, DrawPile pile) {

    }

    /***
     * Setter of currentColor
     * @param color the color want to set as currentColor
     */
    public void setCurrentColor(Colors color) {
        this.currentColor = color;
    }

    /***
     * Getter of currentColor
     * @return current color
     */
    public Colors getCurrentColor() {
        return currentColor;
    }
}
