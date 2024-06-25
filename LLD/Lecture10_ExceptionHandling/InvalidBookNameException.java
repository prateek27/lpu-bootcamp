package Lecture10_ExceptionHandling;

public class InvalidBookNameException extends Exception{
    public InvalidBookNameException(String message){
        super(message);
    }
}
