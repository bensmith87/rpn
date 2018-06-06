package com.github.bensmith87.rnp;

import com.github.bensmith87.rnp.operation.ClearOperation;
import com.github.bensmith87.rnp.operation.SubtractionOperation;
import com.github.bensmith87.rnp.operation.MultiplicationOperation;
import com.github.bensmith87.rnp.operation.SqrtOperation;

public final class RnpCalculatorFactory {

    private RnpCalculatorFactory() {}

    public static RnpCalculator create() {
        RnpCalculator rnpCalculator = new RnpCalculator();

        rnpCalculator.registerOperation("sqrt", new SqrtOperation());
        rnpCalculator.registerOperation("clear", new ClearOperation());
        rnpCalculator.registerOperation("-", new SubtractionOperation());
        rnpCalculator.registerOperation("*", new MultiplicationOperation());

        return rnpCalculator;
    }
}
