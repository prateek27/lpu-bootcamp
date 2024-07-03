package Lecture11_DesignPatterns.CreationalDP.PrototypeDP;

public class Main {
    //Problem

    /*static Shape  duplicate(Shape shape){
        if(shape instanceof Circle){
            Circle c = new Circle(((Circle) shape).getRadius());
            return c;
        }
        else if(shape instanceof Square){
            Square s = new Square(((Square) shape).getLen());
            return s;
        }
        return shape;
    }*/

    static Shape duplicate(Shape shape){
        return shape.clone();
    }
    //Open Close Principle is satisfied!

    public static void main(String[] args) {
        Circle c1 = new Circle(5);
        Shape c2 = duplicate(c1);

        Square s1 = new Square(5);
        Shape s2 = duplicate(s1);

        System.out.println(c1.getArea());
        System.out.println(c2.getArea());
        System.out.println(s1.getArea());
        System.out.println(s2.getArea());




    }
}
