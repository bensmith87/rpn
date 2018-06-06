package com.github.bensmith87.rnp;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class RnpApplication {

    private final RnpCalculator rnpCalculator = RnpCalculatorFactory.create();

    private void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            evaluateLine(line);
        }
    }

    public void evaluateLine(String line) {
        List<String> tokens = splitIntoTokens(line);

        try {
            processTokens(tokens);
        }
        catch (OperationFailedException e) {
            System.out.println(e.getMessage());
        }
        finally {
            rnpCalculator.print();
        }
    }

    private List<String> splitIntoTokens(String line) {
        return Arrays.asList(line.split("\\s+"));
    }

    private void processTokens(List<String> tokens) throws OperationFailedException {
        for (String token : tokens) {
            processToken(token);
        }
    }

    private void processToken(String token) throws OperationFailedException {
        if (NumberUtils.isCreatable(token)) {
            double number = Double.parseDouble(token);
            rnpCalculator.pushNumber(number);
        }
        else if (rnpCalculator.isOperationName(token)) {
            rnpCalculator.doOperation(token);
        }
        else if ("undo".equals(token)) {
            rnpCalculator.undo();
        }
        else {
            throw new RuntimeException("Don't know what to do with " + token);
        }
    }

    public static void main(String[] args) {
        RnpApplication rnpApplication = new RnpApplication();
        rnpApplication.run();
    }
}
