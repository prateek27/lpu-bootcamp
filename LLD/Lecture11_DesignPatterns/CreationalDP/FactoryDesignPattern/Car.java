package Lecture11_DesignPatterns.CreationalDP.FactoryDesignPattern;

public class Car implements Toy{

    @Override
    public void play() {
        System.out.println("Playing with Car");
    }
}
