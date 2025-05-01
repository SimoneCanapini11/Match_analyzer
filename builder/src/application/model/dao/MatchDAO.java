package application.model.dao;

import java.util.List;

import application.model.bean.Match;

public interface MatchDAO {
	List<Match> fetchUpcomingMatches();
	Match fetchNextMatch(String nameTeam);
	List<Match> fetchMatchesByTeam(String teamName);
	void saveMatch(Match match);
	void updateMatch(Match match, String teamName);
}
