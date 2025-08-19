package application.controller.application;

import application.config.SessionManager;
import application.exception.ValidationException;

import application.model.bean.User;
import application.model.dao.DAOFactory;
import application.model.dao.UserDAO;
import application.util.Formatter;
import application.util.PasswordCrypt;
import application.util.Validator;

public class LoginApplicationController {
	 private UserDAO userDAO;
	 private SessionManager sessionManager; // gestisce lo stato globale
	    
	 
	 public LoginApplicationController() {
		 this.userDAO = DAOFactory.getFactoryInstance().getUserDAO();
		 this.sessionManager = SessionManager.getInstance();
	 }

	public boolean authenticate(String email, String password) throws ValidationException {
		String formattedEmail = Formatter.removeBlanks(email.toLowerCase());
		String fomattedPassword = Formatter.removeBlanks(password);
		
		// Validazione dei dati
        if (!Validator.isValidEmail(formattedEmail)) {
        	throw new ValidationException("Invalid email format. Example: name@mail.com");
        }
		
		User user = userDAO.findByEmail(formattedEmail);
	
		if (!(user != null && PasswordCrypt.checkPassword(fomattedPassword, user.getPassword()))) {			
			throw new ValidationException("Invalid email or password");
		}
		
		sessionManager.setCurrentUser(user); // Memorizza l'utente nella "sessione"
        return true;
    }
	
	
	public String getUserRole() {
		return sessionManager.getCurrentUser().getRole().getDisplayName().toLowerCase();
	}
}
