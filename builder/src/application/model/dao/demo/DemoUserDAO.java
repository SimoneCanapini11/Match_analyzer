package application.model.dao.demo;

import application.model.bean.User;
import application.model.bean.RoleUser;
import application.model.dao.UserDAO;
import application.util.PasswordCrypt;

import java.util.HashMap;
import java.util.Map;

public class DemoUserDAO implements UserDAO {
    private Map<String, User> users = new HashMap<>();

    public DemoUserDAO() {
    	initializeUsers();
    }
    
    
    private void initializeUsers() {
    	// Inizializza utenti demo
    	users.put("simone.inzaghi@gmail.com", new User("simone.inzaghi@gmail.com", PasswordCrypt.hashPassword("Password1!"), "Simone", "Inzaghi", RoleUser.COACH, "Inter"));
    	users.put("marco.rossi@gmail.com", new User("marco.rossi@gmail.com", PasswordCrypt.hashPassword("Password2!"), "Marco", "Rossi", RoleUser.TRAINER, "Inter"));

    	users.put("stefano.pioli@gmail.com", new User("stefano.pioli@gmail.com", PasswordCrypt.hashPassword("Password3!"), "Stefano", "Pioli", RoleUser.COACH, "Milan"));
    	users.put("luca.bianchi@gmail.com", new User("luca.bianchi@gmail.com", PasswordCrypt.hashPassword("Password4!"), "Luca", "Bianchi", RoleUser.TRAINER, "Milan"));

    	users.put("massimiliano.allegri@gmail.com", new User("massimiliano.allegri@gmail.com", PasswordCrypt.hashPassword("Password5!"), "Massimiliano", "Allegri", RoleUser.COACH, "Juventus"));
    	users.put("andrea.ferrari@gmail.com", new User("andrea.ferrari@gmail.com", PasswordCrypt.hashPassword("Password6!"), "Andrea", "Ferrari", RoleUser.TRAINER, "Juventus"));

    }
    

    @Override
    public User findByEmail(String email) {
        return users.get(email);
    }

	@Override
	public void saveUser(User user) {
		// Salvataggio dell'utente
		users.put(user.getEmail(), user);
	}


	@Override
	public boolean isCoachAlreadyAssigned(String teamName) {
		for (User user : users.values()) {
	        if (user.getTeam().equalsIgnoreCase(teamName) && user.getRole() == RoleUser.COACH) {
	            return true;
	        }
	    }
		return false;
	}
    
}
