package com.github.bensmith87.rnp.command;

import java.util.Stack;

/**
 * Push Number Command.
 *
 * Command to do and undo pushing a number onto the stack.
 */
public class PushNumberCommand implements Command {

    private final double number;

    public PushNumberCommand(double number) {
        this.number = number;
    }

    @Override
    public void apply(Stack<Double> stack) {
        stack.push(number);
    }

    @Override
    public void undo(Stack<Double> stack) {
        assert stack.peek() == number : "can't undo because the top number on the stack is not the same as the command number";

        stack.pop();
    }
}
