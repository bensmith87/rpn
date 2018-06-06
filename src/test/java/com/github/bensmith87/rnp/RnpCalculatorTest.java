package com.github.bensmith87.rnp;

import com.github.bensmith87.rnp.operation.Operation;
import com.github.bensmith87.rnp.operation.UnaryOperation;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class RnpCalculatorTest {

    private static final String OPERATION_NAME = "op";

    private RnpCalculator rnpCalculator;

    @Before
    public void setup() {
        rnpCalculator = new RnpCalculator();
    }

    @Test
    public void pushNumber() {
        // When a number has been pushed
        rnpCalculator.pushNumber(5);

        // Then the stack contains the number
        assertThat(rnpCalculator.getStack()).containsExactly(5.0);
    }

    @Test
    public void undoPushNumber() {
        // Given a number has been pushed
        rnpCalculator.pushNumber(5);

        // When undo is called
        rnpCalculator.undo();

        // Then the number is removed from the stack
        assertThat(rnpCalculator.getStack()).isEmpty();
    }

    @Test
    public void doOperation() throws OperationFailedException {
        // Given an operation has been registered
        Operation operation = spy(new UnaryOperation(a -> a * 2));
        rnpCalculator.registerOperation(OPERATION_NAME, operation);

        // When the operation is performed
        rnpCalculator.pushNumber(5);
        rnpCalculator.doOperation(OPERATION_NAME);

        // Then the operation is performed with the calculators stack
        verify(operation).operate(eq(rnpCalculator.getStack()), any());
        assertThat(rnpCalculator.getStack()).containsExactly(10.0);
    }

    @Test
    public void undoDoOperation() throws OperationFailedException {
        // Given an operation has been performed
        Operation operation = new UnaryOperation(a -> a * 2);
        rnpCalculator.registerOperation(OPERATION_NAME, operation);
        rnpCalculator.pushNumber(5);
        rnpCalculator.doOperation(OPERATION_NAME);

        // When undo is called
        rnpCalculator.undo();

        // Then the operation is undone
        assertThat(rnpCalculator.getStack()).containsExactly(5.0);
    }
}