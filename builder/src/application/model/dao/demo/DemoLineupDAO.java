package application.model.dao.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import application.model.bean.Footballer;
import application.model.bean.Lineup;
import application.model.dao.LineupDAO;

public class DemoLineupDAO implements LineupDAO {
	
	private Map<String, Lineup> defaultLineup;
	private DemoFootballerDAO footballerDAO;
	
	public DemoLineupDAO() {
		defaultLineup = new HashMap<>();
		footballerDAO = new DemoFootballerDAO();
		initializeLineup();
	}
	
    // Metodo per inizializzare i dati demo
    private void initializeLineup() {
    	//Inter
    	final String TEAM_NAME_INTER = "Inter";
    	// Lista dei nomi dei giocatori titolari, in ordine (dalla posizione 1 a 11)
    	 List<Footballer> allInterPlayers = footballerDAO.getFootballersByTeam(TEAM_NAME_INTER);
    	 
    	 List<Footballer> startingInterLineup = new ArrayList<>();
         // Titolari: primi 11 
         for (int i = 0; i < 11 && i < allInterPlayers.size(); i++) {
        	 startingInterLineup.add(allInterPlayers.get(i));
         }
    	
    	defaultLineup.put(TEAM_NAME_INTER, new Lineup(TEAM_NAME_INTER, "3-5-2", "Total Football", "Man-to-Man", startingInterLineup));
    	
    	
    	// Juventus
    	final String TEAM_NAME_JUVE = "Juventus";
    	// Lista dei nomi dei giocatori titolari, in ordine (dalla posizione 1 a 11)
    	 List<Footballer> allJuvePlayers = footballerDAO.getFootballersByTeam(TEAM_NAME_JUVE);
    	 
    	 List<Footballer> startingJuveLineup = new ArrayList<>();
         // Titolari: primi 11 
         for (int i = 0; i < 11 && i < allJuvePlayers.size(); i++) {
        	 startingJuveLineup.add(allJuvePlayers.get(i));
         }
    	
        defaultLineup.put(TEAM_NAME_JUVE, new Lineup(TEAM_NAME_JUVE, "4-5-1", "Wing Play", "Zonal", startingJuveLineup));
        
        
        // Milan
        final String TEAM_NAME_MILAN = "Milan";
    	// Lista dei nomi dei giocatori titolari, in ordine (dalla posizione 1 a 11)
    	 List<Footballer> allMilanPlayers = footballerDAO.getFootballersByTeam(TEAM_NAME_MILAN);
    	 
    	 List<Footballer> startingMilanLineup = new ArrayList<>();
         // Titolari: primi 11 
         for (int i = 0; i < 11 && i < allMilanPlayers.size(); i++) {
        	 startingMilanLineup.add(allMilanPlayers.get(i));
         }
        
        defaultLineup.put(TEAM_NAME_MILAN, new Lineup(TEAM_NAME_MILAN, "4-3-3", "Direct Play", "Zonal", startingMilanLineup));
    }
	

	@Override
	public Lineup getFormationByTeam(String nameTeam) {
		return defaultLineup.get(nameTeam);
	}

	@Override
	public void updateTactics(Lineup lineup) {
		defaultLineup.put(lineup.getTeamName(), lineup);   
		
	}

}
