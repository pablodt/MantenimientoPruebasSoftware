package practicas.pr1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    private Triangle triangle;

    @BeforeEach
    public void startUp() {
        triangle = new Triangle();
    }

    @Test
    public void shouldThrowRuntimeExceptionWhenOneSideHasLengthZero() {

    }

    @Test
    public void shouldThrowRuntimeExceptionWhenOneSideHasNegativeLength() {

    }

}