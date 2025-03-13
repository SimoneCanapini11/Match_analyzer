package application.view.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

import javafx.util.StringConverter;

public class DateConverter extends StringConverter<LocalDate> {		
	
	// Formatter principale (dd/MM/yy)
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy", Locale.ENGLISH);

	
	 @Override
     public String toString(LocalDate date) {
         return (date != null) ? formatter.format(date) : "";
     }

     @Override
     public LocalDate fromString(String string) {
         if (string == null || string.trim().isEmpty()) {
             return null; // Nessuna data
         }

         String normalized = string.replaceAll("\\D", "/");

         String[] parts = normalized.split("/");
         String dayPart   = (parts.length > 0) ? parts[0] : "1";
         String monthPart = (parts.length > 1) ? parts[1] : "1";
         String yearPart  = (parts.length > 2) ? parts[2] : "25"; 

         dayPart   = zeroPad(dayPart, 2);
         monthPart = zeroPad(monthPart, 2);

         if (yearPart.length() > 2) {
             yearPart = yearPart.substring(yearPart.length() - 2);
         }
         yearPart = zeroPad(yearPart, 2);

         String finalDate = dayPart + "/" + monthPart + "/" + yearPart;

         try {
             return LocalDate.parse(finalDate, formatter);
         } catch (DateTimeParseException e) {
             return null;
         }
     }

     private String zeroPad(String s, int length) {
    	    int zerosNeeded = length - s.length();
    	    if (zerosNeeded <= 0) {
    	        return s;
    	    }
    	    StringBuilder sb = new StringBuilder(zerosNeeded + s.length());
    	    for (int i = 0; i < zerosNeeded; i++) {
    	        sb.append('0');
    	    }
    	    sb.append(s);
    	    return sb.toString();
    	}

}
