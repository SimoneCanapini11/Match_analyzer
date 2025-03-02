package application.model.bean;

import java.util.ArrayList;
import java.util.List;

public class Footballer {
	   private String name;
	   private String surname;
	   private String team;
	   private int age;		//-- year(data oggi - data nascita) 
	   private List<RoleAffinity> roleAffinities;
	   //--private params;		//-- forma fisica, ecc.
	   
	   public Footballer(String name, String surname, String team, int age) {
		   this.name = name;
           this.surname = surname;
           this.team = team;
           this.age = age;
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
	

	@Override
	public String toString() {
		return "Footballer [name=" + name + ", surname=" + surname + ", team=" + team + ", age=" + age
				+ ", roleAffinities=" + roleAffinities + "]";
	}
	   
	   
}
