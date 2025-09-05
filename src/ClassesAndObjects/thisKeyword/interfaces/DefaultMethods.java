package ClassesAndObjects.thisKeyword.interfaces;

interface Car {
    default void print() {
        System.out.println("This car is of brand : " + this.getClass().getName());
    }

    void model();
}

class Jaguar implements Car{

    @Override
    public void model() {
        System.out.println("the jaguar model is mx-9");
    }
}

public class DefaultMethods {
    public static void main(String[] args) {
        Jaguar j = new Jaguar();
        j.print();
        j.model();
    }
}