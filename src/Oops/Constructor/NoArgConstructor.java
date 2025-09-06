package Oops.Constructor;

class DemoNoArg {
    int id;
    String name;

    // No-argument constructor (custom)
    DemoNoArg() {
        id = 1;
        name = "Rama";
        System.out.println("No-arg Constructor called");
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name);
    }
}

public class NoArgConstructor {
    public static void main(String[] args) {
        DemoNoArg d1 = new DemoNoArg(); // Calls custom no-arg constructor
        d1.display();
    }
}
