package application.model.dao.full;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.model.bean.RoleUser;
import application.model.bean.User;
import application.model.dao.full.queries.*;
import application.model.dao.UserDAO;

public class FullUserDAO implements UserDAO {
	
	private static final Logger LOGGER = Logger.getLogger(FullUserDAO.class.getName());

	@Override
	public User findByEmail(String email) {
		User user = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQLQueries.FIND_USER_BY_EMAIL)) {
             
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User(
                		rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        RoleUser.valueOf(rs.getString("role")),
                        rs.getString("team")
                );
            }
        } catch (SQLException se) {
        	LOGGER.log(Level.SEVERE, "Error finding user by email", se);
        }
        return user;
	}

	@Override
	public void saveUser(User user) {
		try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(SQLQueries.INSERT_USER)) {

	            stmt.setString(1, user.getEmail());
	            stmt.setString(2, user.getPassword()); 
	            stmt.setString(3, user.getName());
	            stmt.setString(4, user.getSurname());
	            stmt.setString(5, user.getRole().name());
	            stmt.setString(6, user.getTeam());

	            stmt.executeUpdate();
	            
		} catch (SQLException se) {
			LOGGER.log(Level.SEVERE, "Error saving user", se);
        }
	}

	@Override
	public boolean isCoachAlreadyAssigned(String teamName) {
		 boolean exists = false;
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(SQLQueries.CHECK_COACH_EXISTS)) {

	            stmt.setString(1, teamName);
	            ResultSet rs = stmt.executeQuery();

	            if (rs.next() && rs.getInt(1) > 0) {
	                exists = true;
	            }
	        } catch (SQLException se) {
	        	LOGGER.log(Level.SEVERE, "Error checking coach existence", se);
	        }
	        return exists;
	} 

}
