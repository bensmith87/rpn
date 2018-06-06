package com.github.bensmith87.rnp.command;

import com.github.bensmith87.rnp.operation.Operation;

import java.util.Stack;

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
