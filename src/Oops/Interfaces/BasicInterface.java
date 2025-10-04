package Oops.Interfaces;

interface Animal {
    void sound();
    void eat();
}

class Dog implements Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }

    @Override
    public void eat() {
        System.out.println("Dog eats bones");
    }
}


public class BasicInterface {
    public static void main(String[] args) {
        Animal a = new Dog(); 
        a.sound();
        a.eat();
    }
}
