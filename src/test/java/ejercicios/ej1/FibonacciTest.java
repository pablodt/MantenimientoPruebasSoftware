package ejercicios.ej1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    private Fibonacci fibonacci;

    @BeforeEach
    public void startUp() {
        fibonacci = new Fibonacci();
    }

    @Test
    public void shouldReturnZeroWhenNumberIsZero() {
        assertEquals(0, fibonacci.compute(0));
    }

    @Test
    public void shouldReturnOneWhenNumberIsOne() {
        assertEquals(1, fibonacci.compute(1));
    }

    @Test
    public void shouldReturnOneWhenNumberIsTwo() {
        assertEquals(1, fibonacci.compute(2));
    }

    @Test
    public void shouldReturnTwoWhenNumberIsThree() {
        assertEquals(2, fibonacci.compute(3));
    }

    @Test
    public void shouldReturnThreeWhenNumberIsFour() {
        assertEquals(3, fibonacci.compute(4));
    }

    @Test
    public void shouldReturnFiveWhenNumberIsFive() {
        assertEquals(5, fibonacci.compute(5));
    }

    @Test
    public void shouldReturnEightWhenNumberIsSix() {
        assertEquals(8, fibonacci.compute(6));
    }

    @Test
    public void shouldReturnNegativeWhenNumberIsNegative() {
        assertTrue(fibonacci.compute(-10) < 0);
    }

}