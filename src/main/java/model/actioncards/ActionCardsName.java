package model.actioncards;

public enum ActionCardsName {
    DEAL_BREAKER("DEAL BREAKER"),
    DEBT_COLLECTOR("DEBT COLLECTOR"),
    DOUBLE_THE_RENT("DOUBLE THE RENT"),
    FORCED_DEAL("FORCED DEAL"),
    HOTEL("HOTEL"),
    HOUSE("HOUSE"),
    ITS_MY_BIRTHDAY("IT'S MY BIRTHDAY"),
    JUST_SAY_NO("JUST SAY NO"),
    PASS_GO("PASS GO"),
    SLY_DEAL("SLY DEAL"),
    RENT("RENT"),
    WILD_RENT("WILD RENT");

    private String cardName;

    private ActionCardsName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardName() {
        return cardName;
    }

    @Override
    public String toString() {
        return cardName;
    }
}
