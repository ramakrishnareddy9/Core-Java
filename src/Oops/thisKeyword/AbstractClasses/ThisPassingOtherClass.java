package Oops.thisKeyword.AbstractClasses;

import java.util.ArrayList;
import java.util.List;

abstract class Shape1 {
    String name;

    Shape1(String name) {
        this.name = name;
    }

    void register(ShapeRegistry registry) {
        registry.add(this); // passing current object
    }

    abstract void draw();
}

class Circle1 extends Shape1 {
    Circle1(String name) {
        super(name);
    }

    @Override
    void draw() {
        System.out.println("Drawing Circle: " + this.name);
    }
}

class ShapeRegistry {
    List<Shape1> shapes = new ArrayList<>(); // FIX: use Shape1 not Shape

    void add(Shape1 shape) { // FIX: accept Shape1 instead of Shape
        shapes.add(shape);
        System.out.println("Registered: " + shape.name);
    }

    void displayAll() {
        for (Shape1 s : shapes) { // FIX: iterate over Shape1 objects
            s.draw();
        }
    }
}

public class ThisPassingOtherClass {
    public static void main(String[] args) {
        ShapeRegistry registry = new ShapeRegistry();

        Shape1 c1 = new Circle1("CircleOne");
        Shape1 c2 = new Circle1("CircleTwo");

        c1.register(registry);
        c2.register(registry);

        registry.displayAll();
    }
}
