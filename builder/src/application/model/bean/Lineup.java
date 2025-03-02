package application.model.bean;

import java.util.List;

public class Lineup {
	 private String teamName;
	 private String formation;
	 private String playStyle;
	 private String marking;
	 //--private String teamStrength;
	 private List<String> startingLineup; // Lista dei nomi dei giocatori titolari, in ordine
	 
	 
	 public Lineup(String teamName, String formation, String playStyle, String marking, List<String> startingLineup) {
		this.teamName = teamName;
		this.formation = formation;
		this.playStyle = playStyle;
		this.marking = marking;
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


	public String getMarking() {
		return marking;
	}


	public void setMarking(String marking) {
		this.marking = marking;
	}


	public List<String> getStartingLineup() {
		return startingLineup;
	}


	public void setStartingLineup(List<String> startingLineup) {
		this.startingLineup = startingLineup;
	}


	
	@Override
	public String toString() {
		return "Lineup [teamName=" + teamName + ", formation=" + formation + ", playStyle=" + playStyle + ", marking="
				+ marking + ", startingLineup=" + startingLineup + "]";
	}
	 
	 
}
