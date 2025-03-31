package application.util;

import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

public class Validator {
	
	private Validator() {
	    throw new IllegalStateException("Validator class");
	}
	
	// Regex per validare un'email
	private static final String EMAIL_REGEX =
		    "^[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+){0,10}@"  
		    + "[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?"
		    + "(?:\\.[a-zA-Z]{2,6}){1,3}$";  
	private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    
    
    public static boolean isValidEmail(String email) {
        if (!isValidString(email)) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email).matches();	
    }
    
    
    public static boolean isValidLenghtPassword(String password) {        	
        return isValidString(password) && password.trim().length() >= 8;		
    }
    
    // Controllo presenza di blank nella password 
    public static boolean isValidBlankPassword(String password) {
    	return !Pattern.compile("\\s").matcher(password).find();
    }
    
    
    public static boolean isValidFormatPassword(String password) {
    	// Controllo presenza di una lettera maiuscola
    	if (!Pattern.compile("[A-Z]").matcher(password).find()) {
           return false;
        }
        
    	// Controllo presenza di una lettera minuscola
        if (!Pattern.compile("[a-z]").matcher(password).find()) {
        	return false;
        }
        
     // Controllo presenza di un carattere speciale
        if (!Pattern.compile("[!@#$%^&*(),.?\":{}|<>\\[\\]~-]").matcher(password).find()) {
        	return false;
        }
        
     // Controllo presenza di un numero
       return Pattern.compile("\\d").matcher(password).find();
   } 
    
   
    public static boolean isValidString(String str) {
    	// Controllo stringa vuota
    	return !StringUtils.isBlank(str);
    }
    
    
    public static boolean isValidFormatString(String str) {
    	// Controllo presenza di un carattere speciale
        if (Pattern.compile("[!@#$%^&*(),.?\":{}|<>\\[\\]~-]").matcher(str).find()) {
        	return false;
        }
        
     // Controllo presenza di un numero
    	return !Pattern.compile("\\d").matcher(str).find();
    }
}
