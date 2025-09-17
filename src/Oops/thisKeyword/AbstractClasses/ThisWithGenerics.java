package Oops.thisKeyword.AbstractClasses;

// CRTP Pattern (Curiously Recurring Template Pattern)
abstract class FluentEntity<T extends FluentEntity<T>> {
    String name;

    @SuppressWarnings("unchecked")
    T setName(String name) {
        this.name = name;
        return (T) this; // returning 'this' with generics
    }

    abstract void print();
}

class User extends FluentEntity<User> {
    int age;

    User setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    void print() {
        System.out.println("User: " + name + ", Age: " + age);
    }
}

public class ThisWithGenerics {
    public static void main(String[] args) {
        new User()
            .setName("Alice")
            .setAge(25)
            .print();
    }
}