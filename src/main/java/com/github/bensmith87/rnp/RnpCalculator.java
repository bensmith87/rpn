package com.github.bensmith87.rnp;

import java.util.Stack;
import java.util.stream.Collectors;

public class RnpCalculator {

    private final Stack<Double> stack = new Stack<>();

    public void pushNumber(double number) {
        stack.push(number);
    }

    public void print() {
        // todo: nicer join
        System.out.println("stack: " + stack.stream().map(Object::toString).collect(Collectors.joining(" ")));
    }

    public Stack<Double> getStack() {
        return stack;
    }
}
