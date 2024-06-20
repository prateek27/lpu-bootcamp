package Lecture08_Generics;

import java.util.ArrayList;
import java.util.Iterator;

public class AnimalBox<T extends Animal> implements Iterable {
    ArrayList<T> animals;

    AnimalBox(){
        animals = new ArrayList<>();
    }

    void push(T animal){
        animals.add(animal);
    }

    @Override
    public String toString() {
        return "AnimalBox{" +
                "animals=" + animals +
                '}';
    }

    @Override
    public Iterator iterator() {
        return animals.iterator();
    }
}
