package org.ej1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    private Fibonacci fibonacci;

    @BeforeEach
    public void startup() {
        fibonacci = new Fibonacci();
    }

    @Test
    public void shouldThrowExceptionWhenValueIsNegative() {
        assertThrows(RuntimeException.class, () -> new Fibonacci().compute(-1));
    }

    @Test
    public void shouldReturnZeroIfValueIsZero() {
        int expectedValue = 0;
        int obtainedValue = fibonacci.compute(0);

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldReturnOneIfValueIsOne() {
        int expectedValue = 1;
        int obtainedValue = fibonacci.compute(1);

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldReturnThreeIfValueIsFour() {
        int expectedValue = 3;
        int obtainedValue = fibonacci.compute(4);

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldReturnTwentyOneIfValueIsEight() {
        int expectedValue = 21;
        int obtainedValue = fibonacci.compute(8);

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldReturnFiftyFiveIfValueIsTen() {
        int expectedValue = 55;
        int obtainedValue = fibonacci.compute(10);

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldReturnTwoHundredAndThirtyThreeIfValueIsThirteen() {
        int expectedValue = 233;
        int obtainedValue = fibonacci.compute(13);

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldReturnSixHundredAndTenIfValueIsFifteen() {
        int expectedValue = 610;
        int obtainedValue = fibonacci.compute(15);

        assertEquals(expectedValue, obtainedValue);
    }
}