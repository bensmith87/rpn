package com.github.bensmith87.rpn;

import com.github.bensmith87.rpn.operation.Operation;
import com.github.bensmith87.rpn.operation.UnaryOperation;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class RpnCalculatorTest {

    private static final String OPERATION_NAME = "op";

    private RpnCalculator rpnCalculator;

    @Before
    public void setup() {
        rpnCalculator = new RpnCalculator();
    }

    @Test
    public void pushNumber() {
        // When a number has been pushed
        rpnCalculator.pushNumber(5);

        // Then the stack contains the number
        assertThat(rpnCalculator.getStack()).containsExactly(5.0);
    }

    @Test
    public void undoPushNumber() {
        // Given a number has been pushed
        rpnCalculator.pushNumber(5);

        // When undo is called
        rpnCalculator.undo();

        // Then the number is removed from the stack
        assertThat(rpnCalculator.getStack()).isEmpty();
    }

    @Test
    public void doOperation() throws OperationFailedException {
        // Given an operation has been registered
        Operation operation = spy(new UnaryOperation(a -> a * 2));
        rpnCalculator.registerOperation(OPERATION_NAME, operation);

        // When the operation is performed
        rpnCalculator.pushNumber(5);
        rpnCalculator.doOperation(OPERATION_NAME);

        // Then the operation is performed with the calculators stack
        verify(operation).operate(eq(rpnCalculator.getStack()), any());
        assertThat(rpnCalculator.getStack()).containsExactly(10.0);
    }

    @Test
    public void undoDoOperation() throws OperationFailedException {
        // Given an operation has been performed
        Operation operation = new UnaryOperation(a -> a * 2);
        rpnCalculator.registerOperation(OPERATION_NAME, operation);
        rpnCalculator.pushNumber(5);
        rpnCalculator.doOperation(OPERATION_NAME);

        // When undo is called
        rpnCalculator.undo();

        // Then the operation is undone
        assertThat(rpnCalculator.getStack()).containsExactly(5.0);
    }
}