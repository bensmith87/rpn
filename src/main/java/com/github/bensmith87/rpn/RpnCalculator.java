package com.github.bensmith87.rpn;

import com.github.bensmith87.rpn.command.Command;
import com.github.bensmith87.rpn.command.DoOperationCommand;
import com.github.bensmith87.rpn.command.PushNumberCommand;
import com.github.bensmith87.rpn.operation.Operation;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * RPN Calculator.
 *
 * Maintains the stack of operands and a stack of commands.
 * Allows numbers to be pushed, operations to be done, and allows these commands to be undone.
 */
public class RpnCalculator {

    private final Stack<Double> stack = new Stack<>();

    private final Stack<Command> commands = new Stack<>();

    private final Map<String, Operation> operations = new HashMap<>();

    public void registerOperation(String operationName, Operation operation) {
        operations.put(operationName, operation);
    }

    public void pushNumber(double number) {
        PushNumberCommand command = new PushNumberCommand(number);
        command.apply(stack);
        commands.push(command);
    }

    public boolean isOperationName(String operationName) {
        return operations.containsKey(operationName);
    }

    public void doOperation(String operationName) throws OperationFailedException {
        assert operations.containsKey(operationName) : operationName + " is not a registered operation name";

        Operation operation = operations.get(operationName);
        DoOperationCommand command = new DoOperationCommand(operation);
        commands.push(command);

        try {
            command.apply(stack);
        }
        catch (IllegalStateException e) {
            throw new OperationFailedException("operator " + operationName + " (position: " + commands.size() + "): insufficient parameters", e);
        }
    }

    public void undo() {
        Command command = commands.pop();
        command.undo(stack);
    }

    public void print() {
        String stackString = stack.stream()
                .map(this::formatNumber)
                .collect(Collectors.joining(" "));

        System.out.println("stack: " + stackString);
    }

    public Stack<Double> getStack() {
        return stack;
    }

    private String formatNumber(double number) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##########");
        decimalFormat.setRoundingMode(RoundingMode.CEILING);
        return decimalFormat.format(number);
    }
}
