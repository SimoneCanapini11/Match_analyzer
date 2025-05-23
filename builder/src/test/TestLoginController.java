package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import application.controller.application.LoginApplicationController;
import application.exception.ValidationException;


class TestLoginController {

    private LoginApplicationController loginController = new LoginApplicationController(); ;


    @Test
    void testAuthenticate_Success() throws ValidationException {
        // Verifica che l'autenticazione vada a buon fine
        assertTrue(loginController.authenticate("simone.inzaghi@gmail.com", "Password1!"));
    }

    @Test
    void testAuthenticate_WrongPassword() {
    	 // Verifica che venga lanciata una ValidationException per password errata
        Exception thrown = assertThrows(ValidationException.class, () -> {
            loginController.authenticate("simone.inzaghi@gmail.com", "WrongPassword1!"); 
        });

        // Verifica messaggio dell'eccezione
        assertEquals("Invalid email or password", thrown.getMessage());
    }
    

    @Test
    void testAuthenticate_NotValidEmailFormat() {
        // Verifica che l'autenticazione fallisca
    	Exception thrown = assertThrows(ValidationException.class, () -> {
    		loginController.authenticate("notvalidmail.com", "Password1!");
    	 });
    	
    	// Verifica messaggio dell'eccezione
        assertEquals("Invalid email format. Example: name@mail.com", thrown.getMessage());
    }
}
