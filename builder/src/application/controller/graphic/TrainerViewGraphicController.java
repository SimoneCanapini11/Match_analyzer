package application.controller.graphic;


import java.io.IOException;



import application.controller.application.UserApplicationController;
import application.view.utils.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


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
	    	
	    	UserInterfaceHelper.initializeUserInfo(nameLabel, teamLogoImage, userName, userSurname, teamName);
	    }
	    
		
	    @FXML
	    private void handleSignOut(MouseEvent event) throws IOException {
	    	
	    	trainerController.signOut();
	    	OpenWindowUtils.signOut(event);
	    }
	    
	    
	    @FXML
	    private void openRoleHome(MouseEvent event) throws IOException {
	    	
	    	OpenWindowUtils.openTrainerHome(event);
	    }
	    
	    
		 @FXML
	     private void comingSoonBtn(MouseEvent event) {
	    	 AlertUtils.comingSoonAlert();
	     }
}

