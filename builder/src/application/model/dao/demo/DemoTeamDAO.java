package application.model.dao.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import application.model.bean.Team;
import application.model.dao.TeamDAO;

public class DemoTeamDAO implements TeamDAO {
	
	private Map<String, Team> teams = new HashMap<>();
	private static final String TEAM_NAME_INTER = "Inter";
	private static final String TEAM_NAME_MILAN = "Milan";
    public static final String TEAM_NAME_JUVENTUS = "Juventus";
 
	
	public DemoTeamDAO() {
        // Inizializza team demo
		teams.put(TEAM_NAME_INTER, new Team(TEAM_NAME_INTER, "San Siro", "Milano"));
		teams.put(TEAM_NAME_MILAN, new Team(TEAM_NAME_MILAN, "San Siro", "Milano"));
		teams.put(TEAM_NAME_JUVENTUS, new Team(TEAM_NAME_JUVENTUS, "Allianz Stadium", "Torino"));		
	}
	
	@Override
    public Team fetchTeamByName(String teamName) {
        return teams.get(teamName);
    }
	
	@Override
	public List<String> fetchOpponentList(String teamName) {
		List<String> teamNames = new ArrayList<>();
		
	    for (String key : teams.keySet()) {
	        if (!key.equals(teamName)) {
	            teamNames.add(key);
	        }
	    }
	    return teamNames;
	}
	
	@Override
	public List<String> fetchTeamNameList() {
		List<String> teamNames = new ArrayList<>();
		teamNames.addAll(teams.keySet());
		return teamNames;
	}
}
