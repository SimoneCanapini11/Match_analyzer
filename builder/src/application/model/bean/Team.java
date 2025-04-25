package application.model.bean;

public class Team {
	private String nameTeam;
	private String stadium;
	private String city;
	
	public Team(String nameTeam, String stadium, String city) {
		this.nameTeam = nameTeam;
        this.stadium = stadium;
        this.city = city;
	}
	
	public Team() {}

	public String getNameTeam() {
		return nameTeam;
	}

	public void setNameTeam(String nameTeam) {
		this.nameTeam = nameTeam;
	}

	
	public String getStadium() {
		return stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	
	@Override
	public String toString() {			
		return "Team [nameTeam=" + nameTeam + ", stadium=" + stadium
				+ ", city=" + city + "]";
	}
	
	
	
}
