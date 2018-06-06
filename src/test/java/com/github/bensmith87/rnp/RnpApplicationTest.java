package com.github.bensmith87.rnp;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RnpApplicationTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private RnpApplication rnpApplication;

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
        rnpApplication = new RnpApplication();
    }

    @After
    public void tearDown() {
        System.setOut(System.out);
    }

    @Test
    public void example1() {
        input("5 2");
        // todo: "stack: 5 2"
        assertThat(output()).isEqualTo("stack: 5.0 2.0");
    }

    @Test
    public void example2() {
        input("2 sqrt");
        // todo: "stack: 1.4142135623"
        assertThat(output()).isEqualTo("stack: 1.4142135623730951");
        input("clear 9 sqrt");
        assertThat(output()).isEqualTo("stack: 3.0");
    }

    @Test
    public void example3() {
        input("5 2 -");
        assertThat(output()).isEqualTo("stack: 3.0");
        input("3 -");
        assertThat(output()).isEqualTo("stack: 0.0");
        input("clear");
        assertThat(output()).isEqualTo("stack: ");
    }

    @Test
    public void example4() {
        input("5 4 3 2");
        assertThat(output()).isEqualTo("stack: 5.0 4.0 3.0 2.0");
        input("undo undo *");
        assertThat(output()).isEqualTo("stack: 20.0");
        input("5 *");
        assertThat(output()).isEqualTo("stack: 100.0");
        input("undo");
        assertThat(output()).isEqualTo("stack: 20.0 5.0");
    }

    @Test
    public void example5() {
        input("7 12 2 /");
        assertThat(output()).isEqualTo("stack: 7.0 6.0");
        input("*");
        assertThat(output()).isEqualTo("stack: 42.0");
        input("4 /");
        assertThat(output()).isEqualTo("stack: 10.5");
    }

    private void input(String line) {
        rnpApplication.evaluateLine(line);
    }

    private String output() {
        // Remove the trailing new line character
        String line = StringUtils.chop(outContent.toString());
        outContent.reset();
        return line;
    }
}