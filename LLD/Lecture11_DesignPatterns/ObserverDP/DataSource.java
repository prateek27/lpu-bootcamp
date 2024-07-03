package Lecture11_DesignPatterns.ObserverDP;

public class DataSource extends Subject {
    private int value;
    //List of Observers (inheritance)

    DataSource(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
    public void setValue(int value){
        this.value = value;
        //notify the observers and call their update method
        notifyAllObservers();
    }

    @Override
    public String toString() {
        return "DataSource{" +
                "value=" + value +
                '}';
    }
}
