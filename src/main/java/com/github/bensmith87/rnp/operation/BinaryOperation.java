package com.github.bensmith87.rnp.operation;

import java.util.Stack;
import java.util.function.BiFunction;

public final class BinaryOperation implements Operation {

    private final BiFunction<Double, Double, Double> function;

    public BinaryOperation(BiFunction<Double, Double, Double> function) {
        this.function = function;
    }

    @Override
    public final boolean operate(Stack<Double> stack, Stack<Double> numbersPoped) {
        double operand2 = stack.pop();
        double operand1 = stack.pop();

        double result = function.apply(operand1, operand2);

        stack.push(result);

        numbersPoped.add(operand1);
        numbersPoped.add(operand2);

        return true;
    }
}
