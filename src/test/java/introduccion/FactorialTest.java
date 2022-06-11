package introduccion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    private Factorial factorial;

    @BeforeEach
    public void startup() {
        factorial = new Factorial();
    }

    @Test
    public void shouldComputeOfZeroReturnOne() {
        int obtainedValue = factorial.compute(0);
        int expectedValue = 1;
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldComputeOfOneReturnOne() {
        int obtainedValue = factorial.compute(1);
        int expectedValue = 1;
        assertEquals(expectedValue, obtainedValue);
    }
}