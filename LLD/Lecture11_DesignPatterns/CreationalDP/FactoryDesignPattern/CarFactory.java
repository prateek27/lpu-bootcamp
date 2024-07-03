package Lecture11_DesignPatterns.CreationalDP.FactoryDesignPattern;

public class CarFactory extends ToyFactory {
    @Override
    public Toy createToy() {
        return new Car();
    }
}
