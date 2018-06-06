package com.github.bensmith87.rnp;

import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class SqrtOperationTest {

    private SqrtOperation sqrtOperation;

    @Before
    public void setup() {
        sqrtOperation = new SqrtOperation();
    }

    @Test
    public void clear() {
        // Given a stack with a number
        Stack<Double> stack = new Stack<>();
        stack.push(9.0);

        // When the operation is called
        sqrtOperation.operate(stack);

        // Then the stack contains the sqrt of the number
        assertThat(stack).containsExactly(3.0);
    }
}
