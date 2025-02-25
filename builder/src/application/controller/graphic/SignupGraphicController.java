package application.controller.graphic;

import application.config.AppContext;


import application.controller.application.SignupApplicationController;
import application.exception.DAOException;
import application.exception.ValidationException;
import application.view.utils.*;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.collections.FXCollections;

public class SignupGraphicController {
	
	 private SignupApplicationController signupController;
	 
	 public SignupGraphicController() {
		 this.signupController = new SignupApplicationController(); 	//------AppContext.getSignupApplicationController();  da rimuovere (?)		
	 }
	
	 @FXML
	 private TextField emailField;
	 @FXML
	 private PasswordField passwordField;
	 @FXML
	 private PasswordField repPasswordField;
	 @FXML
	 private TextField nameField;
	 @FXML
	 private TextField surnameField;
	 
	 
	 @FXML
	 private ChoiceBox<String> choiceBoxRole;
	 @FXML
	 private ChoiceBox<String> choiceBoxTeam;
	 
	 
	 @FXML
	 public void initialize() {			// metodo chiamato automaticamente dal meccanismo di caricamento dell’FXML
		 
		 if (choiceBoxRole != null && choiceBoxTeam !=null) {
		 	// Crea una lista di valori 	
			choiceBoxRole.setItems(FXCollections.observableArrayList(signupController.getRoles()));		
		 	choiceBoxTeam.setItems(FXCollections.observableArrayList("Inter", "Milan"));				//-------------caricarli da TeamDAO (?)
		 }																//-------Squadre che diventano grigie quando scelgo un ruolo (coach) già occupato per la squadra  
		 
		/* // Imposta un valore di default
		 comboBoxValori.setValue("Valore1");*/
	    }
	
	@FXML
    private void openLogin(ActionEvent event) throws IOException{

		// Ottieni il parent stage (homepage) attraverso il proprietario della finestra di signup
		String fxmlPath = "/application/view/login.fxml";
		String title = "Login";
		Stage signupStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Stage parentStage = (Stage) signupStage.getOwner();			
       	
       	OpenWindowUtils.openFXMLWindow(fxmlPath, title, signupStage, parentStage, true);
    }
	
	
    private void openSignUpDetails(ActionEvent event) throws IOException{

		// Ottieni il parent stage (homepage) attraverso il proprietario della finestra di signup
    	String fxmlPath = "/application/view/signupDetails.fxml";
        String title = "Profile";
		Stage signupStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Stage parentStage = (Stage) signupStage.getOwner();		
       	
       	OpenWindowUtils.openFXMLWindow(fxmlPath, title, signupStage, parentStage, true);  	
    }
    
    
	@FXML
	 private void handleCreateAccount(ActionEvent event) {
	        // Acquisisci i dati dalla View
	        String email = emailField.getText();
	        String password = passwordField.getText();				//------come aggiungere "occhio" per vedere password inserita
	        String repPassword = repPasswordField.getText();

	    try {
	        // Invia i dati al Controller Applicativo  
	        boolean isRegistered = signupController.register(email, password, repPassword);	

	        // Aggiorna la View in base al risultato
	        if (isRegistered) {
	        	openSignUpDetails(event);
	        }
	   } catch (ValidationException ve) {
	            // Gestione specifica per errori di validazione
		   AlertUtils.showAlert(Alert.AlertType.ERROR, "Sign Up Error", ve.getMessage());
	   } catch (Exception e) {
	            // Gestione generica per tutte le altre eccezioni
		   AlertUtils.showAlert(Alert.AlertType.ERROR, "Error", "Something went wrong, try again.");
	   }
	}
	
	
	@FXML
	 private void handleConfirm(ActionEvent event) {
		 // Acquisisci i dati dalla View
        String name = nameField.getText();
        String surname = surnameField.getText();
        String role = choiceBoxRole.getValue();
        String team = choiceBoxTeam.getValue();
        
     try {
     // Invia i dati al Controller Applicativo
        boolean isConfirmed = signupController.confirm(name, surname, role, team);	
        
     // Aggiorna la View in base al risultato
        if (isConfirmed) {
        	// Lancio schermata in base al ruolo	
        	String userRole = signupController.getUserRole();
        	OpenWindowUtils.openRoleView(event, userRole);			
        }
     } catch (ValidationException ve) {
         // Gestione specifica per errori di validazione
    	 AlertUtils.showAlert(Alert.AlertType.ERROR, "Sign Up Error", ve.getMessage());
     } catch (DAOException dae) {
    	 	// Gestione specifica per errori di DAO
    	 AlertUtils.showAlert(Alert.AlertType.ERROR, "Error saving", dae.getMessage());
     } catch (Exception e) {
         // Gestione generica per tutte le altre eccezioni
    	 AlertUtils.showAlert(Alert.AlertType.ERROR, "Error", "Something went wrong, try again.");
     }   
	}
}
