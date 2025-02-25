package application.view;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class UIUtils {
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
    
    
    public static void initWindow(Stage stage, Stage parentStage, Parent root) {
    	
    	stage.initOwner(parentStage); // Imposta la homepage come owner
    	stage.initModality(Modality.WINDOW_MODAL); // Blocca l'interazione con la Homepage
    	
    	stage.setScene(new Scene(root));
    	
    	// Calcola il centro della homepage
        double centerX = parentStage.getX() + (parentStage.getWidth() - root.prefWidth(-1)) / 2;
        double centerY = parentStage.getY() + (parentStage.getHeight() - root.prefHeight(-1)) / 2;
        
     // Posiziona la finestra al centro
        stage.setX(centerX);
        stage.setY(centerY);

        // Impedire lo spostamento della finestra
        stage.setResizable(false); // Disabilita il ridimensionamento
    }
    
    
    public static void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}



