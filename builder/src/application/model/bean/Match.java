package application.model.bean;

import java.time.LocalDate;
import java.time.LocalTime;

public class Match {
	 private String homeTeam;
	 private String awayTeam;
	 private LocalDate matchDate;
	 private LocalTime matchTime;
	 
	public Match(String homeTeam, String awayTeam, LocalDate matchDate, LocalTime matchTime) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.matchDate = matchDate;
		this.matchTime = matchTime;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public String getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}

	public LocalDate getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(LocalDate matchDate) {
		this.matchDate = matchDate;
	}
	 
	public LocalTime getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(LocalTime matchTime) {
        this.matchTime = matchTime;
    } 
	

    public String getOpponent(String teamName) {	// teamName è il nostro team
        if (teamName == null) {
            throw new IllegalArgumentException("Il nome della squadra non può essere null");		//----eccezione da rivedere
        }
        if (teamName.equalsIgnoreCase(homeTeam)) {
            return awayTeam;
        } else if (teamName.equalsIgnoreCase(awayTeam)) {
            return homeTeam;
        } else {
            throw new IllegalArgumentException("La squadra " + teamName + " non è coinvolta in questo match");		//----eccezione da rivedere
        }
    }
    
    public boolean getMatchLocation(String teamName) {
        if (teamName == null) {
            throw new IllegalArgumentException("Il nome della squadra non può essere null");		//----eccezione da rivedere
        }
        if (teamName.equalsIgnoreCase(homeTeam)) {
            return true;
        } else if (teamName.equalsIgnoreCase(awayTeam)) {
            return false;
        } else {
            throw new IllegalArgumentException("La squadra " + teamName + " non è coinvolta in questo match");		//----eccezione da rivedere
        }
    }
    
    
    
    @Override
    public String toString() {
        return "Match [homeTeam=" + homeTeam + ", awayTeam=" + awayTeam + ", matchDate=" + matchDate + ", matchTime=" + matchTime + "]";
    }

}
