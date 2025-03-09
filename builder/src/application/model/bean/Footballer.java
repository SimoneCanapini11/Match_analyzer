package application.model.bean;

import java.util.ArrayList;
import java.util.List;

public class Footballer {
	   private String name;
	   private String surname;
	   private String team;
	   private int age;		//-- year(data oggi - data nascita) 
	   private List<RoleAffinity> roleAffinities;
	   private int overallRating;    // da 0 a 100	//---------------controllo (?)
	   private int physicalForm;   // da 0 a 100		
	   private int mentalClarity;   // da 0 a 100
	   private int deployable; // 0 o 1
	   
	   public Footballer(String name, String surname, String team, int age, int overallRating, int physicalForm, int mentalClarity, int deployable) {
		   this.name = name;
           this.surname = surname;
           this.team = team;
           this.age = age;
           this.roleAffinities = new ArrayList<>();
           this.overallRating = overallRating;
           this.physicalForm = physicalForm;
           this.mentalClarity = mentalClarity;
           this.deployable = deployable;
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

	public int getOverallRating() {
		return overallRating;
	}

	public void setOverallRating(int overallRating) {
		this.overallRating = overallRating;
	}

	public double getPhysicalForm() {
		return physicalForm;
	}

	public void setPhysicalForm(int physicalForm) {
		this.physicalForm = physicalForm;
	}

	public double getMentalClarity() {
		return mentalClarity;
	}

	public void setMentalClarity(int mentalClarity) {
		this.mentalClarity = mentalClarity;
	}

	public int getDeployable() {
		return deployable;
	}

	public void setDeployable(int deployable) {
		this.deployable = deployable;
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
		double normalizedOverall = overallRating / 100.0;
		double normalizedPhysical = physicalForm / 100.0;
		double normalizedMentalClarity = mentalClarity / 100.0;
    
		// Imposta i pesi per ogni parametro: questi valori sono da definire in base alle tue regole di business
		double weightOverall = 0.4;
		double weightPhysical = 0.3;
		double weightAffinity = 0.2;
    	double weightLucidity = 0.1;
    
    	// Calcola il readyToPlay come somma pesata
    	return  deployable * 
				(normalizedOverall * weightOverall +
				normalizedPhysical * weightPhysical +
                affinityForRole * weightAffinity +
                normalizedMentalClarity * weightLucidity);
	}
	
	
	
	@Override
	public String toString() {
		return "Footballer [name=" + name + ", surname=" + surname + ", team=" + team + ", age=" + age
				+ ", roleAffinities=" + roleAffinities + ", overallRating=" + overallRating + ", physicalForm="
				+ physicalForm + ", mentalClarity=" + mentalClarity + ", deployable=" + deployable + "]";
	}	   
	   
}
