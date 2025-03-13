package application.model.dao;

import java.util.List;

import application.model.bean.Team;

public interface TeamDAO {
	Team getTeamByName(String teamName);
	List<String> getOpponentList(String teamName);
	List<String> getTeamNameList();
}
