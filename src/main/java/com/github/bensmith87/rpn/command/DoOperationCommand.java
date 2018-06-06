package com.github.bensmith87.rpn.command;

import com.github.bensmith87.rpn.operation.Operation;

import java.util.Stack;

/**
 * Do Operation Command.
 *
 * Command to do and undo an operation.
 *
 * When an operation is undone the result needs to be poped from the stack and the operands that were poped from the
 * stack need to be pushed back on.
 *
 * To achieve this the command needs to remember which operands were poped off the stack.
 */
public class DoOperationCommand implements Command {

    private final Operation operation;

    private final Stack<Double> numbersPoped = new Stack<>();

    public DoOperationCommand(Operation operation) {
        this.operation = operation;
    }

    @Override
    public void apply(Stack<Double> stack) {
        assert numbersPoped.isEmpty() : "operation already applied";

        int startStackSize = stack.size();

        boolean resultAdded = operation.operate(stack, numbersPoped);

        int expectedStackSize = startStackSize - numbersPoped.size() + (resultAdded ? 1 : 0);
        int actualStackSize = stack.size();
        assert actualStackSize == expectedStackSize : "expecting stack size to be " + expectedStackSize + " but was " + actualStackSize;
    }

    @Override
    public void undo(Stack<Double> stack) {
        // Pop the result that was pushed by the operation
        stack.pop();

        // Push the numbers that were poped by the operation
        stack.addAll(numbersPoped);
        numbersPoped.clear();
    }
}
