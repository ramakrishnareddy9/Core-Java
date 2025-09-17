package Lambda.ByUsingAbstractClasses;

import java.util.Arrays;
import java.util.List;

abstract class Processor {
    void processData() {
        List<String> data = Arrays.asList("apple", "banana", "cherry");

        // Lambda used inside an abstract class
        data.forEach(item -> System.out.println("Processing: " + item));
    }

    abstract void customProcess();
}

class MyProcessor extends Processor {
    @Override
    void customProcess() {
        System.out.println("Custom processing...");
    }
}

public class LambdaInAbstractClass {
    public static void main(String[] args) {
        Processor p = new MyProcessor();
        p.processData();
        p.customProcess();
    }
}
