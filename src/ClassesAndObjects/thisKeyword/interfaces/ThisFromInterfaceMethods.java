package ClassesAndObjects.thisKeyword.interfaces;

interface Clickable {
    default void click(Handler handler) {
        handler.handle(this); // pass current object
    }
}

class Button implements Clickable {
}

class Handler {
    void handle(Clickable c) {
        System.out.println("Handling click from " + c.getClass().getSimpleName());
    }
}

public class ThisFromInterfaceMethods {
    public static void main(String[] args) {
        Button b = new Button();
        b.click(new Handler()); // passes 'this' from interface
    }
}