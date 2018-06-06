package com.github.bensmith87.rpn.operation;

import java.util.Stack;

/**
 * Clear Operation.
 */
public class ClearOperation implements Operation {

    @Override
    public boolean operate(Stack<Double> stack, Stack<Double> numbersPoped) {
        numbersPoped.addAll(stack);
        stack.clear();
        return false;
    }
}
