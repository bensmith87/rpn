package com.github.bensmith87.rnp;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RnpCalculatorTest {

    private RnpCalculator rnpCalculator;

    @Before
    public void setup() {
        rnpCalculator = new RnpCalculator();
    }

    @Test
    public void pushNumber() {
        // When a number has been pushed
        rnpCalculator.pushNumber(5);

        // Then the stack contains the number
        assertThat(rnpCalculator.getStack()).containsExactly(5.0);
    }
}