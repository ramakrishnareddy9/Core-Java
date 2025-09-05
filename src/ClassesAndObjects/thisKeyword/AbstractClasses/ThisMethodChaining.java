package ClassesAndObjects.thisKeyword.AbstractClasses;

abstract class Shape {
    String color;

    Shape setColor(String color) {
        this.color = color;
        return this; // return current object
    }

    abstract Shape draw();
}

class Rectangle extends Shape {
    int length, width;

    // Override setColor to return Rectangle for chaining
    @Override
    Rectangle setColor(String color) {
        super.setColor(color);
        return this;
    }

    // Return type changed to Rectangle for chaining
    Rectangle setDimensions(int length, int width) {
        this.length = length;
        this.width = width;
        return this;
    }

    @Override
    Shape draw() {
        System.out.println("Drawing Rectangle with color " + this.color +
                ", length " + this.length +
                ", width " + this.width);
        return this;
    }
}

public class ThisMethodChaining {
    public static void main(String[] args) {
        new Rectangle()
                .setColor("Green") // from abstract class
                .setDimensions(10, 5) // from Rectangle
                .draw(); // from Rectangle
    }
}
