package com.github.bensmith87.rnp.operation;

import java.util.Stack;
import java.util.function.Function;

/**
 * Unary Operation.
 *
 * A unary operation is an operation that operates on one operand.
 */
public class UnaryOperation implements Operation {

    private final Function<Double, Double> function;

    public UnaryOperation(Function<Double, Double> function) {
        this.function = function;
    }

    @Override
    public boolean operate(Stack<Double> stack, Stack<Double> numbersPoped) {
        if (stack.size() < 1) {
            throw new IllegalStateException("Stack does not contain enough numbers for a unary operation");
        }

        double operand = stack.pop();
        double result = function.apply(operand);
        stack.push(result);

        numbersPoped.add(operand);

        return true;
    }
}
