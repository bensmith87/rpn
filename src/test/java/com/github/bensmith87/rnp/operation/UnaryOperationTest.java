package com.github.bensmith87.rnp.operation;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Stack;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class UnaryOperationTest {

    private static final double A = 6;
    private static final double B = 7;

    private final Stack<Double> numbersPoped = new Stack<>();

    private UnaryOperation unaryOperation;

    @Mock
    private Function<Double, Double> function;

    @Before
    public void setup() {
        initMocks(this);

        when(function.apply(A)).thenReturn(B);

        unaryOperation = new UnaryOperation(function);
    }

    @Test
    public void operate() {
        // Given a stack with a number
        Stack<Double> stack = new Stack<>();
        stack.push(A);

        // When the operation is called
        unaryOperation.operate(stack, numbersPoped);

        // Then the function is applied to the number
        verify(function).apply(A);

        // And the stack contains the result
        assertThat(stack).containsExactly(B);

        // And numbers poped contains the original numbers
        assertThat(numbersPoped).containsExactly(A);
    }

    @Test(expected = IllegalStateException.class)
    public void insufficientParameters() {
        // Given the stack has insufficient parameters
        Stack<Double> stack = new Stack<>();

        // When the operation is called
        unaryOperation.operate(stack, numbersPoped);

        // Then an illegal state exception is thrown
    }
}
