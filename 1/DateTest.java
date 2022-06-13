import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    private Date date;

    @Test
    public void yearBetween1900And2050ShouldBeValid() {
        date = new Date(17, 5, 2022);
        assertTrue(date.validate());
    }

    @Test
    public void yearBefore1900shouldNotBeValid() {
        date = new Date(17, 5, 1800);
        assertFalse(date.validate());
    }

    @Test
    public void yearAfter2050shouldNotBeValid() {
        date = new Date(17, 5, 2100);
        assertFalse(date.validate());
    }

    @Test
    public void monthBetween1And12ShouldBeValid() {
        date = new Date(17, 6, 2022);
        assertTrue(date.validate());
    }

    @Test
    public void monthLowerThan1shouldNotBeValid() {
        date = new Date(17, -5, 2022);
        assertFalse(date.validate());
    }

    @Test
    public void yearBiggerThan12shouldNotBeValid() {
        date = new Date(17, 15, 2022);
        assertFalse(date.validate());
    }

    @Test
    public void dayBetween1And31InAMonthWith31DaysShouldBeValid() {
        date = new Date(20, 3, 2022);
        assertTrue(date.validate());
    }

    @Test
    public void dayLowerThan1InAMonthWith31DaysShouldNotBeValid() {
        date = new Date(0, 3, 2022);
        assertFalse(date.validate());
    }

    @Test
    public void dayBiggerThan31InAMonthWith31DaysShouldNotBeValid() {
        date = new Date(35, 3, 2022);
        assertFalse(date.validate());
    }

    @Test
    public void dayEqualTo31InAMonthWith31DaysShouldBeValid() {
        date = new Date(31, 3, 2022);
        assertTrue(date.validate());
    }

    @Test
    public void dayBetween1And30InAMonthWith30DaysShouldBeValid() {
        date = new Date(20, 4, 2022);
        assertTrue(date.validate());
    }

    @Test
    public void dayLowerThan1InAMonthWith30DaysShouldNotBeValid() {
        date = new Date(0, 4, 2022);
        assertFalse(date.validate());
    }

    @Test
    public void dayBiggerThan30InAMonthWith30DaysShouldNotBeValid() {
        date = new Date(31, 4, 2022);
        assertFalse(date.validate());
    }

    @Test
    public void dayEqualTo30InAMonthWith30DaysShouldBeValid() {
        date = new Date(30, 4, 2022);
        assertTrue(date.validate());
    }

    @Test
    public void dayBetween1And28InAMonthWith28DaysShouldBeValid() {
        date = new Date(20, 2, 2022);
        assertTrue(date.validate());
    }

    @Test
    public void dayLowerThan1InAMonthWith28DaysShouldNotBeValid() {
        date = new Date(0, 2, 2022);
        assertFalse(date.validate());
    }

    @Test
    public void dayBiggerThan28InAMonthWith28DaysShouldNotBeValid() {
        date = new Date(29, 2, 2022);
        assertFalse(date.validate());
    }

    @Test
    public void dayEqualTo28InAMonthWith28DaysShouldBeValid() {
        date = new Date(28, 2, 2022);
        assertTrue(date.validate());
    }

    @Test
    public void dayBetween1And29InMonth2InALeapYearShouldBeValid() {
        date = new Date(20, 2, 2020);
        assertTrue(date.validate());
    }

    @Test
    public void dayLowerThan1InMonth2InALeapYearShouldNotBeValid() {
        date = new Date(0, 2, 2020);
        assertFalse(date.validate());
    }

    @Test
    public void dayBiggerThan29InMonth2InALeapYearShouldNotBeValid() {
        date = new Date(30, 2, 2020);
        assertFalse(date.validate());
    }

    @Test
    public void dayEqualTo29InMonth2InALeapYearShouldBeValid() {
        date = new Date(29, 2, 2020);
        assertTrue(date.validate());
    }

}