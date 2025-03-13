package application.controller.graphic;


import java.io.IOException;

import application.controller.application.UserApplicationController;
import application.view.utils.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class TrainerViewGraphicController {

		private UserApplicationController trainerController;				
		 
		 public TrainerViewGraphicController() {
			 this.trainerController = new UserApplicationController(); 			
		 }
		 
		@FXML
	    private ImageView teamLogoImage;

	    @FXML
	    private Label nameLabel;

	    @FXML
	    public void initialize() {
	    	
	    	String userName = trainerController.getUserName();
	    	String userSurname = trainerController.getUserSurname();
	    	String teamName = trainerController.getUserTeam();
	    	
	    	UserInterfaceHelper.initializeLabelImage(nameLabel, teamLogoImage, userName, userSurname, teamName);
	    	
	    	Platform.runLater(() -> checkCoachRequest(teamName));
	    }
	    
		
	    @FXML
	    private void handleSignOut(MouseEvent event) throws IOException {
	   
	    	trainerController.signOut();
	    	OpenWindowUtils.signOut(event);
	    }
	    
	    @FXML
	    private void openMatchSchedule(MouseEvent event) throws IOException {
            
            OpenWindowUtils.openScheduleMatch(event);
        }
	    
	    @FXML
	    private void openRoleHome(MouseEvent event) throws IOException {
	    	
	    	OpenWindowUtils.openTrainerHome(event);
	    }
	    
	    
		 @FXML
	     private void comingSoonBtn(MouseEvent event) {
	    	 AlertUtils.comingSoonAlert();
	     }
		 
		 
		 private void checkCoachRequest(String teamName) {
			 
			 if (!trainerController.nextMatchCoachRequest(teamName)) {
				 AlertUtils.showAlert(Alert.AlertType.WARNING, null, "The coach asked to insert the next match");
				 openScheduleMatchFromInit();
			 }
		 }
		 
		 
		 private void openSchedule(String fxmlFile, String title, Stage parentStage) {
			 try {
				OpenWindowUtils.openFXMLWindow(fxmlFile, title, null, parentStage, false);
			} catch (IOException e) {
				AlertUtils.showAlert(Alert.AlertType.ERROR, "Error", "Something went wrong, try again.");
			}
		 }
		 
		 private void openScheduleMatchFromInit()  {  
			 
			 String fxmlFile = "scheduleMatchView.fxml";
			 String title = "Schedule Upcoming Match";
		    	
			 Stage parentStage = (Stage)(nameLabel.getScene().getWindow());
		    	
			 openSchedule(fxmlFile, title, parentStage);
		 }
}

