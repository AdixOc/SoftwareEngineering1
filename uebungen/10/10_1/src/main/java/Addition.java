public class Addition implements OperationCommand{
    private final Calculator calculator;
    private final float a;

    public Addition(Calculator calculator, float a) {
        this.calculator = calculator;
        this.a = a;
    }

    @Override
    public void execute() {
        calculator.result += this.a;
    }
}
