package application.model.bean;

public class User {
	private String email;
    private String password;	//---------da salvare con hashing
    private String name;
    private String surname;
    private RoleUser role;
    private String team;

    public User(String email, String password, String name, String surname, RoleUser role, String team) {
    	this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.team = team;
    }
    
    public User() {}

    // Getters & Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
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
    
    public RoleUser getRole() {
        return role;
    }

    public void setRole(RoleUser role) {
        this.role = role;
    }
    
    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }


    
    @Override
	public String toString() {	//------------------------------------Per debug
		return "User [email=" + email + ", password=" + password + ", name=" + name + ", surname=" + surname + ", role="
				+ role + ", team=" + team + "]";
	}
   
}
