import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    public void setUp() {
        this.calculator = new Calculator();
    }

    @Test
    void testAddition() {
        calculator.addOperation(new Addition(calculator, 10));
        calculator.doCalc();
        assertEquals(10, calculator.result);
        calculator.addOperation(new Addition(calculator, 20));
        calculator.doCalc();
        assertEquals(30, calculator.result);
    }

    @Test
    void testSubtraction() {
        calculator.addOperation(new Subtraction(calculator, 10));
        calculator.doCalc();
        assertEquals(-10, calculator.result);
        calculator.addOperation(new Subtraction(calculator, 20));
        calculator.doCalc();
        assertEquals(-30, calculator.result);
    }

    @Test
    void testDivision() {
        calculator.addOperation(new Addition(calculator, 10));
        calculator.addOperation(new Division(calculator, 5));
        calculator.doCalc();
        assertEquals(2, calculator.result);
    }

    @Test
    void testMultiplication() {
        calculator.addOperation(new Addition(calculator, 10));
        calculator.addOperation(new Multiplication(calculator, 5));
        calculator.doCalc();
        assertEquals(50, calculator.result);
    }

    @Test
    void testUndo() {
        calculator.addOperation(new Addition(calculator, 10));
        calculator.addOperation(new Addition(calculator, 20));
        calculator.addOperation(new Division(calculator, 5));
        calculator.doCalc();
        assertEquals(6, calculator.result);
        calculator.undo();
        calculator.doCalc();
        assertEquals(30, calculator.result);
        calculator.doCalc();
        calculator.undo();
        calculator.doCalc();
        assertEquals(10, calculator.result);
        calculator.undo();
        calculator.doCalc();
        assertEquals(0, calculator.result);
    }

    @Test
    void testRedo() {
        calculator.addOperation(new Addition(calculator, 10));
        calculator.addOperation(new Addition(calculator, 20));
        calculator.addOperation(new Division(calculator, 5));
        calculator.doCalc();
        assertEquals(6, calculator.result);
        calculator.undo();
        calculator.doCalc();
        assertEquals(30, calculator.result);
        calculator.doCalc();
        calculator.undo();
        calculator.doCalc();
        assertEquals(10, calculator.result);
        calculator.redo();
        calculator.doCalc();
        assertEquals(30, calculator.result);
        calculator.redo();
        calculator.doCalc();
        assertEquals(6, calculator.result);
    }
}