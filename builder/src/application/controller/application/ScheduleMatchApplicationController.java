package application.controller.application;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import application.exception.TrainerException;
import application.model.bean.Match;
import application.model.dao.DAOFactory;
import application.model.dao.MatchDAO;
import application.model.dao.TeamDAO;

public class ScheduleMatchApplicationController {
	
	private TeamDAO teamDAO;
	private MatchDAO matchDAO;
	
	public ScheduleMatchApplicationController() {
		this.teamDAO = DAOFactory.getTeamDAO();
		this.matchDAO = DAOFactory.getMatchDAO();
	}
	
	
	public int saveMatch(String teamName, LocalDate selectedDate, LocalTime selectedTime, String opponent, String selectedRadioValue) throws TrainerException {
		
		 if (selectedDate == null) {
			 throw new TrainerException("Enter the match date");
		 }
		 
		 if (opponent == null) {
			 throw new TrainerException("Enter the Opponent");
		 }
		 
		 LocalDateTime matchDateTime = LocalDateTime.of(selectedDate, selectedTime);
		 // Controlla che la data/ora non sia nel passato
		 if (matchDateTime.isBefore(LocalDateTime.now())) {
			 throw new TrainerException("The match date and time must be in the future");
		 }
		 
		 String homeTeam;
		 String awayTeam;
		 
		 if ("Home".equals(selectedRadioValue)) {
			 homeTeam = teamName;
			 awayTeam = opponent;
		 } else {
			 homeTeam = opponent;
             awayTeam = teamName;
		 }
			 
		 
		 // Lista dei match esistenti per teamName dal DAO
		 List<Match> existingMatches = matchDAO.getMatchesByTeam(teamName);
	        
		 // Controllo su esistenza match con gli stessi valori
		 for (Match m : existingMatches) {
			 if (isAlreadySet(m, homeTeam, awayTeam, selectedDate, selectedTime)) {
	                return 0;
	            }
		 }
		 
		 // Controllo su esistenza match con stessa data per update
		 for (Match m : existingMatches) {
			 if (m.getMatchDate().equals(selectedDate) && 
				(m.getHomeTeam().equalsIgnoreCase(teamName) || m.getAwayTeam().equalsIgnoreCase(teamName))) {
				 // Aggiorna il match
				 Match updatedMatch = new Match(homeTeam, awayTeam, selectedDate, selectedTime);
				 matchDAO.updateMatch(updatedMatch, teamName);
				 return 1;
			 }
		 }
		 
		if (!checkMatch(matchDateTime, existingMatches)) {
			 throw new TrainerException("The team already has a match within 24 hours");
         }
		
		List<Match> existingOpponentMatches = matchDAO.getMatchesByTeam(opponent);
		
		if (!checkMatch(matchDateTime, existingOpponentMatches)) {
			 throw new TrainerException(opponent + " already has a match within 24 hours");
        }
         
		// Salva il match
		Match newMatch = new Match(homeTeam, awayTeam, selectedDate, selectedTime);
		matchDAO.saveMatch(newMatch);
        
		// Notifica per il coach in caso di richiesta
		UserApplicationController trainerController = new UserApplicationController();
		trainerController.gameEntered(teamName);
		
		return 0;
	}
	

	public List<String> getOpponentList(String teamName) {
		return teamDAO.getOpponentList(teamName);
	}
	
	
	private boolean checkMatch(LocalDateTime matchDateTime, List<Match> existingMatches) {
		
		for (Match match : existingMatches) {
			// Controlla su esistanza di un match entro 24 ore di distanza
			Duration diffTeam = Duration.between(matchDateTime, match.getMatchDate().atTime(match.getMatchTime())).abs();
			if (diffTeam.toHours() < 24) {
				return false;
			}
		}
		return true;
	}
	
	
	public List<List<String>> getNextFiveMatches(String teamName) {
		
		List<Match> upcomingMatches = matchDAO.getMatchesByTeam(teamName);
		
		 List<List<String>> matchesData = new ArrayList<>();
	        
	        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEE, dd MMM", Locale.ENGLISH);
	        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

	        int limit = Math.min(upcomingMatches.size(), 5);

	        for (int i = 0; i < limit; i++) {
	            Match match = upcomingMatches.get(i);
	            List<String> matchDetails = new ArrayList<>();
	            
	            matchDetails.add(match.getHomeTeam());
	            matchDetails.add(match.getAwayTeam());
	            matchDetails.add(match.getMatchDate().format(dateFormatter));
	            matchDetails.add(match.getMatchTime().format(timeFormatter));

	            matchesData.add(matchDetails);
	        }

	        return matchesData;
    }
	
	
	private boolean isAlreadySet(Match m, String homeTeam, String awayTeam, LocalDate selectedDate, LocalTime selectedTime) {
		return m.getHomeTeam().equalsIgnoreCase(homeTeam) &&
				m.getAwayTeam().equalsIgnoreCase(awayTeam) &&
				m.getMatchDate().equals(selectedDate) &&
				m.getMatchTime().equals(selectedTime);
	}
	
}
