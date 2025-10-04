package Oops.Interfaces;

interface Config {
    // By default: public static final
    int MAX_USERS = 100;  
    String APP_NAME = "MyApplication";
}

class UserService {
    void printConfig() {
        // Accessing constants directly
        System.out.println("Max users allowed: " + Config.MAX_USERS);
        System.out.println("Application Name: " + Config.APP_NAME);
    }
}

public class FieldModifiers {
    public static void main(String[] args) {
        UserService service = new UserService();
        service.printConfig();

        // Direct access without object
        System.out.println("Direct access: " + Config.MAX_USERS);
        
        // ERROR: Cannot change final variable
        // Config.MAX_USERS = 200;
    }
}
