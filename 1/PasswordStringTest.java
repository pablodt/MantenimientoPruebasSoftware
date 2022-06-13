import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordStringTest {

    private PasswordString passwordString;

    @Test
    public void passwordLengthBetween8And20ShouldBeValid() {
        passwordString = new PasswordString("12345678.a");
        assertTrue(passwordString.validate());
    }

    @Test
    public void passwordLengthShorterThan8ShouldNotBeValid() {
        passwordString = new PasswordString("12678.a");
        assertFalse(passwordString.validate());
    }

    @Test
    public void passwordLengthBiggerThan20ShouldNotBeValid() {
        passwordString = new PasswordString("123456789101112131415.a");
        assertFalse(passwordString.validate());
    }

    @Test
    public void passwordWithSomeSpecialCharactersShouldBeValid() {
        passwordString = new PasswordString("abcdefg..:/2");
        assertTrue(passwordString.validate());
    }

    @Test
    public void passwordWithoutAnySpecialCharacterShouldNotBeValid() {
        passwordString = new PasswordString("abcdefghi2");
        assertFalse(passwordString.validate());
    }

    @Test
    public void passwordWithSomeNumbersShouldBeValid() {
        passwordString = new PasswordString("1234abcdefg:");
        assertTrue(passwordString.validate());
    }

    @Test
    public void passwordWithoutAnyNumberShouldNotBeValid() {
        passwordString = new PasswordString("abcdefghijk.:/");
        assertFalse(passwordString.validate());
    }

}