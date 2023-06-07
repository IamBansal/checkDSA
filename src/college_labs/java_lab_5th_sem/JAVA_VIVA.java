package college_labs.java_lab_5th_sem;

interface Drawable {
    void draw();
}

class Rectangle implements Drawable {
    public void draw() {
        System.out.println("Drawing rectangle");
    }
}

class Circle implements Drawable {
    public void draw() {
        System.out.println("Drawing circle");
    }
}

public class JAVA_VIVA {

    public static void main(String[] args) {
        Drawable d = new Circle();
        d.draw();

        Drawable d2 = new Rectangle();
        d2.draw();

    }
}

