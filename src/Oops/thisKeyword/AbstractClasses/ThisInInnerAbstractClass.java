package Oops.thisKeyword.AbstractClasses;

// Abstract Outer class
abstract class Outer {
    String name;

    Outer(String name) {
        this.name = name;
    }
    // Abstract method
    abstract void display();
    // Inner abstract class
    abstract class Inner {
        void showOuter() {
            // Using Outer.this to access outer object
            System.out.println("Outer name: " + Outer.this.name);
            Outer.this.display();
        }
    }
}

class ConcreteOuter extends Outer {
    ConcreteOuter(String name) {
        super(name);
    }

    @Override
    void display() {
        System.out.println("Display from ConcreteOuter: " + this.name);
    }

    class ConcreteInner extends Inner {
        void doWork() {
            showOuter(); // Calls parent inner method
        }
    }
}

public class ThisInInnerAbstractClass {
    public static void main(String[] args) {
        ConcreteOuter outer = new ConcreteOuter("OuterClass");
        ConcreteOuter.ConcreteInner inner = outer.new ConcreteInner();
        inner.doWork();
    }
}