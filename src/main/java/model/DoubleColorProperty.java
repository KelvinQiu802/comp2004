package model;

public class DoubleColorProperty extends PropertyCard{
    private Colors first;
    private Colors second;
    private Colors currentColor;
    public DoubleColorProperty(String name, int value, String description, Colors first, Colors second) {
        super(name, value, description, first);
        this.currentColor=first;
    }

    public Colors switchColor(){
        if(currentColor==first){
            currentColor=second;
        }else {
            currentColor=first;
        }
        return currentColor;
    }
}
