package Oops.AbstractClasses;

abstract class Animal {
    abstract void sound(); // abstract method (must be implemented by child)

    void sleep() { // concrete method
        System.out.println("Sleeping...");
    }
}

public class BasicAbstractClasses extends Animal{
    public static void main(String[] args) {
        BasicAbstractClasses obj = new BasicAbstractClasses();
        obj.sleep();
        obj.sound();
    }

    @Override
    void sound() {
        System.out.println("Animal is making Sounds");
    }
}
