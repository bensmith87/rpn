package com.github.bensmith87.rnp;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RnpCalculatorTest {

    private RnpCalculator rnpCalculator;

    @Before
    public void setup() {
        rnpCalculator = RnpCalculatorFactory.create();
    }

    @Test
    public void pushNumber() {
        // When a number has been pushed
        rnpCalculator.pushNumber(5);

        // Then the stack contains the number
        assertThat(rnpCalculator.getStack()).containsExactly(5.0);
    }

    @Test
    public void sqrt() {
        // Given a number has been pushed
        rnpCalculator.pushNumber(9);

        // When a sqrt operation is performed
        rnpCalculator.doOperation("sqrt");

        // Then the stack contains the sqrt of the number
        assertThat(rnpCalculator.getStack()).containsExactly(3.0);
    }

    @Test
    public void clear() {
        // Given a number has been pushed
        rnpCalculator.pushNumber(9);

        // When a clear operation is performed
        rnpCalculator.doOperation("clear");

        // Then the stack is empty
        assertThat(rnpCalculator.getStack()).isEmpty();
    }
}