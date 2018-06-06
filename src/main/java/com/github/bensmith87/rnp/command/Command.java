package com.github.bensmith87.rnp.command;

import java.util.Stack;

public interface Command {

    void apply(Stack<Double> stack);

    void undo(Stack<Double> stack);
}
