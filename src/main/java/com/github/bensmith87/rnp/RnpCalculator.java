package com.github.bensmith87.rnp;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class RnpCalculator {

    private final Stack<Double> stack = new Stack<>();

    private final Map<String, Operation> operations = new HashMap<>();

    public void registerOperation(String operationName, Operation operation) {
        operations.put(operationName, operation);
    }

    public void pushNumber(double number) {
        stack.push(number);
    }

    public boolean isOperationName(String operationName) {
        return operations.containsKey(operationName);
    }

    public void doOperation(String operationName) {
        assert operations.containsKey(operationName) : operationName + " is not a registered operation name";
        Operation operation = operations.get(operationName);
        operation.operate(stack);
    }

    public void print() {
        // todo: nicer join
        System.out.println("stack: " + stack.stream().map(Object::toString).collect(Collectors.joining(" ")));
    }

    public Stack<Double> getStack() {
        return stack;
    }
}
