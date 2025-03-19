package application.model.dao.full;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import application.model.bean.Footballer;
import application.model.bean.FootballerAttributes;
import application.model.bean.RoleFootballer;
import application.model.dao.FootballerDAO;
import application.model.dao.full.queries.SQLQueries;

public class FullFootballerDAO implements FootballerDAO  {

	@Override
	public List<Footballer> getFootballersByTeam(String teamName) {
		
		 List<Footballer> footballers = new ArrayList<>();
		 Map<Integer, Footballer> footballerMap = new HashMap<>();
		 
		  try (Connection conn = DatabaseConnection.getConnection();
		             PreparedStatement stmt = conn.prepareStatement(SQLQueries.TEAM_FOOTBALLERS_LIST)) {
		             
		            stmt.setString(1, teamName);
		            ResultSet rs = stmt.executeQuery();

		            while (rs.next()) {
		                int id = rs.getInt("id");
		                String name = rs.getString("name");
		                String surname = rs.getString("surname");

		                FootballerAttributes attributes = new FootballerAttributes(
		                    rs.getInt("overall_rating"),
		                    rs.getInt("physical_form"),
		                    rs.getInt("mental_clarity"),
		                    rs.getInt("deployable")
		                );

		                Footballer footballer = new Footballer(
		                    name, surname, teamName,
		                    rs.getDate("dob").toLocalDate(),
		                    attributes
		                );

		                footballers.add(footballer);
		                footballerMap.put(id, footballer); 
		            }
		        } catch (SQLException se) {
		            se.printStackTrace();
		        } catch (IOException ie) {
					ie.printStackTrace();
		        }      
		  
		  try (Connection conn = DatabaseConnection.getConnection();
		             PreparedStatement stmt = conn.prepareStatement(SQLQueries.FOOTBALLER_ROLE_AFFINITIES)) {
		             
		            stmt.setString(1, teamName);
		            ResultSet rs = stmt.executeQuery();

		            while (rs.next()) {
		                int footballerId = rs.getInt("footballer_id");
		                String role = rs.getString("role");
		                double affinity = rs.getDouble("affinity");

		                Footballer footballer = footballerMap.get(footballerId);
		                if (footballer != null) {
		                    footballer.addRoleAffinity(RoleFootballer.fromString(role), affinity);
		                }
		            }
		  } catch (SQLException se) {
	            se.printStackTrace();
		  } catch (IOException ie) {
				ie.printStackTrace();
		  } 
		  
		  return footballers;
	}
	

}
