package com.github.bensmith87.rnp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
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

    private void input(String line) {
        rnpApplication.evaluateLine(line);
    }

    private String output() {
        return outContent.toString().trim();
    }
}