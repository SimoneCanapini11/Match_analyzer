package application.config;

import application.model.bean.User;

public class SessionManager {
		
		private static SessionManager instance; // L'uso di volatile garantisce che i thread vedano sempre la versione pi� aggiornata dell'istanza.

	    private User currentUser;

	    public static synchronized SessionManager getInstance() {
	        if (instance == null) {
	        	instance = new SessionManager();
	        }
	        return instance;
	    }

	    public User getCurrentUser() {
	        return currentUser;
	    }

	    public void setCurrentUser(User user) {
	        this.currentUser = user;
	    }
}
