package com.github.bensmith87.rnp.operation;

import org.junit.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class SqrtOperationTest {

    private final SqrtOperation sqrtOperation = new SqrtOperation();

    private final Stack<Double> numbersPoped = new Stack<>();

    @Test
    public void sqrt() {
        // Given a stack with a number
        Stack<Double> stack = new Stack<>();
        stack.push(9.0);

        // When the operation is called
        sqrtOperation.operate(stack, numbersPoped);

        // Then the stack contains the sqrt of the number
        assertThat(stack).containsExactly(3.0);

        // And numbers poped contains the original numbers
        assertThat(numbersPoped).containsExactly(9.0);
    }
}
