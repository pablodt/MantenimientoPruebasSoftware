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
        assertThrows(RuntimeException.class, () -> triangle.getType(1, 0, 2));
    }

    @Test
    public void shouldThrowRuntimeExceptionWhenOneSideHasNegativeLength() {
        assertThrows(RuntimeException.class, () -> triangle.getType(2, 3, -1));
    }

    @Test
    public void shouldThrowRuntimeExceptionWhenSide1PlusSide2IsLowerOrEqualToSide3() {
        assertThrows(RuntimeException.class, () -> triangle.getType(2, 1, 5));
    }

    @Test
    public void shouldThrowRuntimeExceptionWhenSide1PlusSide3IsLowerOrEqualToSide2() {
        assertThrows(RuntimeException.class, () -> triangle.getType(2, 5, 1));
    }

    @Test
    public void shouldThrowRuntimeExceptionWhenSide2PlusSide3IsLowerOrEqualToSide1() {
        assertThrows(RuntimeException.class, () -> triangle.getType(5, 2, 1));
    }

    @Test
    public void shouldReturnEquilateralWhenAllSidesHaveSameLength() {
        assertEquals(Triangle.TriangleType.EQUILATERAL, triangle.getType(10, 10, 10));
    }

    @Test
    public void shouldReturnIsoscelesWhenSide1AndSide2AreEqualButSide3HasDifferentLength() {
        assertEquals(Triangle.TriangleType.ISOSCELES, triangle.getType(10, 10, 8));
    }

    @Test
    public void shouldReturnIsoscelesWhenSide2AndSide3AreEqualButSide1HasDifferentLength() {
        assertEquals(Triangle.TriangleType.ISOSCELES, triangle.getType(8, 10, 10));
    }

    @Test
    public void shouldReturnIsoscelesWhenSide1AndSide3AreEqualButSide2HasDifferentLength() {
        assertEquals(Triangle.TriangleType.ISOSCELES, triangle.getType(8, 10, 8));
    }

    @Test
    public void shouldReturnScaleneWhenAllSidesAreDifferent() {
        assertEquals(Triangle.TriangleType.SCALENE, triangle.getType(8, 9, 10));
    }

}