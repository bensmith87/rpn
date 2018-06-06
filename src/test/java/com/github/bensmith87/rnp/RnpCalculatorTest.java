package com.github.bensmith87.rnp;

import com.github.bensmith87.rnp.operation.Operation;
import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RnpCalculatorTest {

    private static final String OPERATION_NAME = "op";

    private RnpCalculator rnpCalculator;

    @Before
    public void setup() {
        rnpCalculator = RnpCalculatorFactory.create();
    }

    @Test
    public void pushNumber() {
        // When a number has been pushed
        rnpCalculator.pushNumber(5);

        // Then the stack contains the number
        assertThat(rnpCalculator.getStack()).containsExactly(5.0);
    }

    @Test
    public void doOperation() {
        // Given a operation has been registered
        Operation operation = mock(Operation.class);
        rnpCalculator.registerOperation(OPERATION_NAME, operation);

        // When the operation is performed
        rnpCalculator.doOperation(OPERATION_NAME);

        // Then the operation is performed with the calculators stack
        verify(operation).operate(eq(rnpCalculator.getStack()), any(Stack.class));
    }
}