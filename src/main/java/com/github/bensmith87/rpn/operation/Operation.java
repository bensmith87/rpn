package com.github.bensmith87.rpn.operation;

import java.util.Stack;

/**
 * Operation Interface.
 */
@FunctionalInterface
public interface Operation {

    /**
     * Perform the operation.
     *
     * @param stack the stack of number to perform the operation on
     * @param numbersPoped the operands that were poped off the stack
     * @return true if a result was added back to the stack
     */
    boolean operate(Stack<Double> stack, Stack<Double> numbersPoped);
}
