package Oops.Constructor;

class Student {
    int id;
    String name;

    // No-arg constructor
    Student() {
        id = 0;
        name = "Unknown";
        System.out.println("No-arg constructor called");
    }

    // Parameterized constructor (1 parameter)
    Student(int id) {
        this.id = id;
        name = "Default";
        System.out.println("Constructor with 1 parameter called");
    }

    // Parameterized constructor (2 parameters)
    Student(int id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("Constructor with 2 parameters called");
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name);
    }
}

public class ConstructorOverloading {
    public static void main(String[] args) {
        Student s1 = new Student(); // calls no-arg
        Student s2 = new Student(101); // calls 1-arg
        Student s3 = new Student(102, "Rama"); // calls 2-arg

        s1.display();
        s2.display();
        s3.display();
    }
}