package Lecture04_Threads;

import java.util.Arrays;

public class ArrayPainterTest {
    public static void main(String[] args) {
        int[][] img = new int[10][10];
        for(int i=0;i<img.length;i++){
            System.out.println(Arrays.toString(img[i]));
        }
    }
}
