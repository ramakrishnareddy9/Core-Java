package Oops.thisKeyword.AbstractClasses;

abstract class Shape {
    String color;

    Shape(String color) {
        this.color = color; // 'this' refers to child object being created
        System.out.println("Shape constructor: Color set to " + this.color);
    }
}

class Circle extends Shape {
    Circle(String color) {
        super(color);
    }
}

public class ThisInConstructor {
    public static void main(String[] args) {
        new Circle("Red"); // 'this' points to Circle object
    }
}