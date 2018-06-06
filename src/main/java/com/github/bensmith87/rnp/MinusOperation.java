package com.github.bensmith87.rnp;

import java.util.Stack;

public class MinusOperation implements Operation {

    @Override
    public void operate(Stack<Double> stack) {
        double operand1 = stack.pop();
        double operand2 = stack.pop();

        double result = operand2 - operand1;

        stack.push(result);
    }
}
