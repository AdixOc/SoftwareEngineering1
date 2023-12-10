public class Subtraction implements OperationCommand {
    private final Calculator calculator;
    private final float a;

    public Subtraction(Calculator calculator, float a) {
        this.calculator = calculator;
        this.a = a;
    }

    @Override
    public void execute() {
        calculator.result -= a;
    }
}
