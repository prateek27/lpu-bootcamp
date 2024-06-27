package Lecture11_DesignPatterns.CreationalDP.PrototypeDP;

public class Circle implements Shape {
    int radius;

    Circle(int radius){
        this.radius = radius;
    }

    int getRadius(){
        return radius;
    }
    void setRadius(int radius){
        this.radius = radius;
    }

    public double getArea(){
        return Math.PI*radius*radius;
    }
    public Shape clone(){
        return new Circle(radius);
    }
}
