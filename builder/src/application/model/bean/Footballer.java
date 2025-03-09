package application.model.bean;

import java.util.ArrayList;
import java.util.List;

public class Footballer {
	   private String name;
	   private String surname;
	   private String team;
	   private int age;		//-- year(data oggi - data nascita) 
	   private List<RoleAffinity> roleAffinities;
	   private FootballerAttributes attributes;
	   
	   public Footballer(String name, String surname, String team, int age, FootballerAttributes attributes) {
		   this.name = name;
           this.surname = surname;
           this.team = team;
           this.age = age;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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
		// Calcola il valore di affinità per il ruolo richiesto
		double affinityForRole = 0.0;
		if (roleAffinities != null) {
			for (RoleAffinity ra : roleAffinities) {
				if (ra.getRole().name().equalsIgnoreCase(roleStr)) {
					affinityForRole = ra.getAffinity();
					break;
				}
			}
		}
    
		// Normalizza valori
		double normalizedOverall = attributes.getOverallRating() / 100.0;
		double normalizedPhysical = attributes.getPhysicalForm() / 100.0;
		double normalizedMentalClarity = attributes.getMentalClarity() / 100.0;
    
		// Imposta i pesi per ogni parametro: questi valori sono da definire in base alle tue regole di business
		double weightOverall = 0.7;
		double weightPhysical = 0.3;
		double weightAffinity = 0.5;
    	double weightLucidity = 0.2;
    
    	// Calcola il readyToPlay come somma pesata
    	return  attributes.getDeployable() * 
				(normalizedOverall * weightOverall +
				normalizedPhysical * weightPhysical +
                affinityForRole * weightAffinity +
                normalizedMentalClarity * weightLucidity);
	}
	
	
	
	@Override
	public String toString() {
		return "Footballer [name=" + name + ", surname=" + surname + ", team=" + team + ", age=" + age
				+ ", roleAffinities=" + roleAffinities + ", overallRating=" + attributes.getOverallRating() + ", physicalForm="
				+ attributes.getPhysicalForm() + ", mentalClarity=" + attributes.getMentalClarity() + ", deployable=" + attributes.getDeployable() + "]";
	}	   
	   
}
