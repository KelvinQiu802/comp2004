package model;

public abstract class AbstractCard {
    private String name;
    private CardTypes type;
    private int value;
    private String description;

    public AbstractCard(String name, CardTypes type, int value, String description) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.description = description;
    }

    /***
     * An abstract method called when this card is played.
     */
    abstract public void play(Player currentPlayer);

    public String getName() {
        return name;
    }

    public CardTypes getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
