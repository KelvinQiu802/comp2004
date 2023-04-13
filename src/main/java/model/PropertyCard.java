package model;

public class PropertyCard extends AbstractCard{
    private Colors currentColor;
    public PropertyCard(String name, int value, String description,Colors currentColor) {
        super(name, CardTypes.PROPERTY, value, description);
        this.currentColor=currentColor;
    }

    @Override
    public void play() {

    }
}
