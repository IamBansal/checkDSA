package java_lab_5th_sem.week3;

class Circle {
    private final double radius;
    private final String color;

    //For Program 3 - week 3
    public static int count;

    public Circle() {
        //For Program 2 - week 3
        this(1.0, "red");
    }

    //For Program 2 - week 3
    public Circle(double r, String color) {
        count++;
        radius = r;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }
}

public class Program8 {

    public static void main(String[] args) {

        Circle c1 = new Circle();

        System.out.println("\nThe circle has radius of " + c1.getRadius() + " and area of " + c1.getArea());

        Circle c2 = new Circle(2.0, "red");

        System.out.println("\nThe circle has radius of " + c2.getRadius() + " and area of " + c2.getArea() + " with color " + c2.getColor());

        System.out.println("Total number of instances called : " + Circle.count);

    }
}