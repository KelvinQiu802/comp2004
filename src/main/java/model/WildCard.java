package model;

public class WildCard extends PropertyCard{
    public WildCard(String name, int value, String description) {
        super(name, value, description, Colors.ANY);
    }
}
