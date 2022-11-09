package java_lab_5th_sem.week5;

abstract class Animal {
    String color = "White";
    abstract void legs();
}

class Dog extends Animal {
    String color = "Black";

    void legs() {
        System.out.println("Dog has 4 legs.");
    }

    //Use of super keyword
    void printColor() {
        System.out.println("Dog's color : " + color);           //prints color of Dog class
        System.out.println("Animal's color : " + super.color);  //prints color of Animal class
    }
}

class Cat extends Animal {

    //abstract
    void legs() {
        System.out.println("Cat has 4 legs.");
    }
}

public class Program12 {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.printColor();
        d.legs();

        Animal c = new Cat();
        c.legs();

    }
}
