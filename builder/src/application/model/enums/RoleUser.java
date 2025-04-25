package application.model.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum RoleUser {
	COACH("Coach"),
    TRAINER("Trainer"),
    FOOTBALLER("Footballer");

    private final String displayName;

    RoleUser(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
	    
	    
    public static RoleUser fromString(String str) {
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
        return Arrays.stream(RoleUser.values())
                .map(RoleUser::getDisplayName)
                .collect(Collectors.toList());
    }
}
