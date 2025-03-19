package application.util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordCrypt {
	
	private PasswordCrypt() {}
	 
    public static String hashPassword(String plainPassword) {       
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    public static boolean checkPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
