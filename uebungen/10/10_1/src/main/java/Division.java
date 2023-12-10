public class Division implements OperationCommand {
    private final Calculator calculator;
    private final float a;

    public Division(Calculator calculator, float a) {
        this.calculator = calculator;
        this.a = a;
    }

    @Override
    public void execute() {
        calculator.result /= a;
    }
}
