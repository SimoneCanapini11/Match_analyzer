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
		
		/* try {
		        // Codice per salvare l'utente nel database
		    } catch (SQLException e) {
		        throw new DAOException("Error saving user", e);
		    } */
	}

	@Override
	public boolean isCoachAlreadyAssigned(String teamName) {
		/*
		  String query = "SELECT COUNT(*) FROM users WHERE team_name = ? AND role = 'COACH'";
    
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setString(1, teamName);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0; // Se il numero è maggiore di 0, c'è già un coach
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } 
		 */
		return false;
	} 

}
