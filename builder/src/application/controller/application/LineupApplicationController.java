package application.controller.application;

import java.util.List;

import java.util.stream.Collectors;

import application.model.bean.Footballer;
import application.model.bean.Lineup;
import application.model.bean.RoleFootballer;
import application.model.dao.DAOFactory;
import application.model.dao.FootballerDAO;
import application.model.dao.LineupDAO;
import application.util.Formatter;

public class LineupApplicationController {
	private FootballerDAO footballerDAO;
	//private TeamDAO teamDAO;
	private LineupDAO lineupDAO;

	public LineupApplicationController() {
        this.footballerDAO = DAOFactory.getFootballerDAO();
      //  this.teamDAO = DAOFactory.getTeamDAO();
        this.lineupDAO = DAOFactory.getLineupDAO();
    }
	
	/*
	public List<Footballer> getFootballersList(String teamName) {
		return footballerDAO.getFootballersByTeam(teamName);
	}
	*/
	
	public List<String> getFootballersByRole(String teamName, String role) {
		// Ottieni tutti i giocatori della squadra
		List<Footballer> players = footballerDAO.getFootballersByTeam(teamName);
				 
		// Converte la sigla in un valore enum
		RoleFootballer requiredRole = RoleFootballer.valueOf(role.toUpperCase());

		// Filtra i giocatori che hanno un'affinità per il ruolo richiesto 
		List<Footballer> filteredPlayers = players.stream()
				.filter(player -> player.getRoleAffinities().stream()
						.anyMatch(ra -> ra.getRole() == requiredRole && ra.getAffinity() > 0))	// valore minimo di affinita
				.collect(Collectors.toList());
		
		// Ritorna la lista dei nomi e cognomi dei giocatori trovati
		return filteredPlayers.stream()
			    .map(f -> f.getName() + " " + f.getSurname())
			    .collect(Collectors.toList());
	}
	
	
	public boolean saveLineup(String teamName, String formation, String playStyle, String marking, List<String> startingLineup) {
		
		Lineup newLineup = lineupDAO.getFormationByTeam(teamName);
		
       /* if (newLineup == null) {
        	throw new IllegalArgumentException("Team not found");
        }*/
			
        newLineup.setFormation(formation);
        newLineup.setPlayStyle(playStyle);
        newLineup.setMarking(marking);
        newLineup.setStartingLineup(startingLineup);
        
        lineupDAO.updateTactics(newLineup);
        
		return true;
	}
	
	
	public String splitSurname(String playerName) {	
		// Dividi il nome del giocatore in nome e cognome separandolo dal primo spazio
		return Formatter.splitString(playerName);
	}
	
	
	public String getFormation(String teamName) {			
		return lineupDAO.getFormationByTeam(teamName).getFormation() ;	
	}
	
	
	public List<String> getStartingLineup(String teamName) {        
		return lineupDAO.getFormationByTeam(teamName).getStartingLineup();
	}
	
	public String getPlayStyle(String teamName) {        
		return lineupDAO.getFormationByTeam(teamName).getPlayStyle();
	}
	
	public String getMarking(String teamName) {        
        return lineupDAO.getFormationByTeam(teamName).getMarking();
    }
	
	public List<String> getFormationList() {		
		return List.of("4-5-1", "4-4-2", "4-3-3", "3-5-2");
	}
	
	public List<String> getPlayStyleList() {		
		return List.of("Counter-Attack", "Tiki-Taka", "Gegenpressing", "Wing Play", "Direct Play", "Park the Bus");
	}
	
	public List<String> getMarkingList() {
		return List.of("Zonal", "Man");
	}
	
	
	
	
	
	
	
}
