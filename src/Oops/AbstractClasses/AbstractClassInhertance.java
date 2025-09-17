package Oops.AbstractClasses;

abstract class Animal {
    abstract void sound();
    abstract void eat();
}

// Dog is abstract → not forced to implement all methods yet
abstract class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
    // eat() not implemented → Dog remains abstract
}

// Final child must implement the remaining methods
class Puppy extends Dog {
    @Override
    void eat() {
        System.out.println("Puppy drinks milk");
    }
}

public class AbstractClassInhertance {
    public static void main(String[] args) {
        Animal a = new Puppy();
        a.sound();
        a.eat();
    }
}
