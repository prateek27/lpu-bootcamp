package Lecture08_Generics;

public class NumberBox<T extends Number> {
    T number;

    NumberBox(T num){
        number = num;
    }

    T getNumber(){
        return number;
    }
    void setNumber(T num){
        number = num;
    }

}
