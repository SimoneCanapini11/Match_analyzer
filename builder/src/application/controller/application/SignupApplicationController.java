package application.controller.application;

import application.util.Validator;
import application.model.bean.User;
import application.model.dao.DAOFactory;
import application.model.dao.TeamDAO;
import application.model.dao.UserDAO;
import application.util.Formatter;
import application.util.PasswordCrypt;

import java.util.List;

import application.config.SessionManager;
import application.exception.DAOException;
import application.exception.ValidationException;
import application.model.bean.RoleUser;

public class SignupApplicationController {
	private UserDAO userDAO;
	private SessionManager sessionManager; // gestisce lo stato globale
	private TeamDAO teamDAO;
		    
	public SignupApplicationController() {
		this.userDAO = DAOFactory.getUserDAO();
        this.sessionManager = SessionManager.getInstance();
        this.teamDAO = DAOFactory.getTeamDAO();
	}

	public boolean register(String email, String password, String repPassword) throws ValidationException {
		
        if (!Validator.isValidEmail(email)) {
        	 throw new ValidationException("Invalid email format");
        }	
        String formattedEmail = Formatter.removeBlanks(email.toLowerCase());
        String fomattedPassword = Formatter.removeBlanks(password);
        String formattedRepPassword = Formatter.removeBlanks(repPassword);
                
        if (!Validator.isValidLenghtPassword(fomattedPassword)) {	
        	throw new ValidationException("Password must be at least 8 characters");
        }
        
        if (!Validator.isValidBlankPassword(fomattedPassword)) {	
        	throw new ValidationException("Password must not contain any blanks");
        }
        
        if (!Validator.isValidFormatPassword(fomattedPassword)) {	       
        	throw new ValidationException("The password must contain at least one uppercase letter, one lowercase letter, one special character and one number");
        }
        
        if (!fomattedPassword.equals(formattedRepPassword)) {
        	throw new ValidationException("The passwords do not match");
        }
        
        // Controlla se l'utente esiste già
        if (userDAO.findByEmail(formattedEmail) != null) {
        	throw new DAOException("The email is already in use");
        }
        
        User newUser = new User();
        newUser.setEmail(formattedEmail);
        newUser.setPassword(PasswordCrypt.hashPassword(fomattedPassword));  		
        
        sessionManager.setCurrentUser(newUser); // Memorizza l'utente nella "sessione"
        
		return true;
	}
	
	
	public boolean confirm(String name, String surname, String roleStr, String team) throws ValidationException  {
		
		if (!Validator.isValidString(name) || !Validator.isValidFormatString(name)) {
			throw new ValidationException("Invalid name format");
		}
		String formattedName = Formatter.removeBlanks(name);		
		formattedName = Formatter.uppercaseString(formattedName);
		
		if (!Validator.isValidString(surname) || !Validator.isValidFormatString(surname)) {
			throw new ValidationException("Invalid surname format");
		}
		String formattedSurname = Formatter.removeBlanks(surname);
		formattedSurname = Formatter.uppercaseString(formattedSurname);
		
		if (!Validator.isValidString(roleStr)) {
			throw new ValidationException("You need to enter a role");
		}
		
		RoleUser role = RoleUser.fromString(roleStr);		
		
		if (!Validator.isValidString(team)) {
			throw new ValidationException("You need to enter a team");
		}
		
		
		if ("COACH".equalsIgnoreCase(roleStr) && userDAO.isCoachAlreadyAssigned(team)) {
			throw new DAOException("The team already has a coach assigned!");
		}
		
        // Controlli superati, inserisco name, surname, role e team in newUser
		User newUser = sessionManager.getCurrentUser();
		newUser.setName(formattedName);
		newUser.setSurname(formattedSurname);
		newUser.setRole(role);
		newUser.setTeam(team);
		
		sessionManager.setCurrentUser(newUser); 
									
        userDAO.saveUser(newUser);		

		return true;
	}
	
	
	public List<String> getRoles(){
		return RoleUser.getRoleDisplayNames();
	}
	
	public String getUserRole() {
		return sessionManager.getCurrentUser().getRole().getDisplayName().toLowerCase();
	}
	
	public List<String> getTeamNames() {
        return teamDAO.getTeamNameList();
    }
}
