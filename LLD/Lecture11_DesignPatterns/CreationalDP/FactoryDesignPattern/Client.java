package Lecture11_DesignPatterns.CreationalDP.FactoryDesignPattern;

public class Client {
    public static void main(String[] args) {
        //createFactory
        ToyFactory f1 = new CarFactory();
        ToyFactory f2 = new DollFactory();

        Toy t1 = f1.createToy();
        Toy t2 = f1.createToy();
        Toy t3 = f2.createToy();

        t1.play();
        t2.play();
        t3.play();
    }
}
