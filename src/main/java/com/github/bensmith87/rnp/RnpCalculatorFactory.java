package com.github.bensmith87.rnp;

import com.github.bensmith87.rnp.operation.*;

public final class RnpCalculatorFactory {

    private RnpCalculatorFactory() {}

    public static RnpCalculator create() {
        RnpCalculator rnpCalculator = new RnpCalculator();

        rnpCalculator.registerOperation("sqrt", new UnaryOperation(Math::sqrt));
        rnpCalculator.registerOperation("clear", new ClearOperation());
        rnpCalculator.registerOperation("-", new BinaryOperation((a, b) -> a - b));
        rnpCalculator.registerOperation("*", new BinaryOperation((a, b) -> a * b));
        rnpCalculator.registerOperation("/", new BinaryOperation((a, b) -> a / b));

        return rnpCalculator;
    }
}
