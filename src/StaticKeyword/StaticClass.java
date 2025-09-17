package StaticKeyword;

class Outer {
    static class Inner {
        void message() {
            System.out.println("Hello from static nested class!");
        }
    }
}

public class StaticClass {
    public static void main(String[] args) {
        Outer.Inner obj = new Outer.Inner();
        obj.message();
    }
}