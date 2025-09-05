package ClassesAndObjects.thisKeyword.interfaces;

interface Logger {
    private void log(String msg) {
        System.out.println("Log: " + msg + " from " + this.getClass().getSimpleName());
    }

    default void info(String msg) {
        log(msg); // calls private method with this
    }
}

class Service implements Logger {
}

public class PrivateMethods {
    public static void main(String[] args) {
        Service s = new Service();
        s.info("Started service");
    }
}