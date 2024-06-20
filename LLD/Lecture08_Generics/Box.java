package Lecture08_Generics;

public class Box<T,U> {
    private T x;
    private U y;

    T getX(){
        return x;
    }
    U getY(){
        return y;
    }

    Box(T x,U y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Box{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
