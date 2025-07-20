package Lambda;

public class Main {
    
    public static void main(String[] args) {
        MyFunctionalInterface lambdaExpression = ()-> {
            System.out.println("using lambda expression");
        };
        lambdaExpression.functionalInterface();

        MyFunctionalInterface lambdaExpression1 = () -> System.out.println("using lambda expression on second object");
        lambdaExpression1.functionalInterface();

        SumOfNumbers add = (int a,int b) ->{
            return a + b;
        };
        SumOfNumbers add1 = (a, b) -> a + b; // no need to return it automatically return the value,and no need to menction input type also
        System.out.println(add.sum(7, 10));
        System.out.println(add1.sum(9, 4));
        
        LengthOfStr len = str -> str.length();
        System.out.println("length of the string is " + len.stringLength("Rama Krishan Reddy"));

    }
}
