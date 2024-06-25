package Lecture10_ExceptionHandling;

import java.util.Scanner;

public class ArrayReadingDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        int idx;
        Scanner sc = new Scanner(System.in);
        idx = sc.nextInt();

        System.out.println(arr[idx]);
    }
}
