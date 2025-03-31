package application.model.dao.full;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
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
	
	private static final Logger logger = Logger.getLogger(FullMatchDAO.class.getName());
	
	private static final String HOME_TEAM = "home_team";
	private static final String AWAY_TEAM = "away_team";
	private static final String MATCH_DATE = "match_date";
	private static final String MATCH_TIME = "match_time";

	@Override
	public List<Match> getUpcomingMatches() {
		
		 List<Match> upcomingMatches = new ArrayList<>();
		 
		  try (Connection conn = DatabaseConnection.getConnection();
			         PreparedStatement stmt = conn.prepareStatement(SQLQueries.FIND_UPCOMING_MATCHES);
			         ResultSet rs = stmt.executeQuery()) {

			        while (rs.next()) {
			            Match match = new Match(
			                rs.getString(HOME_TEAM),
			                rs.getString(AWAY_TEAM),
			                rs.getDate(MATCH_DATE).toLocalDate(),
			                rs.getTime(MATCH_TIME).toLocalTime()
			            );
			            upcomingMatches.add(match);
			        }
		  } catch (SQLException se) {
			    logger.log(Level.SEVERE, "Error in getting upcoming matches", se);
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
		                    rs.getString(HOME_TEAM),
		                    rs.getString(AWAY_TEAM),
		                    rs.getDate(MATCH_DATE).toLocalDate(),
		                    rs.getTime(MATCH_TIME).toLocalTime()
		                );
		            }
		        }
		 } catch (SQLException se) {
			    logger.log(Level.SEVERE, "Error in getting next match", se);
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
		                    rs.getString(HOME_TEAM),
		                    rs.getString(AWAY_TEAM),
		                    rs.getDate(MATCH_DATE).toLocalDate(),
		                    rs.getTime(MATCH_TIME).toLocalTime()
		                );
		            	teamMatches.add(match);
		        }
		 } catch (SQLException se) {
			    logger.log(Level.SEVERE, "Error in getting matches by team", se);
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
			 logger.log(Level.SEVERE, "Error in saving match", se);
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
			 logger.log(Level.SEVERE, "Error in updating match", se);
		 }
	}

}
