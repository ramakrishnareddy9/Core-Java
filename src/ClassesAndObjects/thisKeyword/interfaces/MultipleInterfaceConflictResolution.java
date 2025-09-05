package ClassesAndObjects.thisKeyword.interfaces;

interface A {
    default void show() {
        System.out.println("From A");
    }
}

interface B {
    default void show() {
        System.out.println("From B");
    }
}

class C implements A, B {
    @Override
    public void show() {
        A.super.show(); // call A’s default method
        B.super.show(); // call B’s default method
        System.out.println("Resolved by: " + this.getClass().getSimpleName());
    }
}

public class MultipleInterfaceConflictResolution {
    public static void main(String[] args) {
        C obj = new C();
        obj.show();
    }
}
