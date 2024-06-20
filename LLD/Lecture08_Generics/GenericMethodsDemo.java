package Lecture08_Generics;

public class GenericMethodsDemo {
    static <T> void printItems(T[] items){
        for(T item:items){
            System.out.println(item);
        }
    }

    static <T extends Number> T increment(T first){
        return first;
    }

    public static void main(String[] args) {
        Integer[] a = {1,2,3};
        String[] b = {"hi","bye"};

        printItems(a);
        printItems(b);
    }
}
