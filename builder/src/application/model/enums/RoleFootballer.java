package application.model.enums;

import application.exception.DAOException;

public enum RoleFootballer {
	 GK, // Goalkeeper
	 LB, // Left Back
	 CB, // Center Back
	 RB, // Right Back
	 CDM, // Center Defensive Midfield
	 CM, // Center Midfield
	 CAM, // Center Attacking Midfield
	 LM, // Left Midfield
	 RM, // Right Midfield
	 LW, // Left Winger
	 RW, // Right Winger
	 ST;  // Striker
	 
	 
	 public static RoleFootballer fromString(String role) {
	        try {
	            return RoleFootballer.valueOf(role.toUpperCase()); 
	        } catch (IllegalArgumentException e) {
	            throw new DAOException("Invalid role: " + role);
	        }
	 }
}
