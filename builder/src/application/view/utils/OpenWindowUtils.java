package application.view.utils;

import java.io.IOException;
import application.util.Formatter;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.BoxBlur;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;


public class OpenWindowUtils {
	
	private OpenWindowUtils() {
	    throw new IllegalStateException("OpenWindowUtils class");
	}
	
    public static void checkAndRemoveBlur(Stage parentStage) {
        // Ritarda l'esecuzione per garantire che la nuova finestra venga aperta
        Platform.runLater(() -> {
            // Controlla se ci sono finestre aperte diverse dalla finestra principale
            boolean hasOpenWindows = Stage.getWindows().stream()
                .filter(window -> window != parentStage) // Escludi la finestra principale
                .anyMatch(Window::isShowing);

            // Se non ci sono altre finestre aperte, rimuovi la sfocatura
            if (!hasOpenWindows) {
                parentStage.getScene().getRoot().setEffect(null);
            }
        });
    }
    
    
    public static void initSecondaryWindow(Stage stage, Stage parentStage, Parent root) {
    	
    	stage.initOwner(parentStage); // Imposta la finestra chiamante come owner
    	stage.initModality(Modality.WINDOW_MODAL); // Blocca l'interazione con la finestra chiamante
    	
    	// Calcola il centro della finestra chiamante
        double centerX = parentStage.getX() + (parentStage.getWidth() - root.prefWidth(-1)) / 2;
        double centerY = parentStage.getY() + (parentStage.getHeight() - root.prefHeight(-1)) / 2;
        
     // Posiziona la finestra al centro
        stage.setX(centerX);
        stage.setY(centerY);

        // Impedire lo spostamento della finestra
        stage.setResizable(false); // Disabilita il ridimensionamento
        
     // Sfoca la finestra chiamante
        BoxBlur blur = new BoxBlur(10, 10, 5);
        parentStage.getScene().getRoot().setEffect(blur);
    }
    
    
    public static void openRoleView(ActionEvent event, String role) throws IOException{
    	
    	// Ottieni il parent stage (homepage) attraverso il proprietario della finestra currentStage
		Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Stage parentStage = (Stage) currentStage.getOwner();
		
		String fxmlPath = "/application/view/" + role + "View.fxml";
		
		openFXMLWindow(fxmlPath, Formatter.uppercaseString(role) + " Home", currentStage, parentStage, false);	
    }
 
 
    public static void openFXMLWindow(String fxmlPath, String title, Stage currentStage, Stage parentStage, boolean secondaryWindow) throws IOException {
    	// Creazione finestra
        Stage newStage = new Stage();
        
        // Caricamento FXML
        Parent root = FXMLLoader.load(OpenWindowUtils.class.getResource(fxmlPath));
        
        // Inizializzazione finestra
        newStage.setScene(new Scene(root));
        newStage.setTitle(title);
        
        if (secondaryWindow) {
        	initSecondaryWindow(newStage, parentStage, root);
        }
        
        // Chiusura finestra corrente
        if(currentStage != null) {
            currentStage.close();
        }
        
        // Chiusura finestra parent 
        if (parentStage != null && secondaryWindow == false) {
        	parentStage.close();
        }
        
        // Gestione evento chiusura
        newStage.setOnHidden(e -> checkAndRemoveBlur(parentStage));
        
        newStage.show();
    }
}



