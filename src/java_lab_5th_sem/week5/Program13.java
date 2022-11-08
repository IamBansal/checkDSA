package java_lab_5th_sem.week5;


//Week 6 - Program 14 here
//Interface
interface Drawable{
    void draw();
}

class Rectangle implements Drawable{
    public void draw(){System.out.println("Drawing rectangle");}
}

class Circle implements Drawable{
    public void draw(){System.out.println("Drawing circle");}
}

public class Program13 {

    public static void main(String[] args) {
        Drawable d = new Circle();
        d.draw();
    }
}
