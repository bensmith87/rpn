package com.github.bensmith87.rnp.operation;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Stack;
import java.util.function.BiFunction;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class BinaryOperationTest {

    private static final double A = 6;
    private static final double B = 7;
    private static final double C = 42;

    private final Stack<Double> numbersPoped = new Stack<>();

    private BinaryOperation binaryOperation;

    @Mock
    private BiFunction<Double, Double, Double> function;

    @Before
    public void setup() {
        initMocks(this);

        when(function.apply(A, B)).thenReturn(C);

        binaryOperation = new BinaryOperation(function);
    }

    @Test
    public void operate() {
        // Given a stack with two numbers
        Stack<Double> stack = new Stack<>();
        stack.push(A);
        stack.push(B);

        // When the operation is called
        binaryOperation.operate(stack, numbersPoped);

        // Then the function is applied to the numbers
        verify(function).apply(A, B);

        // And the stack contains the result
        assertThat(stack).containsExactly(C);

        // And numbers poped contains the original numbers
        assertThat(numbersPoped).containsExactly(A, B);
    }
}
