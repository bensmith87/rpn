package com.github.bensmith87.rnp;

import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class MinusOperationTest {

    private MinusOperation minusOperation;

    @Before
    public void setup() {
        minusOperation = new MinusOperation();
    }

    @Test
    public void clear() {
        // Given a stack with two numbers
        Stack<Double> stack = new Stack<>();
        stack.push(9.0);
        stack.push(5.0);

        // When the operation is called
        minusOperation.operate(stack);

        // Then the stack contains the the first minus the second number
        assertThat(stack).containsExactly(4.0);
    }
}
