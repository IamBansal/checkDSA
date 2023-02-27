package java_lab_5th_sem;

class Circles {
    private final double radius;
    private final String color;

    public Circles() {
        this(1.0, "Black");
    }

    public Circles(double r, String color) {
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

public class viva {

    public static void main(String[] args) {

        Circles c1 = new Circles();
        Circles c2 = new Circles(2.0, "Red");

        System.out.println("The circle has radius of " + c1.getRadius() + " units and\narea of " + c1.getArea() + " sq. units\nwith color " + c1.getColor());
        System.out.println("\nThe circle has radius of " + c2.getRadius() + " units and\narea of " + c2.getArea() + " sq. units\nwith color " + c2.getColor());
    }
}