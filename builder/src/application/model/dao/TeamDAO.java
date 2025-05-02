package application.model.dao;

import java.util.List;

import application.model.bean.Team;

public interface TeamDAO {
	Team fetchTeamByName(String teamName);
	List<String> fetchOpponentList(String teamName);
	List<String> fetchTeamNameList();
}
