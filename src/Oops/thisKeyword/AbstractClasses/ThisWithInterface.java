package Oops.thisKeyword.AbstractClasses;

// Interface for registering
interface Registrable {
    void register(Registry r);
}

abstract class AbstractEntity implements Registrable {
    String id;

    AbstractEntity(String id) {
        this.id = id;
    }

    @Override
    public void register(Registry r) {
        r.add(this); // using 'this' for interface reference
    }

    abstract void display();
}

class Product extends AbstractEntity {
    String name;

    Product(String id, String name) {
        super(id);
        this.name = name;
    }

    @Override
    void display() {
        System.out.println("Product: " + id + " - " + name);
    }
}

class Registry {
    void add(AbstractEntity e) {
        System.out.println("Registered entity with id: " + e.id);
    }
}

public class ThisWithInterface {
    public static void main(String[] args) {
        Product p = new Product("P001", "Laptop");
        p.register(new Registry());
        p.display();
    }
}