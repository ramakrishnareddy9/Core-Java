package ClassesAndObjects.thisKeyword;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id; // this.id = instance variable
        this.name = name; // name = constructor parameter
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name);
    }
}

public class DifferenceBetweenInstanceParameters {
    public static void main(String[] args) {
        Student s1 = new Student(101, "Rama");
        s1.display();
    }
}
