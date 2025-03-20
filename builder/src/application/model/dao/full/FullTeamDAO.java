package application.model.dao.full;

import java.util.ArrayList;

import java.util.List;
import application.model.dao.full.queries.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import application.model.bean.Team;
import application.model.dao.TeamDAO;

public class FullTeamDAO implements TeamDAO {
	
	private static final String NAME_TEAM = "name_team";

	@Override
	public Team getTeamByName(String teamName) {
		Team team = null;
		try (Connection conn = DatabaseConnection.getConnection();
		         PreparedStatement stmt = conn.prepareStatement(SQLQueries.FIND_TEAM_BY_NAME)) {
		        
		        stmt.setString(1, teamName);
		        ResultSet rs = stmt.executeQuery();
		        
		        if (rs.next()) {
		            team = new Team(
		                rs.getString(NAME_TEAM),
		                rs.getString("stadium"),
		                rs.getString("city")
		            );
		        }
		 } catch (SQLException se) {
	            se.printStackTrace(); 
		 }
		return team; 
	}

	@Override
	public List<String> getOpponentList(String teamName) {
		List<String> opponents = new ArrayList<>();
		
		try (Connection conn = DatabaseConnection.getConnection();
		         PreparedStatement stmt = conn.prepareStatement(SQLQueries.OPPONENT_LIST)) {
			
			 	stmt.setString(1, teamName);
		        ResultSet rs = stmt.executeQuery();
		        
		        while (rs.next()) {
		            opponents.add(rs.getString(NAME_TEAM));
		        }
		 } catch (SQLException se) {
	            se.printStackTrace(); 
		 }
		return opponents;     
	}

	@Override
	public List<String> getTeamNameList() {
		 List<String> teamNames = new ArrayList<>();
		 
		 try (Connection conn = DatabaseConnection.getConnection();
		         PreparedStatement stmt = conn.prepareStatement(SQLQueries.TEAM_NAME_LIST)) {
			 
			 ResultSet rs = stmt.executeQuery();
			 
			 while (rs.next()) {
		            teamNames.add(rs.getString(NAME_TEAM));
			 }
		 } catch (SQLException se) {
	            se.printStackTrace(); 
		 }
		 return teamNames;
	}

}
