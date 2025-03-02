package application.model.dao.demo;

import java.util.HashMap;
import java.util.Map;

import application.model.bean.Team;
import application.model.dao.TeamDAO;

public class DemoTeamDAO implements TeamDAO {
	private Map<String, Team> teams = new HashMap<>();
	
	public DemoTeamDAO() {
        // Inizializza team demo
		teams.put("Inter", new Team("Inter", "San Siro", "Milano"));
		teams.put("Milan", new Team("Milan", "San Siro", "Milano"));
		teams.put("Juventus", new Team("Juventus", "Allianz Stadium", "Torino"));
		teams.put("Roma", new Team("Roma", "Stadio Olimpico", "Roma"));
		teams.put("Fiorentina", new Team("Fiorentina", "Stadio Artemio Franchi", "Firenze"));
		teams.put("Napoli", new Team("Napoli", "Stadio Diego Armando Maradona", "Napoli"));

	}
	
	@Override
    public Team getTeamByName(String teamName) {
        return teams.get(teamName);
    }
}
