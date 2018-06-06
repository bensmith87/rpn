package com.github.bensmith87.rnp.operation;

import java.util.Stack;

public final class SqrtOperation implements Operation {

    @Override
    public boolean operate(Stack<Double> stack, Stack<Double> numbersPoped) {
        double operand = stack.pop();
        double result = Math.sqrt(operand);
        stack.push(result);

        numbersPoped.add(operand);

        return true;
    }
}
