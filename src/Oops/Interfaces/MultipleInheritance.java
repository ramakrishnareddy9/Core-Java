package Oops.Interfaces;

interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Duck implements Flyable, Swimmable {
    @Override
    public void fly() {
        System.out.println("Duck can fly (but not very high!)");
    }

    @Override
    public void swim() {
        System.out.println("Duck swims in the pond");
    }
}

public class MultipleInheritance {
    public static void main(String[] args) {
        Duck d = new Duck();
        d.fly();
        d.swim();
        Flyable f = d;
        f.fly();
        Swimmable s = d;
        s.swim();
    }
}

