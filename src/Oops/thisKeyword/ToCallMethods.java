package Oops.thisKeyword;

class Test {
    void show() {
        System.out.println("show() called");
    }

    void callShow() {
        this.show(); // calls current class method
    }
}

public class ToCallMethods {
    public static void main(String[] args) {
        Test t = new Test();
        t.callShow();
    }
}