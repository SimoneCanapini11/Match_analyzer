package application.model.dao.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import application.model.bean.Lineup;
import application.model.dao.LineupDAO;

public class DemoLineupDAO implements LineupDAO {
	private Map<String, Lineup> defaultLineup;
	
	public DemoLineupDAO() {
		defaultLineup = new HashMap<>();
		initializeLineup();
	}
	
    // Metodo per inizializzare i dati demo
    private void initializeLineup() {
    	//Inter
    	// Lista dei nomi dei giocatori titolari, in ordine (dalla posizione 1 a 11)
    	List<String> startingLineup = new ArrayList<>();
    	startingLineup.add("Yann Sommer");
    	startingLineup.add("Alessandro Bastoni");		//--vanno collegati ai <Footballer>
    	startingLineup.add("Stefan De Vrij");
    	startingLineup.add("Benjamin Pavard");
    	startingLineup.add("Hakan Calhanoglu");
    	startingLineup.add("Piotr Zielinski");
    	startingLineup.add("Nicolo Barella");
    	startingLineup.add("Federico Di Marco");
    	startingLineup.add("Denzel Dumfries");
    	startingLineup.add("Marcus Thuram");
    	startingLineup.add("Lautaro Martinez");
    	
    	defaultLineup.put("Inter", new Lineup("Inter", "3-5-2", null, null, startingLineup));
    	
    	// Milan
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
