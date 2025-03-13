package application.model.dao.demo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import application.model.bean.Match;
import application.model.dao.MatchDAO;

public class DemoMatchDAO implements MatchDAO {
	
	 private List<Match> matches;

	 public DemoMatchDAO() {
		 initializeData();
	 }
	
	 private void initializeData() {
		 matches = new ArrayList<>();
		 final String TEAM_NAME_INTER = "Inter";
		 final String TEAM_NAME_JUVENTUS = "Juventus";
		 final String TEAM_NAME_MILAN = "Milan";
	        
		 matches.add(new Match(TEAM_NAME_INTER, TEAM_NAME_JUVENTUS, LocalDate.now().plusDays(3), LocalTime.of(20, 45)));
		 matches.add(new Match(TEAM_NAME_INTER, TEAM_NAME_MILAN, LocalDate.now().plusDays(7), LocalTime.of(18, 00)));
		 matches.add(new Match(TEAM_NAME_JUVENTUS, TEAM_NAME_INTER, LocalDate.now().plusDays(10), LocalTime.of(15, 00)));
		 matches.add(new Match(TEAM_NAME_MILAN, TEAM_NAME_JUVENTUS, LocalDate.now().plusDays(15), LocalTime.of(20, 45)));
	 }

	 
	 
	@Override
	public List<Match> getUpcomingMatches() {
		return matches;		
	}

	@Override
	public Match getNextMatch(String nameTeam) {
		 return matches.stream()
	                .filter(match -> match.getHomeTeam().equalsIgnoreCase(nameTeam) 
	                              || match.getAwayTeam().equalsIgnoreCase(nameTeam))
	                .findFirst()
	                .orElse(null);
	}	
	
	@Override
    public List<Match> getMatchesByTeam(String teamName) {
		return matches.stream()
                .filter(match -> teamName.equalsIgnoreCase(match.getHomeTeam()) 
                              || teamName.equalsIgnoreCase(match.getAwayTeam()))
                .collect(Collectors.toList());
	}

	@Override
	public void saveMatch(Match match) {
		matches.add(match);
	}
	
	@Override
	public void updateMatch(Match match, String teamName) {
		for (Match m : matches) {
	        if (m.getMatchDate().equals(match.getMatchDate()) &&
	           (m.getHomeTeam().equals(teamName) || m.getAwayTeam().equals(teamName))) {
	            
	            // Update del match
	            m.setMatchTime(match.getMatchTime());
	            m.setHomeTeam(match.getHomeTeam());
	            m.setAwayTeam(match.getAwayTeam());
	        }
	    }
	}

}
