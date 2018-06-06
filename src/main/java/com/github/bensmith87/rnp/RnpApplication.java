package com.github.bensmith87.rnp;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.Scanner;

public class RnpApplication {

    private final RnpCalculator rnpCalculator = new RnpCalculator();

    public static void main(String[] args) {
        RnpApplication rnpApplication = new RnpApplication();
        rnpApplication.run();
    }

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
                parseNumber(token);
            }
            else {
                throw new RuntimeException("Don't know what to do with " + token);
            }
        }
        rnpCalculator.print();
    }

    private void parseNumber(String token) {
        double number = Double.parseDouble(token);
        rnpCalculator.pushNumber(number);
    }
}
