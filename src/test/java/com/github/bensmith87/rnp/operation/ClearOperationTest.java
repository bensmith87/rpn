package com.github.bensmith87.rnp.operation;

import org.junit.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class ClearOperationTest {

    private final ClearOperation clearOperation = new ClearOperation();

    private final Stack<Double> numbersPoped = new Stack<>();

    @Test
    public void clear() {
        // Given a stack with a number
        Stack<Double> stack = new Stack<>();
        stack.push(9.0);

        // When the operation is called
        clearOperation.operate(stack, numbersPoped);

        // Then the stack is empty
        assertThat(stack).isEmpty();

        // And numbers poped contains the original number
        assertThat(numbersPoped).containsExactly(9.0);
    }
}
