package application.model.bean;

public class Team {
	private String nameTeam;
	//--private String coach;	//--regole aziendali
	//--private List<Footballer> footballers;
	//--private List<Trainer> trainers;
	private String stadium;
	private String city;
	//--private List<---> lineup   //---formazione titolare di default
	
	public Team(String nameTeam, String stadium, String city) {
		this.nameTeam = nameTeam;
        this.stadium = stadium;
        this.city = city;
	}

	public String getNameTeam() {
		return nameTeam;
	}

	public void setNameTeam(String nameTeam) {
		this.nameTeam = nameTeam;
	}


	/*
	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}
	
	 public void assignCoach(User user) throws ValidationException {
	        if (user == null || user.getRole() != Role.COACH.getValue()) {
	            throw new ValidationException("L'utente non ha il ruolo di COACH.");
	        }
	        // Puoi decidere cosa memorizzare, ad esempio l'email o il nome
	        this.coach = user.getEmail(); // oppure user.getUsername()
	    }
	 */
	
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
	public String toString() {			//------------------------------------Per debug
		return "Team [nameTeam=" + nameTeam + ", stadium=" + stadium
				+ ", city=" + city + "]";
	}
	
	
	
}
