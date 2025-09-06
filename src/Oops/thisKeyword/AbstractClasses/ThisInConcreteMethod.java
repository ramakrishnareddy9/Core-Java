package Oops.thisKeyword.AbstractClasses;

abstract class Shape {
    String color;

    Shape(String color) {
        this.color = color;
    }

    void printColor() {
        System.out.println("Color is: " + this.getColor()); // 'this' calls abstract method
    }

    abstract String getColor();
}

class Rectangle extends Shape {
    Rectangle(String color) {
        super(color);
    }

    @Override
    String getColor() {
        return this.color;
    }
}

public class ThisInConcreteMethod {
    public static void main(String[] args) {
        Shape s = new Rectangle("Blue");
        s.printColor();
    }
}
