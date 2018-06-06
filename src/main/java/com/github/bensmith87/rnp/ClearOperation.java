package com.github.bensmith87.rnp;

import java.util.Stack;

public class ClearOperation implements Operation {

    @Override
    public void operate(Stack<Double> stack) {
        stack.clear();
    }
}
