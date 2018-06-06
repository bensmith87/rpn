package com.github.bensmith87.rnp;

public final class RnpCalculatorFactory {

    private RnpCalculatorFactory() {}

    public static RnpCalculator create() {
        RnpCalculator rnpCalculator = new RnpCalculator();

        rnpCalculator.registerOperation("sqrt", new SqrtOperation());
        rnpCalculator.registerOperation("clear", new ClearOperation());
        rnpCalculator.registerOperation("-", new MinusOperation());

        return rnpCalculator;
    }
}
