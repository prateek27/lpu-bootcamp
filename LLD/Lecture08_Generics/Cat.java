package Lecture08_Generics;

public class Cat extends Animal{

    Cat(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println("Mewoow!");
    }

    @Override
    public String toString() {
        return "Cat" + name;
    }
}
