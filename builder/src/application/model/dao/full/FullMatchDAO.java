package application.model.dao.full;

import java.util.List;

import application.model.bean.Match;
import application.model.dao.MatchDAO;

public class FullMatchDAO implements MatchDAO {

	@Override
	public List<Match> getUpcomingMatches() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Match getNextMatch(String ourTeam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Match> getMatchesByTeam(String teamName) {
		//--- solo match futuri
		return null;
	}

	@Override
	public void saveMatch(Match match) {
		//----- da implementare
		
	}

	@Override
	public void updateMatch(Match match, String teamName) {
		// TODO Auto-generated method stub
		
	}

}
