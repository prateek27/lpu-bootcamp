package Lecture10_ExceptionHandling;

public class AirthmeticException {

    static void divide(int a,int b){
            System.out.println("Division result is " + a/b);
    }

    public static void main(String[] args)  {
        divide(5,0);
        System.out.println("main is running...");

    }


}
