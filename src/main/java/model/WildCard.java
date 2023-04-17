package model;

public class WildCard extends PropertyCard {
    public WildCard(String name) {
        // 0 means no monetary value
        super(name, 0, "This card can be used as part of any property set. This " +
                "card has no monetary value.", Colors.ANY);
    }
}
