package com.github.bensmith87.rpn;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RpnApplicationTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private RpnApplication rpnApplication;

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
        rpnApplication = new RpnApplication();
    }

    @After
    public void tearDown() {
        System.setOut(System.out);
    }

    @Test
    public void example1() {
        input("5 2");
        assertThat(output()[0]).isEqualTo("stack: 5 2");
    }

    @Test
    public void example2() {
        input("2 sqrt");
        assertThat(output()[0]).isEqualTo("stack: 1.4142135624");
        input("clear 9 sqrt");
        assertThat(output()[0]).isEqualTo("stack: 3");
    }

    @Test
    public void example3() {
        input("5 2 -");
        assertThat(output()[0]).isEqualTo("stack: 3");
        input("3 -");
        assertThat(output()[0]).isEqualTo("stack: 0");
        input("clear");
        assertThat(output()[0]).isEqualTo("stack: ");
    }

    @Test
    public void example4() {
        input("5 4 3 2");
        assertThat(output()[0]).isEqualTo("stack: 5 4 3 2");
        input("undo undo *");
        assertThat(output()[0]).isEqualTo("stack: 20");
        input("5 *");
        assertThat(output()[0]).isEqualTo("stack: 100");
        input("undo");
        assertThat(output()[0]).isEqualTo("stack: 20 5");
    }

    @Test
    public void example5() {
        input("7 12 2 /");
        assertThat(output()[0]).isEqualTo("stack: 7 6");
        input("*");
        assertThat(output()[0]).isEqualTo("stack: 42");
        input("4 /");
        assertThat(output()[0]).isEqualTo("stack: 10.5");
    }

    @Test
    public void example6() {
        input("1 2 3 4 5");
        assertThat(output()[0]).isEqualTo("stack: 1 2 3 4 5");
        input("*");
        assertThat(output()[0]).isEqualTo("stack: 1 2 3 20");
        input("clear 3 4 -");
        assertThat(output()[0]).isEqualTo("stack: -1");
    }

    @Test
    public void example7() {
        input("1 2 3 4 5");
        assertThat(output()[0]).isEqualTo("stack: 1 2 3 4 5");
        input("* * * *");
        assertThat(output()[0]).isEqualTo("stack: 120");
    }

    @Test
    public void example8() {
        input("1 2 3 * 5 + * * 6 5");
        String[] output = output();
        assertThat(output[0]).isEqualTo("operator * (position: 8): insufficient parameters");
        assertThat(output[1]).isEqualTo("stack: 11");
    }

    private void input(String line) {
        rpnApplication.evaluateLine(line);
    }

    private String[] output() {
        String[] lines = outContent.toString().split("\\r?\\n");
        outContent.reset();
        return lines;
    }
}