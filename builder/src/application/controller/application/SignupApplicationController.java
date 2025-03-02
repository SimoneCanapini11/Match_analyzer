package application.controller.application;

import application.util.Validator;
import application.model.bean.User;
import application.model.dao.DAOFactory;
import application.model.dao.UserDAO;
import application.util.Formatter;

import java.util.List;

import application.config.SessionManager;
import application.exception.DAOException;
import application.exception.ValidationException;
import application.model.bean.RoleUser;

public class SignupApplicationController {
	private UserDAO userDAO;
	private SessionManager sessionManager; // gestisce lo stato globale
		    
	public SignupApplicationController() {
		this.userDAO = DAOFactory.getUserDAO();
        this.sessionManager = SessionManager.getInstance();
	}

	public boolean register(String email, String password, String repPassword) throws ValidationException {
		
        if (!Validator.isValidEmail(email)) {
        	 throw new ValidationException("Invalid email format");
        }	
        String formattedEmail = Formatter.removeBlanks(email.toLowerCase());
                
        if (!Validator.isValidLenghtPassword(password)) {	
        	throw new ValidationException("Password must be at least 8 characters");
        }
        
        if (!Validator.isValidBlankPassword(password)) {	
        	throw new ValidationException("Password must not contain any blanks");
        }
        
        if (!Validator.isValidFormatPassword(password)) {	       
        	throw new ValidationException("The password must contain at least one uppercase letter, one lowercase letter, one special character and one number");
        }
        
        if (!password.equals(repPassword)) {
        	throw new ValidationException("The passwords do not match");
        }
        
        // Controlla se l'utente esiste già
        if (userDAO.findByEmail(formattedEmail) != null) {
        	throw new DAOException("The email is already in use");
        }
        
        // Controlli superati, inserisco email e password in newUser
        User newUser = new User();
        newUser.setEmail(formattedEmail);
        newUser.setPassword(password);  		//---------da salvare con Hash
        
        sessionManager.setCurrentUser(newUser); // Memorizza l'utente nella "sessione"
        
		return true;
	}
	
	
	public boolean confirm(String name, String surname, String roleStr, String team) throws ValidationException  {
		
		if (!Validator.isValidString(name) || !Validator.isValidFormatString(name)) {
			throw new ValidationException("Invalid name format");
		}
		String formattedName = Formatter.removeBlanks(name);		//----da rimuovere
		formattedName = Formatter.uppercaseString(formattedName);
		
		if (!Validator.isValidString(surname) || !Validator.isValidFormatString(surname)) {
			throw new ValidationException("Invalid surname format");
		}
		String formattedSurname = Formatter.removeBlanks(surname);
		formattedSurname = Formatter.uppercaseString(formattedSurname);
		
		if (!Validator.isValidString(roleStr)) {
			throw new ValidationException("You need to enter a role");
		}
		
		RoleUser role = RoleUser.fromString(roleStr);		//----------------se Role = Footballer -> controlli 'regole aziendali'
		
		if (!Validator.isValidString(team)) {
			throw new ValidationException("You need to enter a team");
		}
		
		//-------------controlli su: ruolo già preso (coach) per la squadra scelta*****************\\
		
		//System.out.println("Email: "+ newUser.getEmail());		//------------------per debug
		
        // Controlli superati, inserisco name, surname, role e team in newUser
		User newUser = sessionManager.getCurrentUser();
		newUser.setName(formattedName);
		newUser.setSurname(formattedSurname);
		newUser.setRole(role);
		newUser.setTeam(team);
		
		sessionManager.setCurrentUser(newUser); // Memorizza l'utente nella "sessione"'
									
		// Passa il nuovo utente al DAO per il salvataggio
        userDAO.saveUser(newUser);		

		return true;
	}
	
	
	public List<String> getRoles(){
		return RoleUser.getRoleDisplayNames();
	}
	
	
	public String getUserRole() {
		return sessionManager.getCurrentUser().getRole().getDisplayName().toLowerCase();
	}
}
