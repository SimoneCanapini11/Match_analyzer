package application.model.dao;

import java.util.List;

import application.model.bean.Match;

public interface MatchDAO {
	public List<Match> getUpcomingMatches();
	public Match getNextMatch(String nameTeam);
	public List<Match> getMatchesByTeam(String teamName);
	//--addMatch()
}
