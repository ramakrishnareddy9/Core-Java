package Oops.Constructor;

// Base class
class Person {
    String name;
    int age;

    // No-arg constructor
    Person() {
        this("Unknown", 0); // calls parameterized constructor
        System.out.println("Person(): No-arg constructor");
    }

    // Parameterized constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Person(String, int): Parameterized constructor");
    }
}

// Derived class
class Employee extends Person {
    int empId;
    String department;

    // No-arg constructor
    Employee() {
        this(0, "General"); // calls parameterized constructor of same class
        System.out.println("Employee(): No-arg constructor");
    }

    // Parameterized constructor (1)
    Employee(int empId, String department) {
        super("Default Employee", 25); // calls parent constructor
        this.empId = empId;
        this.department = department;
        System.out.println("Employee(int, String): Parameterized constructor");
    }

    // Parameterized constructor (2)
    Employee(String name, int age, int empId, String department) {
        super(name, age); // calls parent constructor
        this.empId = empId;
        this.department = department;
        System.out.println("Employee(String, int, int, String): Full constructor");
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age +
                ", EmpId: " + empId + ", Department: " + department);
    }
}

public class ConstructorChainingExample {
    public static void main(String[] args) {
        System.out.println("=== Creating Employee e1 ===");
        Employee e1 = new Employee(); // calls no-arg constructor
        e1.display();

        System.out.println("\n=== Creating Employee e2 ===");
        Employee e2 = new Employee(101, "IT"); // calls Employee(int, String)
        e2.display();

        System.out.println("\n=== Creating Employee e3 ===");
        Employee e3 = new Employee("Rama", 21, 102, "HR"); // calls full constructor
        e3.display();
    }
}