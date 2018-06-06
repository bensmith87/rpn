package com.github.bensmith87.rpn.operation;

import java.util.Stack;
import java.util.function.BiFunction;

/**
 * Binary Operation.
 *
 * A binary operation is an operation that operates on two operands.
 */
public final class BinaryOperation implements Operation {

    private final BiFunction<Double, Double, Double> function;

    public BinaryOperation(BiFunction<Double, Double, Double> function) {
        this.function = function;
    }

    @Override
    public final boolean operate(Stack<Double> stack, Stack<Double> numbersPoped) {
        if (stack.size() < 2) {
            throw new IllegalStateException("Stack does not contain enough numbers for a binary operation");
        }

        double operand2 = stack.pop();
        double operand1 = stack.pop();

        double result = function.apply(operand1, operand2);

        stack.push(result);

        numbersPoped.add(operand1);
        numbersPoped.add(operand2);

        return true;
    }
}
