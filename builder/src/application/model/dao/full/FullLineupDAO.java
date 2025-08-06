package application.model.dao.full;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import application.exception.DAOException;
import application.model.bean.Footballer;
import application.model.bean.FootballerAttributes;
import application.model.bean.Lineup;
import application.model.dao.LineupDAO;
import application.model.dao.full.queries.SQLQueries;
import application.model.enums.RoleFootballer;

public class FullLineupDAO implements LineupDAO {

	@Override
	public Lineup fetchFormationByTeam(String nameTeam) {
		
		Lineup lineup = null;
		
		try (Connection conn = DatabaseConnection.getConnection();
		         PreparedStatement stmtLineup = conn.prepareStatement(SQLQueries.FIND_LINEUP_BY_TEAM);
		         PreparedStatement stmtPlayers = conn.prepareStatement(SQLQueries.STARTING_LINEUP)) {

		        stmtLineup.setString(1, nameTeam);
		        ResultSet rsLineup = stmtLineup.executeQuery();

		        if (rsLineup.next()) {
		            int lineupId = rsLineup.getInt("id");
		            String formation = rsLineup.getString("formation");
		            String playStyle = rsLineup.getString("play_style");
		            String markingType = rsLineup.getString("marking_type");
		            
		            Map<String, Footballer> playersMap = new LinkedHashMap<>();
		            
		            stmtPlayers.setInt(1, lineupId);
		            ResultSet rsPlayers = stmtPlayers.executeQuery();

		            while (rsPlayers.next()) {
		            	String name = rsPlayers.getString("name");
		                String surname = rsPlayers.getString("surname");
		                String key = name + surname;
		                
		                if (!playersMap.containsKey(key)) {
		                	FootballerAttributes attributes = new FootballerAttributes(
		                			rsPlayers.getInt("overall_rating"),
		                			rsPlayers.getInt("physical_form"),
		                			rsPlayers.getInt("mental_clarity"),
		                			rsPlayers.getInt("deployable")
		                	);

		                	Footballer player = new Footballer(
		                			name,
		                			surname,
		                			rsPlayers.getString("team"),
		                			rsPlayers.getDate("dob").toLocalDate(),
		                			attributes
		                	);
		                	
		                	 playersMap.put(key, player);
		                }
		                
		                String roleStr = rsPlayers.getString("role");
		                if (roleStr != null) {
		                    RoleFootballer role = RoleFootballer.valueOf(roleStr);
		                    playersMap.get(key).addRoleAffinity(role, rsPlayers.getDouble("affinity"));
		                }
		            }

		            lineup = new Lineup(nameTeam, formation, playStyle, markingType, new ArrayList<>(playersMap.values()));
		        }
		    } catch (SQLException se) {
		    	throw new DAOException("Error in finding the Lineup");
		    }
		
		if (lineup == null) {
			throw new DAOException("Lineup details not found");
		}

		return lineup;
	}
	
	
	@Override
	public void updateTactics(Lineup lineup) {
		
		 try (Connection conn = DatabaseConnection.getConnection();
		         PreparedStatement stmtUpdateLineup = conn.prepareStatement(SQLQueries.UPDATE_LINEUP);
		         PreparedStatement stmtGetLineupId = conn.prepareStatement(SQLQueries.FIND_LINEUP_ID);
		         PreparedStatement stmtDeletePlayers = conn.prepareStatement(SQLQueries.DELETE_LINEUP_PLAYERS);
		         PreparedStatement stmtGetFootballerId = conn.prepareStatement(SQLQueries.FIND_FOOTBALLER_ID); 
		 		 PreparedStatement stmtInsertPlayer = conn.prepareStatement(SQLQueries.INSERT_LINEUP_PLAYERS);
				 PreparedStatement stmtGetFootballerIds = conn.prepareStatement(SQLQueries.getLineupFootballersId())) {
			 
		        conn.setAutoCommit(false); // Avvia la transazione

		        // Aggiorna la tabella lineups
		        stmtUpdateLineup.setString(1, lineup.getFormation());
		        stmtUpdateLineup.setString(2, lineup.getPlayStyle());
		        stmtUpdateLineup.setString(3, lineup.getMarkingType());
		        stmtUpdateLineup.setString(4, lineup.getTeamName());
		        stmtUpdateLineup.executeUpdate();

		        // ID lineup
		        stmtGetLineupId.setString(1, lineup.getTeamName());
		        ResultSet rsLineupId = stmtGetLineupId.executeQuery();
		        if (!rsLineupId.next()) {
		            throw new DAOException("Lineup not found for team: " + lineup.getTeamName());
		        }
		        int lineupId = rsLineupId.getInt("id");

		        // Elimina i footballers della lineup precedente
		        stmtDeletePlayers.setInt(1, lineupId);
		        stmtDeletePlayers.executeUpdate();

		        
		        // Footballer in Lineup
		        List<Footballer> allPlayers = lineup.getStartingLineup();
		        

		        int paramIndex = 1;
		        for (Footballer player : allPlayers) {
		            stmtGetFootballerIds.setString(paramIndex++, player.getName());
		            stmtGetFootballerIds.setString(paramIndex++, player.getSurname());
		            stmtGetFootballerIds.setString(paramIndex++, player.getTeam());
		        }

		        ResultSet rsFootballersId = stmtGetFootballerIds.executeQuery();

		        // Crea una mappa (nome, cognome, squadra) -> id
		        Map<String, Integer> footballerIdMap = new HashMap<>();
		        while (rsFootballersId.next()) {
		            String key = rsFootballersId.getString("name") + "|"
		                       + rsFootballersId.getString("surname") + "|"
		                       + rsFootballersId.getString("team");
		            footballerIdMap.put(key, rsFootballersId.getInt("id"));
		        }

		        stmtInsertPlayer.setInt(1, lineupId);
		        
		        int position = 1;
		        for (Footballer player : allPlayers) {
		            String key = player.getName() + "|" + player.getSurname() + "|" + player.getTeam();
		            Integer footballerId = footballerIdMap.get(key);
		            
		            if (footballerId == null) {
		                throw new DAOException("Footballer not found: " + player.getName() + " " + player.getSurname());
		            }
		            
		            stmtInsertPlayer.setInt(2, footballerId);
		            stmtInsertPlayer.setInt(3, position++);
		            stmtInsertPlayer.addBatch();
		        }

		        stmtInsertPlayer.executeBatch();

		        conn.commit(); // Conferma la transazione
		        
		    } catch (SQLException se) {
		    	throw new DAOException("Error in updating tactics");
		    }
	}

}
