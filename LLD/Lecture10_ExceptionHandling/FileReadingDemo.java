package Lecture10_ExceptionHandling;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileReadingDemo {

    static void readFile(String fileName) throws FileNotFoundException {
        //Checked
        FileReader fileReader = new FileReader(fileName);
        //business logic can go here

    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile("ab.txt");
        System.out.println("Main is still running!");
    }
}
