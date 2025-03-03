package application.config;

import application.model.bean.User;

public class SessionManager {
		
		private static SessionManager instance; // L'uso di volatile garantisce che i thread vedano sempre la versione più aggiornata dell'istanza.

	    private User currentUser;

	    public static SessionManager getInstance() {
	        if (instance == null) {
	        	synchronized (SessionManager.class) {
                    if (instance == null) {
                        instance = new SessionManager();
                    }
                }
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
