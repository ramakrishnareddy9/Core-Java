package Oops.Constructor;

class Animal {
    // Parent constructor 1
    Animal() {
        System.out.println("Animal: No-arg constructor");
    }

    // Parent constructor 2
    Animal(String type) {
        System.out.println("Animal: Parameterized constructor → " + type);
    }
}

class Dog extends Animal {
    // Child constructor 1
    Dog() {
        super();  // calls Animal()
        System.out.println("Dog: No-arg constructor");
    }

    // Child constructor 2
    Dog(String name) {
        super("Mammal");  // calls Animal(String)
        System.out.println("Dog: Parameterized constructor → " + name);
    }
}

public class ConstructorChainingUsingSuper {
    public static void main(String[] args) {
        System.out.println("Creating Dog with no args:");
        new Dog();

        System.out.println("\nCreating Dog with parameter:");
        new Dog("Tommy");
    }
}