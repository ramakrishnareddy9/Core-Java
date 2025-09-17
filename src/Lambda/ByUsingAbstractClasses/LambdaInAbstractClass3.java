package Lambda.ByUsingAbstractClasses;

// Abstract Class Defining "Template" and Using Lambda for Hooks

@FunctionalInterface
interface Hook {
    void apply();
}

abstract class Workflow {
    Hook before;
    Hook after;

    Workflow(Hook before, Hook after) {
        this.before = before;
        this.after = after;
    }

    final void execute() {
        if (before != null) before.apply();
        task();
        if (after != null) after.apply();
    }

    abstract void task();
}

class FileUploadWorkflow extends Workflow {
    FileUploadWorkflow(Hook before, Hook after) {
        super(before, after);
    }

    @Override
    void task() {
        System.out.println("Uploading file...");
    }
}

public class LambdaInAbstractClass3 {
    public static void main(String[] args) {
        Workflow upload = new FileUploadWorkflow(
            () -> System.out.println("Before Upload: Checking storage"),
            () -> System.out.println("After Upload: Sending notification")
        );

        upload.execute();
    }
}