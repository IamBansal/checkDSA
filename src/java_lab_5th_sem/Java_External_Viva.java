package java_lab_5th_sem;

public class Java_External_Viva {

    interface Drawable {
        void draw();
    }

    static class Rectangle implements Drawable {
        public void draw() {
            System.out.println("Drawing rectangle");
        }
    }

    static class Circle implements Drawable {
        public void draw() {
            System.out.println("Drawing circle");
        }
    }

    public static void main(String[] args) {

        Drawable d = new Circle();
        d.draw();

        System.out.println();

        Drawable b = new Rectangle();
        b.draw();

    }


}
