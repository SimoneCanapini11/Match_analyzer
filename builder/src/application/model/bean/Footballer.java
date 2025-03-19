package application.model.bean;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

public class Footballer {
	   private String name;
	   private String surname;
	   private String team;
	   private LocalDate dateOfBirth;		
	   private List<RoleAffinity> roleAffinities;
	   private FootballerAttributes attributes;
	   
	   public Footballer(String name, String surname, String team, LocalDate dateOfBirth, FootballerAttributes attributes) {
		   this.name = name;
           this.surname = surname;
           this.team = team;
           this.dateOfBirth = dateOfBirth;
           this.attributes = attributes;
           this.roleAffinities = new ArrayList<>();
	   }

	// Getters e setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public List<RoleAffinity> getRoleAffinities() {
		return roleAffinities;
	}

	public void addRoleAffinity(RoleFootballer role, double affinity) {
		roleAffinities.add(new RoleAffinity(role, affinity));
	}
	
	public FootballerAttributes getAttributes() {
        return attributes;
    }
	
	public void setAttributes(FootballerAttributes attributes) {
		this.attributes = attributes;
	}

	public int getOverallRating() {
		return attributes.getOverallRating();
	}


	public double getPhysicalForm() {
		return attributes.getPhysicalForm();
	}

	public double getMentalClarity() {
		return attributes.getMentalClarity();
	}

	public int getDeployable() {
		return attributes.getDeployable();
	}
	

	public double getReadyToPlay(String roleStr) {
		// Valore di affinità per il ruolo richiesto
		double affinityForRole = 0.0;
		if (roleAffinities != null) {
			for (RoleAffinity ra : roleAffinities) {
				if (ra.getRole().name().equalsIgnoreCase(roleStr)) {
					affinityForRole = ra.getAffinity();
					break;
				}
			}
		}
    
		double normalizedOverall = attributes.getOverallRating() / 100.0;
		double normalizedPhysical = attributes.getPhysicalForm() / 100.0;
		double normalizedMentalClarity = attributes.getMentalClarity() / 100.0;
    
		double weightOverall = 0.7;
		double weightPhysical = 0.3;
		double weightAffinity = 0.5;
    	double weightLucidity = 0.2;
    
    	// readyToPlay come somma pesata
    	return  attributes.getDeployable() * 
				(normalizedOverall * weightOverall +
				normalizedPhysical * weightPhysical +
                affinityForRole * weightAffinity +
                normalizedMentalClarity * weightLucidity);
	}
	
	
	
	@Override
	public String toString() {
		return "Footballer [name=" + name + ", surname=" + surname + ", team=" + team + ", Date of birth=" + dateOfBirth
				+ ", roleAffinities=" + roleAffinities + ", overallRating=" + attributes.getOverallRating() + ", physicalForm="
				+ attributes.getPhysicalForm() + ", mentalClarity=" + attributes.getMentalClarity() + ", deployable=" + attributes.getDeployable() + "]";
	}	   
	   
}
