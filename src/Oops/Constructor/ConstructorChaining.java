package Oops.Constructor;

class Animal {
    Animal() {
        System.out.println("Animal Constructor");
    }
}

class Dog extends Animal {
    Dog() {
        super(); // calls parent constructor first
        System.out.println("Dog Constructor");
    }
}

public class ConstructorChaining {
    public static void main(String[] args) {
        new Dog();
    }
}