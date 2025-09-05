package ClassesAndObjects.Constructor;

class DemoParameterized {
    int id;
    String name;

    // Parameterized constructor
    DemoParameterized(int id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("Parameterized Constructor called");
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name);
    }
}

public class ParameterizedConstructor {
    public static void main(String[] args) {
        DemoParameterized d1 = new DemoParameterized(101, "Rama");
        d1.display();

        DemoParameterized d2 = new DemoParameterized(102, "Krishna");
        d2.display();
    }
}
