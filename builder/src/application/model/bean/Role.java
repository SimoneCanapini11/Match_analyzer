package application.model.bean;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Role {
	COACH("Coach"),
    TRAINER("Trainer"),
    FOOTBALLER("Footballer");

    private final String displayName;

    Role(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
	    
	    
    public static Role fromString(String str) {
    	switch (str.trim().toLowerCase()) {
    	case "coach":
    		return COACH;
    	case "trainer":
    		return TRAINER;
    	case "footballer":
    		return FOOTBALLER;
    	default:
    		return null;
    	}
    }
    
    
    public static List<String> getRoleDisplayNames() {
        return Arrays.stream(Role.values())
                .map(Role::getDisplayName)
                .collect(Collectors.toList());
    }
}
