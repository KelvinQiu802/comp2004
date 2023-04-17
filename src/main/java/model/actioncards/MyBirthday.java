package model.actioncards;

import model.ActionCard;

public class MyBirthday extends ActionCard {
    public MyBirthday() {
        super(ActionCardsName.ITS_MY_BIRTHDAY, 2, "All players give you 2M as a gift.");
    }

    @Override
    public void play() {

    }
}
