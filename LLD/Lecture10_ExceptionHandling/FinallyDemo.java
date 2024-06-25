package Lecture10_ExceptionHandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FinallyDemo {
    public static void main(String[] args) {
        BufferedReader reader = null;
        //Try to open a new file
        try{
            reader = new BufferedReader(new FileReader("sampleText.txt"));
            String line;
            while((line = reader.readLine())!=null){
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if(reader!=null){
                try {
                    //always close the reader irrespective file is read or not
                    reader.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());;
                }
            }
        }
    }
}
