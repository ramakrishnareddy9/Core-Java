package Oops.Constructor;

class DemoDefault {
    int id;
    String name;

    // Default constructor (no arguments)
    DemoDefault() {
        id = 0;
        name = "Unknown";
        System.out.println("Default Constructor called");
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name);
    }
}

public class DefaultConstructor {
    public static void main(String[] args) {
        DemoDefault d1 = new DemoDefault(); // Calls default constructor
        d1.display();
    }
}
