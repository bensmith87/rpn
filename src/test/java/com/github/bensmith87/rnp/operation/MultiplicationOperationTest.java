package com.github.bensmith87.rnp.operation;

import org.junit.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class MultiplicationOperationTest {

    private final MultiplicationOperation multiplicationOperation = new MultiplicationOperation();

    private final Stack<Double> numbersPoped = new Stack<>();

    @Test
    public void multiplication() {
        // Given a stack with two numbers
        Stack<Double> stack = new Stack<>();
        stack.push(9.0);
        stack.push(5.0);

        // When the operation is called
        multiplicationOperation.operate(stack, numbersPoped);

        // Then the stack contains the the first multiplied by the second number
        assertThat(stack).containsExactly(45.0);

        // And numbers poped contains the original numbers
        assertThat(numbersPoped).containsExactly(9.0, 5.0);
    }
}
