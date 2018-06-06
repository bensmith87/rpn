package com.github.bensmith87.rnp;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.Scanner;

public class RnpApplication {

    private final RnpCalculator rnpCalculator = RnpCalculatorFactory.create();

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            evaluateLine(line);
        }
    }

    public void evaluateLine(String line) {
        String[] tokens = line.split(" ");
        for (String token : tokens) {
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
        rnpCalculator.print();
    }

    public static void main(String[] args) {
        RnpApplication rnpApplication = new RnpApplication();
        rnpApplication.run();
    }
}
