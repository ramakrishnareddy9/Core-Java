package ClassesAndObjects;

class MathOperations {
    int add(int a, int b) {
        return a + b;
    }
    
    int sub(int a, int b) {
        return a - b;
    }

    int mul(int a, int b) {
        return a * b;
    }

    double div(int a, int b) {
        return a / b;
    }
}

public class ClassAndObject {
    public static void main(String[] args) {
        MathOperations math = new MathOperations();
        System.out.println(math.add(9, 7));
        System.out.println(math.div(5,3));
    }
}
