package Oops.Constructor;

class DemoCopy {
    int id;
    String name;

    // Parameterized constructor
    DemoCopy(int id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("Parameterized Constructor called");
    }

    // Copy constructor
    DemoCopy(DemoCopy other) {
        this.id = other.id;
        this.name = other.name;
        System.out.println(" Copy Constructor called");
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name);
    }
}

public class CopyConstructor {
    public static void main(String[] args) {
        DemoCopy d1 = new DemoCopy(201, "Rama"); // parameterized
        d1.display();

        DemoCopy d2 = new DemoCopy(d1); // copy constructor
        d2.display();
    }
}
