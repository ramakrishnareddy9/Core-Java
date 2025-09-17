package Lambda.ByUsingAbstractClasses;

// Abstract Class + Functional Interface + Lambda Injection

@FunctionalInterface
interface Operation {
    void execute(String input);
}

abstract class Task {
    Operation operation;

    Task(Operation operation) {
        this.operation = operation;
    }

    void runTask(String input) {
        System.out.println("Running task...");
        operation.execute(input); // calls lambda
    }

    abstract void finish();
}

class PrintTask extends Task {
    PrintTask(Operation op) {
        super(op);
    }

    @Override
    void finish() {
        System.out.println("Task finished.");
    }
}

public class LambdaInAbstractClass2 {
    public static void main(String[] args) {
        Task task = new PrintTask(input -> System.out.println("Lambda executed with: " + input));

        task.runTask("Hello Lambda + Abstract Class");
        task.finish();
    }
}