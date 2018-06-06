package com.github.bensmith87.rnp;

import javax.swing.text.html.StyleSheet;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * RNP Application.
 *
 * The main entry point of the application.
 * Parses user input and calls the calculator.
 */
class RnpApplication {

    private final RnpCalculator rnpCalculator = RnpCalculatorFactory.create();

    private void run() {
        System.out.println("RNP Calculator");
        System.out.println("Input a whitespace separated string of numbers and operators");
        System.out.println("Valid operators are: + - / * undo clear");
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
        catch (Exception e) {
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
        if (isNumber(token)) {
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
            throw new IllegalArgumentException(token + " is an unknown token");
        }
    }

    public static void main(String[] args) {
        RnpApplication rnpApplication = new RnpApplication();
        rnpApplication.run();
    }

    private boolean isNumber(String token) {
        return token.matches("-?\\d+(\\.\\d+)?");
    }
}
