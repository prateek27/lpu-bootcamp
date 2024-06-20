package Lecture08_Generics;

public class AnimalDemo {
    public static void main(String[] args) {
        Dog d = new Dog("Tommy");
        Cat c = new Cat("Catty");

        AnimalBox<Animal> box = new AnimalBox<>();
        box.push(d);
        box.push(c);

        System.out.println(box);

        for(Object a:box){
            System.out.println(a);
        }
    }
}
