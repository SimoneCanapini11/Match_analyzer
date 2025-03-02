package application.util;

import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

public class Validator {
	
	private Validator() {
	    throw new IllegalStateException("Validator class");
	}
	
	// Regex per validare un'email
	private static final String EMAIL_REGEX =
		    "^[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+){0,10}@"  // Limitato a 10 sottodomini
		    + "[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?"
		    + "(?:\\.[a-zA-Z]{2,6}){1,3}$";  // Limitato a 3 livelli di dominio
	private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    
    
    public static boolean isValidEmail(String email) {
        if (!isValidString(email)) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email).matches();	
    }
    
    
    public static boolean isValidLenghtPassword(String password) {        	
        return isValidString(password) && password.trim().length() >= 8;		//------provare se password= 8 spazi bianchi + 1!Aa viene accettata
    }
    
    
    // Controllo presenza di blank nella password 
    public static boolean isValidBlankPassword(String password) {
        return !password.matches(".*\\s.*");
    }
    
    
    public static boolean isValidFormatPassword(String password) {
    	// Controllo presenza di una lettera maiuscola
    	if (!password.matches(".*[A-Z].*")) {
           return false;
        }
        
    	// Controllo presenza di una lettera minuscola
        if (!password.matches(".*[a-z].*")) {
        	return false;
        }
        
     // Controllo presenza di un carattere speciale
        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>\\[\\]~-].*")) {
        	return false;
        }
        
     // Controllo presenza di un numero
       return password.matches(".*\\d.*");
   } 
    
   
    public static boolean isValidString(String str) {
    	// Controllo stringa vuota
    	if (StringUtils.isBlank(str)) {
    		return false;
    	}
    	
    /*	//stringa troppo lunga (inserimento db) ------------------dove va fatto questo controllo?
    	if (str.length() > 50) {
    		return false;
    	}	*/
    	return true;
    }
    
    
    public static boolean isValidFormatString(String str) {
    	// Controllo presenza di un carattere speciale
        if (str.matches(".*[!@#$%^&*(),.?\":{}|<>\\[\\]~-].*")) {
        	return false;
        }
        
     // Controllo presenza di un numero
    	return !str.matches(".*\\d.*");
    }
}
