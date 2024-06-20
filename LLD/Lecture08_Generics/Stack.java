package Lecture08_Generics;

import java.util.ArrayList;

public class Stack<T> {

    ArrayList<T> arr;

    public Stack(){
        arr = new ArrayList<>();
    }

    void push(T data){
        arr.add(data);
    }
    void pop(){
        int idx = arr.size() - 1;
        arr.remove(idx);
    }

    T top(){
        int idx = arr.size() - 1;
        return arr.get(idx);
    }

    @Override
    public String toString() {
        return "Stack{" +
                "arr=" + arr +
                '}';
    }
}
