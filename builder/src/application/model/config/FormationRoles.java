package application.model.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormationRoles {
	
	private FormationRoles() {
	    throw new IllegalStateException("FormationRoles class");
	}
	
	private static final Map<String, List<String>> FORMATION_ROLES = new HashMap<>();
	
	static {
		// Definizione ruoli per le formazioni
        FORMATION_ROLES.put("4-5-1", Arrays.asList(
                "GK", "LB", "CB", "CB", "RB", "CDM", "CM", "CM", "LM", "RM", "ST"
            ));
        
        FORMATION_ROLES.put("4-4-2", Arrays.asList(
                "GK", "LB", "CB", "CB", "RB", "CM", "CM", "LM", "RM", "ST", "ST"
            ));
        
        FORMATION_ROLES.put("3-5-2", Arrays.asList(
                "GK", "CB", "CB", "CB", "CDM", "CM", "CM", "LM", "RM", "ST", "ST"
            ));
        
        FORMATION_ROLES.put("4-3-3", Arrays.asList(
                "GK", "LB", "CB", "CB", "RB", "CDM", "CM", "CM", "LW", "RW", "ST"
            ));
    }
	
	
	 public static List<String> getRoles(String formation) {
	        return FORMATION_ROLES.get(formation);
	    }
	 
}
