package application.controller.graphic;

import java.io.IOException;

import application.controller.application.UserApplicationController;
import application.view.utils.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CoachViewGraphicController {

	private UserApplicationController coachController;				//-----------controller generico per tutti i ruoli (?)
	 
	 public CoachViewGraphicController() {
		 this.coachController = new UserApplicationController(); 			
	 }
	 
	@FXML
    private ImageView teamLogoImage;

    @FXML
    private Label nameLabel;

    @FXML
    public void initialize() {
    	
    	String userName = coachController.getUserName();
    	String userSurname = coachController.getUserSurname();
    	String teamName = coachController.getUserTeam();
    	
    	UserInterfaceHelper.initializeUserInfo(nameLabel, teamLogoImage, userName, userSurname, teamName);
    }
    
	
    @FXML
    private void handleSignOut(MouseEvent event) throws IOException {
    	
    	coachController.signOut();
    	
    	String fxmlFile = "/application/view/homepage.fxml";
 	    String title = "Homepage";
 	    
 	    // Ottenengo lo Stage corrente (cioè la finestra) che contiene l'elemento che ha generato un evento
		Stage parentStage = (Stage)((Node)(event.getSource())).getScene().getWindow();
		
		OpenWindowUtils.openFXMLWindow(fxmlFile, title, null, parentStage, false);
		AlertUtils.showAlert(Alert.AlertType.INFORMATION, null, "Sign out successful");
    }
    
    
    @FXML
    private void openRoleHome(MouseEvent event) throws IOException {
    	
    	String fxmlFile = "/application/view/coachView.fxml";
    	String title = "Coach Home";
    	
    	Stage parentStage = (Stage)((Node)(event.getSource())).getScene().getWindow();
    	
        OpenWindowUtils.openFXMLWindow(fxmlFile, title, null, parentStage, false);
    }
    
    
	 @FXML
     private void comingSoonBtn(MouseEvent event) throws IOException {
    	 AlertUtils.comingSoonAlert();
     }
}
