package model;

public class ActionCard extends AbstractCard{
    public ActionCard(String name, int value, String description) {
        super(name, CardTypes.ACTION, value, description);
    }

    @Override
    public void play() {

    }

    /***
     * Drop the card to the center.
     */
    private void dropToCenter(){
        
    }
}
