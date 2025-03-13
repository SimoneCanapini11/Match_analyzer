package application.view.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

import javafx.util.StringConverter;

public class DateConverter extends StringConverter<LocalDate> {		
	
	// Definisci il formatter principale (dd/MM/yy)
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy", Locale.ENGLISH);

	
	 @Override
     public String toString(LocalDate date) {
         // Se la data non è nulla, formatta con dd/MM/yy
         return (date != null) ? formatter.format(date) : "";
     }

     @Override
     public LocalDate fromString(String string) {
         if (string == null || string.trim().isEmpty()) {
             return null; // Nessuna data
         }

         // 1) Sostituisci tutti i separatori non numerici con "/"
         //    Esempio: "1-1-2" -> "1/1/2", "01/01-2025" -> "01/01/2025"
         String normalized = string.replaceAll("[^0-9]", "/");

         // 2) Dividi in [giorno, mese, anno]
         String[] parts = normalized.split("/");
         // Se mancano parti, le gestiamo in modo difensivo
         // (potresti gestire eccezioni o default)
         String dayPart   = (parts.length > 0) ? parts[0] : "1";
         String monthPart = (parts.length > 1) ? parts[1] : "1";
         String yearPart  = (parts.length > 2) ? parts[2] : "25"; // default '25' se manca

         // 3) Zero-pad day e month se serve (1 -> 01)
         dayPart   = zeroPad(dayPart, 2);
         monthPart = zeroPad(monthPart, 2);

         // 4) Se l'anno ha più di 2 cifre, prendi le ultime 2
         //    Esempio: "2025" -> "25"
         if (yearPart.length() > 2) {
             yearPart = yearPart.substring(yearPart.length() - 2);
         }
         // Se ha 1 sola cifra, ad esempio '2', forziamo '02' o '25'?
         // Qui scelgo di zero-pad. Se vuoi forzare sempre '25', fallo:
         // if (yearPart.length() == 1) yearPart = "25";
         yearPart = zeroPad(yearPart, 2);

         // 5) Ricostruisci la stringa "dd/MM/yy"
         String finalDate = dayPart + "/" + monthPart + "/" + yearPart;

         // 6) Tenta il parse con dd/MM/yy
         try {
             return LocalDate.parse(finalDate, formatter);
         } catch (DateTimeParseException e) {
             // Se non parse correttamente, ritorna null o gestisci errore
             return null;
         }
     }

     private String zeroPad(String s, int length) {
         // Rende "1" -> "01" se length=2
         while (s.length() < length) {
             s = "0" + s;
         }
         return s;
     }
}
