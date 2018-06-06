package com.github.bensmith87.rpn;

import com.github.bensmith87.rpn.operation.*;

/**
 * RPN Calculator Factory.
 */
final class RpnCalculatorFactory {

    private RpnCalculatorFactory() {}

    public static RpnCalculator create() {
        RpnCalculator rpnCalculator = new RpnCalculator();

        rpnCalculator.registerOperation("sqrt", new UnaryOperation(Math::sqrt));
        rpnCalculator.registerOperation("clear", new ClearOperation());
        rpnCalculator.registerOperation("-", new BinaryOperation((a, b) -> a - b));
        rpnCalculator.registerOperation("*", new BinaryOperation((a, b) -> a * b));
        rpnCalculator.registerOperation("/", new BinaryOperation((a, b) -> a / b));
        rpnCalculator.registerOperation("+", new BinaryOperation((a, b) -> a + b));

        return rpnCalculator;
    }
}
