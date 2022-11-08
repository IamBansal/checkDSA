package java_lab_5th_sem.week6;

//Program 15 and 16 both
//User-defined custom exception
class MyException extends Exception {
    public MyException(String s) {
        super(s);
    }
}

public class Program15 {

    public static void main(String[] args) throws MyException{
        try {
            throw new MyException("Some exception is here.");
        } catch (MyException ex) {
            System.out.println("Caught");
            System.out.println(ex.getMessage());
        }
        finally {
            System.out.println("Came out of the exception.");
        }
    }
}
