package com.github.bensmith87.rnp;

import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class ClearOperationTest {

    private ClearOperation clearOperation;

    @Before
    public void setup() {
        clearOperation = new ClearOperation();
    }

    @Test
    public void clear() {
        // Given a stack with a number
        Stack<Double> stack = new Stack<>();
        stack.push(9.0);

        // When the operation is called
        clearOperation.operate(stack);

        // Then the stack is empty
        assertThat(stack).isEmpty();
    }
}
