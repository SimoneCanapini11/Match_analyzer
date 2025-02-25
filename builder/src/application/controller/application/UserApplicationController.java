package application.controller.application;

import application.config.SessionManager;

public class UserApplicationController {
	private SessionManager sessionManager; // gestisce lo stato globale
	
	public UserApplicationController() {
        this.sessionManager = SessionManager.getInstance();
    }
	
	
	public void signOut() {
        // Svuota la sessione
        sessionManager.setCurrentUser(null);
	}
	
	
    public String getUserName() {
        return sessionManager.getCurrentUser().getName();
    }
    
    public String getUserSurname() {
        return sessionManager.getCurrentUser().getSurname();
    }
    
	public String getUserTeam() {
		return sessionManager.getCurrentUser().getTeam().toLowerCase();
	}
}
