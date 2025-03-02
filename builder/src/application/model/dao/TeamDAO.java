package application.model.dao;

import application.model.bean.Team;

public interface TeamDAO {
	Team getTeamByName(String teamName);
	
}
