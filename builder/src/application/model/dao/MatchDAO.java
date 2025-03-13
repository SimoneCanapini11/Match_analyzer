package application.model.dao;

import java.util.List;

import application.model.bean.Match;

public interface MatchDAO {
	List<Match> getUpcomingMatches();
	Match getNextMatch(String nameTeam);
	List<Match> getMatchesByTeam(String teamName);
	void saveMatch(Match match);
	void updateMatch(Match match, String teamName);
}
