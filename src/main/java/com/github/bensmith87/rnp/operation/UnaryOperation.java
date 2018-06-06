package com.github.bensmith87.rnp.operation;

import java.util.Stack;
import java.util.function.Function;

public final class UnaryOperation implements Operation {

    private final Function<Double, Double> function;

    public UnaryOperation(Function<Double, Double> function) {
        this.function = function;
    }

    @Override
    public boolean operate(Stack<Double> stack, Stack<Double> numbersPoped) {
        double operand = stack.pop();
        double result = function.apply(operand);
        stack.push(result);

        numbersPoped.add(operand);

        return true;
    }
}
