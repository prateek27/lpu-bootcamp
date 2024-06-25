package Lecture10_ExceptionHandling;

public class BookDemo {
    static void validate(String bookname) throws InvalidBookNameException{
        if(!bookname.startsWith("LPU")){
            throw new InvalidBookNameException(bookname + "doesn't start with LPU");
        }
        System.out.println("Book name is validated");
    }

    public static void main(String[] args) {
        try {
            validate("LPU Python DSA ");
        } catch (InvalidBookNameException e) {
            System.out.println(e.getMessage());
        }
    }
}
