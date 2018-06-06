package com.github.bensmith87.rnp;

import java.util.Stack;

public final class SqrtOperation implements Operation {

    @Override
    public void operate(Stack<Double> stack) {
        double operand = stack.pop();
        double result = Math.sqrt(operand);
        stack.push(result);
    }
}
