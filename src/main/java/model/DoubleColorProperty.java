package model;

public class DoubleColorProperty extends PropertyCard {
    private Colors first;
    private Colors second;

    public DoubleColorProperty(String name, int value, Colors first, Colors second) {
        super(name, value, "Property Card", first);  // current color is the first color by default
        this.first = first;
        this.second = second;
    }

    /***
     * Switch the Double Color Property Card's color.
     * @return The current color after the switch.
     */
    public Colors switchColor() {
        Colors currentColor = getCurrentColor();
        if (currentColor.equals(first)) {
            setCurrentColor(second);
        } else {
            setCurrentColor(first);
        }
        return currentColor;
    }

    public Colors getFirstColor() {
        return first;
    }

    public Colors getSecondColor() {
        return second;
    }
}
