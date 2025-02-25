package application.model.dao.demo;

import application.model.bean.User;
import application.model.bean.Role;
import application.model.dao.UserDAO;
import java.util.HashMap;
import java.util.Map;

public class DemoUserDAO implements UserDAO {
    private Map<String, User> users = new HashMap<>();

    public DemoUserDAO() {
        // Inizializza utenti demo
    	users.put("simone.inzaghi@gmail.com", new User("simone.inzaghi@gmail.com", "Password2025!", "Simone", "Inzaghi", Role.COACH, "Inter"));
    	users.put("marco.rossi@gmail.com", new User("marco.rossi@gmail.com", "Password1!", "Marco", "Rossi", Role.TRAINER, "Inter"));

    	users.put("stefano.pioli@gmail.com", new User("stefano.pioli@gmail.com", "Password2025!", "Stefano", "Pioli", Role.COACH, "Milan"));
    	users.put("luca.bianchi@gmail.com", new User("luca.bianchi@gmail.com", "Password1!", "Luca", "Bianchi", Role.TRAINER, "Milan"));

    	users.put("massimiliano.allegri@gmail.com", new User("massimiliano.allegri@gmail.com", "Password2025!", "Massimiliano", "Allegri", Role.COACH, "Juventus"));
    	users.put("andrea.ferrari@gmail.com", new User("andrea.ferrari@gmail.com", "Password1!", "Andrea", "Ferrari", Role.TRAINER, "Juventus"));

    	users.put("jose.mourinho@gmail.com", new User("jose.mourinho@gmail.com", "Password2025!", "José", "Mourinho", Role.COACH, "Roma"));
    	users.put("giuseppe.verdi@gmail.com", new User("giuseppe.verdi@gmail.com", "Password1!", "Giuseppe", "Verdi", Role.TRAINER, "Roma"));

    	users.put("rudi.garcia@gmail.com", new User("rudi.garcia@gmail.com", "Password2025!", "Rudi", "Garcia", Role.COACH, "Napoli"));
    	users.put("francesco.russo@gmail.com", new User("francesco.russo@gmail.com", "Password1!", "Francesco", "Russo", Role.TRAINER, "Napoli"));

    	users.put("vincenzo.italiano@gmail.com", new User("vincenzo.italiano@gmail.com", "Password2025!", "Vincenzo", "Italiano", Role.COACH, "Fiorentina"));
    	users.put("alessandro.galli@gmail.com", new User("alessandro.galli@gmail.com", "Password1!", "Alessandro", "Galli", Role.TRAINER, "Fiorentina"));


    }

    @Override
    public User findByEmail(String email) {
        return users.get(email);
    }

	@Override
	public void saveUser(User user) {
		// La chiave è l'email
		users.put(user.getEmail(), user);
	
		/*
		Map<String, User> viewUsers = getAllUsers();	// -----------------------------Per debug
		System.out.println(viewUsers);					// -----------------------------Per debug
		*/
	}
    
	/*
    public Map<String, User> getAllUsers() {	// -----------------------------Per debug
        return users;
    }
    */
}
