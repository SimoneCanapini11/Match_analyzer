package application.model.dao;

import application.model.bean.Lineup;

public interface LineupDAO {
	Lineup getFormationByTeam(String nameTeam);
	void updateTactics(Lineup lineup);
}
