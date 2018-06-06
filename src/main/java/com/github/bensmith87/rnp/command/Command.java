package com.github.bensmith87.rnp.command;

import java.util.Stack;

/**
 * Command Interface.
 *
 * The command pattern is used to achieve the undo functionality.
 */
public interface Command {

    void apply(Stack<Double> stack);

    void undo(Stack<Double> stack);
}
