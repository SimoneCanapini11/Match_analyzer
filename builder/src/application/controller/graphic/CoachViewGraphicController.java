package application.controller.graphic;

import java.io.IOException;

import application.controller.application.GetLineupApplicationController;
import application.controller.application.UserApplicationController;
import application.exception.DAOException;
import application.view.utils.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert;


public class CoachViewGraphicController {

	private UserApplicationController coachController;				
	 
	 public CoachViewGraphicController() {
		 this.coachController = new UserApplicationController(); 			
	 }
	 
	@FXML
    private ImageView teamLogoImage;

    @FXML
    private Label nameLabel;

    @FXML
    private void initialize() {
    	
    	String userName = coachController.getUserName();
    	String userSurname = coachController.getUserSurname();
    	String teamName = coachController.getUserTeam();
    	
    	UserInterfaceHelper.initializeUserInfo(nameLabel, teamLogoImage, userName, userSurname, teamName);
    }
    
	
    @FXML
    private void handleSignOut(MouseEvent event) throws IOException {
    	
    	coachController.signOut();
    	OpenWindowUtils.signOut(event);
    }
    
    
    @FXML
    private void openRoleHome(MouseEvent event) throws IOException {
    	
    	OpenWindowUtils.openCoachHome(event);
    }
    
    
    @FXML
    private void openGetLineup(MouseEvent event) throws IOException {
    	
    	GetLineupApplicationController lineupController = new GetLineupApplicationController();
    	try {
    		String teamDetails = lineupController.getFormation(coachController.getUserTeam());
    	} catch (DAOException dae) {
			AlertUtils.showAlert(Alert.AlertType.WARNING, null, dae.getMessage());
			return;
		}
    	
    	OpenWindowUtils.openLineup(event);
    }
    
    
	 @FXML
     private void comingSoonBtn(MouseEvent event) {
    	 AlertUtils.comingSoonAlert();
     }
}
