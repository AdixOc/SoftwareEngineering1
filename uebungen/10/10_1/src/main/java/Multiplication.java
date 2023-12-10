public class Multiplication implements OperationCommand {
    private final Calculator calculator;
    private final float a;

    public Multiplication(Calculator calculator, float a) {
        this.calculator = calculator;
        this.a = a;
    }

    @Override
    public void execute() {
        calculator.result *= a;
    }
}