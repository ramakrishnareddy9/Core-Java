package Lambda.ByUsingAbstractClasses;

@FunctionalInterface
interface Rule {
    boolean check(String input);
}

abstract class Validator {
    private Rule rule; // Functional interface field

    Validator(Rule rule) {
        this.rule = rule;  // Inject lambda here
    }

    void validate(String input) {
        System.out.println("Validating: " + input);
        if (rule.check(input)) {
            onSuccess(input);
        } else {
            onFailure(input);
        }
    }

    // Abstract methods - subclasses define behavior for success/failure
    abstract void onSuccess(String input);
    abstract void onFailure(String input);
}

// Concrete class decides what to do on success/failure
class LoginValidator extends Validator {
    LoginValidator(Rule rule) {
        super(rule);
    }

    @Override
    void onSuccess(String input) {
        System.out.println("Login successful for user: " + input);
    }

    @Override
    void onFailure(String input) {
        System.out.println("Login failed for user: " + input);
    }
}

public class LambdaInAbstractValidator {
    public static void main(String[] args) {
        // Pass lambda for the validation rule
        Validator validator = new LoginValidator(username -> username.equals("admin"));

        validator.validate("guest");
        validator.validate("admin");
    }
}