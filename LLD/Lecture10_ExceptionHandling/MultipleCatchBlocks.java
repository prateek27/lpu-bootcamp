package Lecture10_ExceptionHandling;

public class MultipleCatchBlocks {
    public static void main(String[] args) {
        try{
            String s = null;
            System.out.println(s.length());
        }
        catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }
        catch (NullPointerException e){
            System.out.println("Null ptr exception" + e.getMessage());
            throw new RuntimeException();
        }
        catch (Exception e){
            System.out.println("Any generic exception " + e.getMessage());
        }
        finally {
            //this pc of code always runs irrespective of exception of throw or not
            System.out.println("This code always run!");
            //free up system resouces before this function terminates
            // unlock any objects before you terminate

        }
        System.out.println("Main is running");
    }
}
