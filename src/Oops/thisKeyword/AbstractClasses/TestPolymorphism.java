package Oops.thisKeyword.AbstractClasses;

abstract class Shape {
    Shape() {
        System.out.println("Shape constructor called");
        this.draw(); // will call child's draw() implementation
    }

    abstract void draw();
}

class Circle extends Shape {
    int radius = 10;

    Circle() {
        System.out.println("Circle constructor called");
    }

    @Override
    void draw() {
        System.out.println("Drawing Circle of radius " + radius);
    }
}

public class TestPolymorphism {
    public static void main(String[] args) {
        Shape s = new Circle(); // Upcasting
    }
}
