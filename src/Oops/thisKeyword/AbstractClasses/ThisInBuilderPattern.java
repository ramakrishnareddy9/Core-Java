package Oops.thisKeyword.AbstractClasses;

// Abstract Builder with method chaining using 'this'
abstract class VehicleBuilder<T extends VehicleBuilder<T>> {
    String brand;

    T setBrand(String brand) {
        this.brand = brand;
        return self();
    }

    abstract T self();
    abstract Vehicle build();
}

class CarBuilder extends VehicleBuilder<CarBuilder> {
    String model;

    CarBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    @Override
    CarBuilder self() {
        return this;
    }

    @Override
    Vehicle build() {
        return new Vehicle(brand, model);
    }
}

class Vehicle {
    String brand, model;

    Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    void display() {
        System.out.println("Vehicle: " + brand + " " + model);
    }
}

public class ThisInBuilderPattern {
    public static void main(String[] args) {
        Vehicle car = new CarBuilder()
            .setBrand("Tesla")
            .setModel("Model Y")
            .build();

        car.display();
    }
}