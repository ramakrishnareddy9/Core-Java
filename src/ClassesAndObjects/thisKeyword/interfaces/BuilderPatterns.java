package ClassesAndObjects.thisKeyword.interfaces;

interface Builder<T> {
    default T setName(String name) {
        System.out.println("Setting name: " + name);
        return (T) this; // return implementing class object
    }
}

class User implements Builder<User> {
}

public class BuilderPatterns {
    public static void main(String[] args) {
        new User()
                .setName("Rama"); // method chaining via this
    }
}