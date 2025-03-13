package application.config;

import java.util.HashMap;
import java.util.Map;
import java.util.prefs.Preferences;

import application.model.bean.User;

public class SessionManager {
		
		private static SessionManager instance; 

	    private User currentUser;
	    private static Map<String, Boolean> matchScheduledMap = new HashMap<>();
	    
	    // Preferences per salvare e caricare la mappa
	    private static final Preferences prefs = Preferences.userNodeForPackage(SessionManager.class);

	    // Chiave base per salvare i dati della mappa
	    private static final String MATCH_SCHEDULED_KEY_PREFIX = "matchScheduled_";
	    
	    private SessionManager() {}

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
	    
	    public boolean isMatchScheduled(String team) {
	        // Restituisce true se per il team c'è un match programmato; altrimenti false
	       // return matchScheduledMap.getOrDefault(team, true);
	    	
	    	// Prima controlla la mappa in memoria, se non presente prova a caricarla dalle preferenze
	        if (matchScheduledMap.containsKey(team)) {
	            return matchScheduledMap.get(team);
	        } else {
	            // Recupera il valore dal Preferences, usando "true" come default se non esiste
	            boolean value = Boolean.parseBoolean(prefs.get(MATCH_SCHEDULED_KEY_PREFIX + team, "true"));
	            matchScheduledMap.put(team, value);
	            return value;
	        }
	    }

	    public void setMatchScheduled(String team, boolean scheduled) {
	        matchScheduledMap.put(team, scheduled);
	     // Salva la preferenza (converte il boolean in stringa)
	        prefs.put(MATCH_SCHEDULED_KEY_PREFIX + team, String.valueOf(scheduled));
	    }
}
