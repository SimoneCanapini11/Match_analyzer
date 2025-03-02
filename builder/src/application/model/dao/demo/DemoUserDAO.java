package application.model.dao.demo;

import application.model.bean.User;
import application.model.bean.RoleUser;
import application.model.dao.UserDAO;
import java.util.HashMap;
import java.util.Map;

public class DemoUserDAO implements UserDAO {
    private Map<String, User> users = new HashMap<>();

    public DemoUserDAO() {
        // Inizializza utenti demo
    	users.put("simone.inzaghi@gmail.com", new User("simone.inzaghi@gmail.com", "Password1!", "Simone", "Inzaghi", RoleUser.COACH, "Inter"));
    	users.put("marco.rossi@gmail.com", new User("marco.rossi@gmail.com", "Password2!", "Marco", "Rossi", RoleUser.TRAINER, "Inter"));

    	users.put("stefano.pioli@gmail.com", new User("stefano.pioli@gmail.com", "Password3!", "Stefano", "Pioli", RoleUser.COACH, "Milan"));
    	users.put("luca.bianchi@gmail.com", new User("luca.bianchi@gmail.com", "Password4!", "Luca", "Bianchi", RoleUser.TRAINER, "Milan"));

    	users.put("massimiliano.allegri@gmail.com", new User("massimiliano.allegri@gmail.com", "Password5!", "Massimiliano", "Allegri", RoleUser.COACH, "Juventus"));
    	users.put("andrea.ferrari@gmail.com", new User("andrea.ferrari@gmail.com", "Password6!", "Andrea", "Ferrari", RoleUser.TRAINER, "Juventus"));

    	users.put("jose.mourinho@gmail.com", new User("jose.mourinho@gmail.com", "Password7!", "Jos�", "Mourinho", RoleUser.COACH, "Roma"));
    	users.put("giuseppe.verdi@gmail.com", new User("giuseppe.verdi@gmail.com", "Password8!", "Giuseppe", "Verdi", RoleUser.TRAINER, "Roma"));

    	users.put("rudi.garcia@gmail.com", new User("rudi.garcia@gmail.com", "Password9!", "Rudi", "Garcia", RoleUser.COACH, "Napoli"));
    	users.put("francesco.russo@gmail.com", new User("francesco.russo@gmail.com", "Password10!", "Francesco", "Russo", RoleUser.TRAINER, "Napoli"));

    	users.put("vincenzo.italiano@gmail.com", new User("vincenzo.italiano@gmail.com", "Password11!", "Vincenzo", "Italiano", RoleUser.COACH, "Fiorentina"));
    	users.put("alessandro.galli@gmail.com", new User("alessandro.galli@gmail.com", "Password12!", "Alessandro", "Galli", RoleUser.TRAINER, "Fiorentina"));


    }

    @Override
    public User findByEmail(String email) {
        return users.get(email);
    }

	@Override
	public void saveUser(User user) {
		// La chiave � l'email
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
