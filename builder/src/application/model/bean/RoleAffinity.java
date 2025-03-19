package application.model.bean;

public class RoleAffinity {

	 private RoleFootballer role;
	 private double affinity;

	 public RoleAffinity(RoleFootballer role, double affinity) {
		 
		 if (affinity < 0.0 || affinity > 1.0) {
			 throw new IllegalArgumentException("The affinity value must be between 0 and 1");	
		 }
		 this.role = role;
		 this.affinity = affinity;
	 }

	 public RoleFootballer getRole() {
		 return role;
	 }

	 public double getAffinity() {
		 return affinity;
	 }

	 @Override
	 public String toString() {
		 return role + ": " + affinity;
	 }
}
