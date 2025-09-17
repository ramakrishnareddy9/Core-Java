package Oops.AbstractClasses;


abstract class Animal1 {
    Animal1() {
        System.out.println("Animal constructor");
    }

    abstract void sound();
}

class Dog extends Animal1 {
    Dog() {
        System.out.println("Dog constructor");
    }

    void sound() {
        System.out.println("Bark");
    }
}

public class Constructor {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.sound();
    }
}