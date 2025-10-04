package Oops.Constructor;

class Student {
    String name;
    int age;

    // Constructor 1
    Student() {
        this("Unknown"); // calls Constructor 2
        System.out.println("Default constructor called");
    }

    // Constructor 2
    Student(String name) {
        this(name, 18); // calls Constructor 3
        System.out.println("Name constructor called");
    }

    // Constructor 3
    Student(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Full constructor called");
    }
}

public class ConstructorChainingUsingThis {
    public static void main(String[] args) {
        new Student(); 
    }
}