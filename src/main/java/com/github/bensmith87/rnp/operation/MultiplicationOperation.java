package com.github.bensmith87.rnp.operation;

import java.util.Stack;

public class MultiplicationOperation implements Operation {

    @Override
    public boolean operate(Stack<Double> stack, Stack<Double> numbersPoped) {
        double operand1 = stack.pop();
        double operand2 = stack.pop();

        double result = operand2 * operand1;

        stack.push(result);

        numbersPoped.add(operand2);
        numbersPoped.add(operand1);

        return true;
    }
}
