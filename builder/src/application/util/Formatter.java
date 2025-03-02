package application.util;

public class Formatter {

		// Rimuove spazi bianchi ad inizio e fine stringa
		public static String removeBlanks(String str) {
			return str.trim();
		}
		
		// La prima lettera di ogni parola diventa maiuscola
		public static String uppercaseString(String str) {
		    String[] words = str.split("\\s+");
		    StringBuilder result = new StringBuilder();
		    
		    for (String word : words) {
		        if (word.length() > 0) {
		            String firstLetter = word.substring(0, 1).toUpperCase();
		            String wordNext = word.substring(1).toLowerCase();
		            result.append(firstLetter).append(wordNext).append(" ");
		        } else {
		            result.append(" ");
		        }
		    }
		    return result.toString().trim();
		}
		
		// Restiutuisce una stringa eliminado i caratteri prima dello split
		public static String splitString(String str) {
			String[] split = str.trim().split("\\s+");
		    if (split.length > 1) {
		        StringBuilder splittedBuilder = new StringBuilder();
		        for (int i = 1; i < split.length; i++) {
		        	splittedBuilder.append(split[i]);
		            if (i < split.length - 1) {
		            	splittedBuilder.append(" ");
		            }
		        }
		        return splittedBuilder.toString();
		    } else {
		        return str;
		    }
		}
		
}
