package application.model.dao.full;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import application.model.bean.Match;
import application.model.dao.MatchDAO;
import application.model.dao.full.queries.SQLQueries;

public class FullMatchDAO implements MatchDAO {

	@Override
	public List<Match> getUpcomingMatches() {
		
		 List<Match> upcomingMatches = new ArrayList<>();
		 
		  try (Connection conn = DatabaseConnection.getConnection();
			         PreparedStatement stmt = conn.prepareStatement(SQLQueries.FIND_UPCOMING_MATCHES);
			         ResultSet rs = stmt.executeQuery()) {

			        while (rs.next()) {
			            Match match = new Match(
			                rs.getString("home_team"),
			                rs.getString("away_team"),
			                rs.getDate("match_date").toLocalDate(),
			                rs.getTime("match_time").toLocalTime()
			            );
			            upcomingMatches.add(match);
			        }
		  } catch (SQLException se) {
		        se.printStackTrace();
		  } catch (IOException ie) {
				ie.printStackTrace();
		  }
		  return upcomingMatches;
	}
	

	@Override
	public Match getNextMatch(String nameTeam) {
		
		Match nextMatch = null;
		
		 try (Connection conn = DatabaseConnection.getConnection();
		        PreparedStatement stmt = conn.prepareStatement(SQLQueries.FIND_NEXT_MATCH)) {
		        
		        stmt.setString(1, nameTeam);
		        stmt.setString(2, nameTeam);

		        try (ResultSet rs = stmt.executeQuery()) {
		            if (rs.next()) {
		                nextMatch = new Match(
		                    rs.getString("home_team"),
		                    rs.getString("away_team"),
		                    rs.getDate("match_date").toLocalDate(),
		                    rs.getTime("match_time").toLocalTime()
		                );
		            }
		        }
		 } catch (SQLException se) {
		        se.printStackTrace();
		 } catch (IOException ie) {
				ie.printStackTrace();
		 }
		 return nextMatch;		 
	}

	
	@Override
	public List<Match> getMatchesByTeam(String teamName) {

		List<Match> teamMatches = new ArrayList<>();
		
		 try (Connection conn = DatabaseConnection.getConnection();
		         PreparedStatement stmt = conn.prepareStatement(SQLQueries.FIND_MATCHES_BY_TEAM)) {
		        
		        stmt.setString(1, teamName);
		        stmt.setString(2, teamName);
		        ResultSet rs = stmt.executeQuery();

		        while (rs.next()) {
		            	Match match = new Match(
		                    rs.getString("home_team"),
		                    rs.getString("away_team"),
		                    rs.getDate("match_date").toLocalDate(),
		                    rs.getTime("match_time").toLocalTime()
		                );
		            	teamMatches.add(match);
		        }
		 } catch (SQLException se) {
		        se.printStackTrace();
		 } catch (IOException ie) {
				ie.printStackTrace();
		 }
		return teamMatches;
	}

	
	@Override
	public void saveMatch(Match match) {
		
		 try (Connection conn = DatabaseConnection.getConnection();
		         PreparedStatement stmt = conn.prepareStatement(SQLQueries.SAVE_MATCH)) {

		        stmt.setString(1, match.getHomeTeam());
		        stmt.setString(2, match.getAwayTeam());
		        stmt.setDate(3, Date.valueOf(match.getMatchDate())); 
		        stmt.setTime(4, Time.valueOf(match.getMatchTime())); 

		        stmt.executeUpdate();
		        
		 } catch (SQLException se) {
		        se.printStackTrace();
		 } catch (IOException ie) {
				ie.printStackTrace();
		 }
	}

	
	@Override
	public void updateMatch(Match match, String teamName) {
		
		try (Connection conn = DatabaseConnection.getConnection();
		         PreparedStatement stmt = conn.prepareStatement(SQLQueries.UPDATE_MATCH)) {

		        stmt.setTime(1, Time.valueOf(match.getMatchTime())); 
		        stmt.setString(2, match.getHomeTeam());
		        stmt.setString(3, match.getAwayTeam());
		        stmt.setDate(4, Date.valueOf(match.getMatchDate())); 
		        stmt.setString(5, teamName);
		        stmt.setString(6, teamName);

		        stmt.executeUpdate();
		        
		 } catch (SQLException se) {
		        se.printStackTrace();
		 } catch (IOException ie) {
				ie.printStackTrace();
		 }
	}

}
