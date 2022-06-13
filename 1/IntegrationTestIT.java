package org.mps.authentication;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class IntegrationTestIT {

    @Test
    public void happyUserRegistration() {
        UserRegistration userRegistration = new UserRegistration();
        Date date = Mockito.mock(Date.class);
        PasswordString passwordString = Mockito.mock(PasswordString.class);
        CredentialValidator credentialValidator = Mockito.mock(CredentialValidator.class);
        CredentialStore credentialStore = Mockito.mock(CredentialStore.class);

        Mockito.when(date.validate()).thenReturn(true);
        Mockito.when(passwordString.validate()).thenReturn(true);
        Mockito.when(credentialStore.credentialExists(date, passwordString)).thenReturn(false);
        Mockito.when(credentialValidator.validate()).thenReturn(CredentialValidator.ValidationStatus.VALIDATION_OK);

        userRegistration.register(date, passwordString, credentialStore, credentialValidator);

        Mockito.verify(credentialStore, Mockito.times(1)).register(date, passwordString);
    }

    @Test
    public void happyUserRegistrationWithRealCredentialValidator() {
        UserRegistration userRegistration = new UserRegistration();
        Date date = Mockito.mock(Date.class);
        PasswordString passwordString = Mockito.mock(PasswordString.class);
        CredentialStore credentialStore = Mockito.mock(CredentialStore.class);
        CredentialValidator credentialValidator = new CredentialValidator(date, passwordString, credentialStore);

        Mockito.when(date.validate()).thenReturn(true);
        Mockito.when(passwordString.validate()).thenReturn(true);
        Mockito.when(credentialStore.credentialExists(date, passwordString)).thenReturn(false);

        userRegistration.register(date, passwordString, credentialStore, credentialValidator);

        Mockito.verify(credentialStore, Mockito.times(1)).register(date, passwordString);


    }

    @Test
    public void happyUserRegistrationWithRealCredentialValidatorAndDate() {
        UserRegistration userRegistration = new UserRegistration();
        Date date = new Date(12, 12, 2039);
        PasswordString passwordString = Mockito.mock(PasswordString.class);
        CredentialStore credentialStore = Mockito.mock(CredentialStore.class);
        CredentialValidator credentialValidator = new CredentialValidator(date, passwordString, credentialStore);

        Mockito.when(passwordString.validate()).thenReturn(true);
        Mockito.when(credentialStore.credentialExists(date, passwordString)).thenReturn(false);

        userRegistration.register(date, passwordString, credentialStore, credentialValidator);

        Mockito.verify(credentialStore, Mockito.times(1)).register(date, passwordString);
    }

    @Test
    public void happyUserRegistrationWithRealCredentialValidatorAndPassword() {
        UserRegistration userRegistration = new UserRegistration();
        Date date = new Date(12, 12, 2039);
        PasswordString passwordString = new PasswordString("1234567890a.");
        CredentialStore credentialStore = Mockito.mock(CredentialStore.class);
        CredentialValidator credentialValidator = new CredentialValidator(date, passwordString, credentialStore);

        Mockito.when(credentialStore.credentialExists(date, passwordString)).thenReturn(false);

        userRegistration.register(date, passwordString, credentialStore, credentialValidator);

        Mockito.verify(credentialStore, Mockito.times(1)).register(date, passwordString);
    }

    @Test
    public void happyUserRegistrationWithRealCredentialValidatorAndCredentialStore() {
        UserRegistration userRegistration = new UserRegistration();
        Date date = new Date(2, 12, 2039);
        PasswordString passwordString = new PasswordString("1234567890a.");
        CredentialStore credentialStore = new CredentialStoreSet();
        CredentialValidator credentialValidator = new CredentialValidator(date, passwordString, credentialStore);

        userRegistration.register(date, passwordString, credentialStore, credentialValidator);

        assertEquals(credentialStore.size(), 1);
        assertTrue(credentialStore.credentialExists(date, passwordString));
    }


}