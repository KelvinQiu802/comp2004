package model;

public class PropertyCard extends AbstractCard{
    public PropertyCard(String name, int value, String description) {
        super(name, CardTypes.PROPERTY, value, description);
    }

    @Override
    public void play() {

    }
}
