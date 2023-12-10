public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.addOperation(new Addition(calculator, 10));
        calculator.addOperation(new Addition(calculator, 20));
        calculator.addOperation(new Division(calculator, 5));
        System.out.println(calculator);
        Calculator calculator2 = new Calculator();
        calculator2.addOperation(new Addition(calculator2, 0.1f));
        calculator2.addOperation(new Addition(calculator2, 0.1f));
        calculator2.addOperation(new Addition(calculator2, 0.1f));
        System.out.println(calculator2);
    }
}
