package college_labs.java_lab_5th_sem.week4;

public class Program10 {

    //Method overloading
    static class Division {

        public int division(int a, int b) {
            return (a / b);
        }

        public int division(int a, int b, int c) {
            return ((a + b) / c);
        }
    }

    //Method overriding
    static class Parent {
        void view() {
            System.out.println("This is a parent class method");
        }
    }

    static class Child extends Parent {
        void view() {
            System.out.println("This is a child class method");
        }
    }

    public static void main(String[] args) {

        //Overloading
        Division ob = new Division();
        System.out.println(ob.division(10, 2));
        System.out.println(ob.division(10, 2, 3));

        //Overriding
        Parent ob2 = new Parent();
        ob2.view();
        Parent ob3 = new Child();
        ob3.view();
    }
}