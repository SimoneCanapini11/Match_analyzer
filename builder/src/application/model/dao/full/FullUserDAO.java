package application.model.dao.full;

import application.model.bean.User;
import application.model.dao.UserDAO;

public class FullUserDAO implements UserDAO{

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveUser(User user) {
		/*   // Hasha la password prima di salvare
        String hashedPassword = PasswordUtils.hashPassword(user.getPassword());
        user.setPassword(hashedPassword); 
		 */
		
		/* try {
		        // Codice per salvare l'utente nel database
		    } catch (SQLException e) {
		        throw new DAOException("Error saving user", e);
		    } */
	} 

}
