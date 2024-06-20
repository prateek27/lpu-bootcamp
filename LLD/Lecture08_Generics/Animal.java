package Lecture08_Generics;

abstract public class Animal {
    String name;
    Animal(String name){
        this.name = name;
    }
    abstract void makeSound();
}
