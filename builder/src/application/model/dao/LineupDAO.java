package application.model.dao;

import application.model.bean.Lineup;

public interface LineupDAO {
	Lineup fetchFormationByTeam(String nameTeam);
	void updateTactics(Lineup lineup);
}
