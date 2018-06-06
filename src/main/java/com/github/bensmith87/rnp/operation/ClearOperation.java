package com.github.bensmith87.rnp.operation;

import java.util.Stack;

public class ClearOperation implements Operation {

    @Override
    public boolean operate(Stack<Double> stack, Stack<Double> numbersPoped) {
        numbersPoped.addAll(stack);
        stack.clear();
        return false;
    }
}
