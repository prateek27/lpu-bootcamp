package Lecture11_DesignPatterns.ObserverDP;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observerList;
    Subject(){
        this.observerList = new ArrayList<>();
    }
    public void addObserver(Observer observer){
        observerList.add(observer);
    }
    public void removeObserver(Observer observer){
        observerList.remove(observer);
    }
    //notifies all the observer
    public void notifyAllObservers(){
        for(Observer observer:observerList){
            observer.update();
        }
    }

    @Override
    public String toString() {
        return "Subscribers{" +
                "observerList=" + observerList +
                '}';
    }
}
