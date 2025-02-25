package application.view.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

public class AlertUtils {
	
	  public static void showAlert(Alert.AlertType alertType, String title, String message) {
	        Alert alert = new Alert(alertType);		
	        alert.setTitle(title);
	        alert.setHeaderText(null);
	        alert.setContentText(message);
	        
	     // Ottieni il contentLabel dell'alert
	        Label contentLabel = (Label) alert.getDialogPane().lookup(".content.label");

	        // Imposta lo stile per aumentare la dimensione del testo		//------------da mettere in una classe css (?)
	        if (contentLabel != null) {
	            contentLabel.setStyle("-fx-font-size: 16px;"); // Regola la dimensione del font 
	            contentLabel.setWrapText(true); 
	            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE); // Adatta l'altezza dell'alert al contenuto
	        }
	        
	        alert.showAndWait();
	    }
	    
	    
	    public static void comingSoonAlert() {
	    	showAlert(Alert.AlertType.INFORMATION, null, "Coming soon");
	    }
}
