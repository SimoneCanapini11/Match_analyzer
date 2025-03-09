package application.model.bean;

import java.util.List;

public class Lineup {
	 private String teamName;
	 private String formation;
	 private String playStyle;
	 private String markingType;
	 private List<Footballer> startingLineup; // Lista dei nomi dei giocatori titolari, in ordine
	 
	 
	 public Lineup(String teamName, String formation, String playStyle, String markingType, List<Footballer> startingLineup) {
		this.teamName = teamName;
		this.formation = formation;
		this.playStyle = playStyle;
		this.markingType = markingType;
		this.startingLineup = startingLineup;
	}


	public String getTeamName() {
		return teamName;
	}


	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}


	public String getFormation() {
		return formation;
	}


	public void setFormation(String formation) {
		this.formation = formation;
	}


	public String getPlayStyle() {
		return playStyle;
	}


	public void setPlayStyle(String playStyle) {
		this.playStyle = playStyle;
	}


	public String getMarkingType() {
		return markingType;
	}


	public void setMarkingType(String markingType) {
		this.markingType = markingType;
	}


	public List<Footballer> getStartingLineup() {
		return startingLineup;
	}


	public void setStartingLineup(List<Footballer> startingLineup) {
		this.startingLineup = startingLineup;
	}


	
	@Override
	public String toString() {
		return "Lineup [teamName=" + teamName + ", formation=" + formation + ", playStyle=" + playStyle + ", marking="
				+ markingType + ", startingLineup=" + startingLineup + "]";
	}
	 
	 
}
