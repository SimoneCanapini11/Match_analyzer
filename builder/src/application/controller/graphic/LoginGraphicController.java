package application.controller.graphic;

import java.io.IOException;
import application.controller.application.LoginApplicationController;
import application.exception.ValidationException;
import application.view.utils.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;


public class LoginGraphicController {
	
	 @FXML
	 private TextField emailField;
	 @FXML
	 private PasswordField passwordField;
	
	 @FXML
     private void openSignUp(ActionEvent event) throws IOException{
		 
		 String fxmlPath = "signup.fxml";
		 String title = "Sign Up";
		 Stage loginStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		 Stage parentStage = (Stage) loginStage.getOwner();
		 
		 OpenWindowUtils.openFXMLWindow(fxmlPath, title, loginStage, parentStage, true);
     }
	 
	 @FXML
	 private void handleLogin(ActionEvent event) {
	        // Acquisisci i dati dalla View
	        String email = emailField.getText();
	        String password = passwordField.getText();
	        
	    try {    
	        // Invia i dati al Controller Applicativo
	        LoginApplicationController loginController = new LoginApplicationController();  
	        boolean isAuthenticated = loginController.authenticate(email, password);

	        // Aggiorna la View in base al risultato
	        if (isAuthenticated) {
	        	// Lancio schermata in base al ruolo 
	        	String userRole = loginController.getUserRole();  
                // Apre la schermata in base al ruolo 
                OpenWindowUtils.openRoleView(event, userRole);		
	        }
	    } catch (ValidationException ve) {
            // Gestione specifica per errori di validazione
	    	AlertUtils.showAlert(Alert.AlertType.ERROR, "Login Error", ve.getMessage());
	    	
	    } catch (Exception e) {
	    	AlertUtils.showAlert(Alert.AlertType.ERROR, "Error", "Something went wrong, try again.");		
	    }
	 }	    
}
