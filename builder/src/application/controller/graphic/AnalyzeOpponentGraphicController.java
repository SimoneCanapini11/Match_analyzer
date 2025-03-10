package application.controller.graphic;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import application.controller.application.GetLineupApplicationController;
import application.controller.application.UserApplicationController;
import application.exception.LineupException;
import application.view.utils.AlertUtils;
import application.view.utils.LineupLayoutUtils;
import application.view.utils.OpenWindowUtils;
import application.view.utils.UserInterfaceHelper;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class AnalyzeOpponentGraphicController {
	

	private UserApplicationController coachController;			
	private GetLineupApplicationController lineupController;
	
	 public AnalyzeOpponentGraphicController() {
		 this.coachController = new UserApplicationController(); 
		 this.lineupController = new GetLineupApplicationController();
	 }
	
	 private List<Label> shirtPlayers;
	 private List<Label> roleLabels;
	 private List<StackPane> panePlayers;
	 private List<Label> labelPlayers;
	 private List<Label> namePlayers;
	 
	 @FXML
	 private ImageView teamLogoImage;
	 @FXML
	 private ImageView imageOpponent;

	 @FXML
	 private Label nameLabel;
	 @FXML
     private Label labelOpponent;
	 @FXML
     private Label labelFormation;
	 @FXML
     private Label labelPlayStyle;
	 
	 @FXML private Label shirtPlayer1;
	 @FXML private Label shirtPlayer2;
	 @FXML private Label shirtPlayer3;
	 @FXML private Label shirtPlayer4; 
	 @FXML private Label shirtPlayer5;
	 @FXML private Label shirtPlayer6;
	 @FXML private Label shirtPlayer7;
	 @FXML private Label shirtPlayer8;
	 @FXML private Label shirtPlayer9;
	 @FXML private Label shirtPlayer10;
	 @FXML private Label shirtPlayer11;	
		
		
	 @FXML private Label namePlayer1;
	 @FXML private Label namePlayer2;
	 @FXML private Label namePlayer3;
	 @FXML private Label namePlayer4; 
	 @FXML private Label namePlayer5;
	 @FXML private Label namePlayer6;
	 @FXML private Label namePlayer7;
	 @FXML private Label namePlayer8;
	 @FXML private Label namePlayer9;
	 @FXML private Label namePlayer10;
	 @FXML private Label namePlayer11;
		
	 @FXML private Label rolePlayer1;
	 @FXML private Label rolePlayer2; 
	 @FXML private Label rolePlayer3;
	 @FXML private Label rolePlayer4; 
	 @FXML private Label rolePlayer5;
	 @FXML private Label rolePlayer6;
	 @FXML private Label rolePlayer7;
	 @FXML private Label rolePlayer8;
	 @FXML private Label rolePlayer9;
	 @FXML private Label rolePlayer10;
	 @FXML private Label rolePlayer11;
		
	 @FXML private StackPane panePlayer1;
	 @FXML private StackPane panePlayer2;
	 @FXML private StackPane panePlayer3;
	 @FXML private StackPane panePlayer4;
	 @FXML private StackPane panePlayer5;
	 @FXML private StackPane panePlayer6;
	 @FXML private StackPane panePlayer7;
	 @FXML private StackPane panePlayer8;
	 @FXML private StackPane panePlayer9;
	 @FXML private StackPane panePlayer10;
	 @FXML private StackPane panePlayer11;	 
	 
	 @FXML private Label labelPlayer1;
	 @FXML private Label labelPlayer2;
	 @FXML private Label labelPlayer3;
	 @FXML private Label labelPlayer4; 
	 @FXML private Label labelPlayer5;
	 @FXML private Label labelPlayer6;
	 @FXML private Label labelPlayer7;
	 @FXML private Label labelPlayer8;
	 @FXML private Label labelPlayer9;
	 @FXML private Label labelPlayer10;
	 @FXML private Label labelPlayer11;
	 
	 
	@FXML
	private void initialize() {
		
		String userName = coachController.getUserName();
    	String userSurname = coachController.getUserSurname();
    	String teamName = coachController.getUserTeam();
    	
    	UserInterfaceHelper.initializeUserInfo(nameLabel, teamLogoImage, userName, userSurname, teamName);
    	
    	try {
			String opponentName = lineupController.getNextOpponent(teamName);
			UserInterfaceHelper.setImage(imageOpponent, opponentName + "_black");
			labelOpponent.setText(opponentName);
    	
			// Lista per le “maglie”
			shirtPlayers = Arrays.asList(
					shirtPlayer1, shirtPlayer2, shirtPlayer3, shirtPlayer4, shirtPlayer5, shirtPlayer6, shirtPlayer7, shirtPlayer8, shirtPlayer9, shirtPlayer10, shirtPlayer11
			);
	   
			// Lista per i nomi
			namePlayers = Arrays.asList(
					namePlayer1, namePlayer2, namePlayer3, namePlayer4, namePlayer5, namePlayer6, namePlayer7, namePlayer8, namePlayer9, namePlayer10, namePlayer11
			);
	    
	    
			// Lista per le StackPane dei giocatori
			panePlayers = Arrays.asList(
					panePlayer1, panePlayer2, panePlayer3, panePlayer4, panePlayer5, panePlayer6, panePlayer7, panePlayer8, panePlayer9, panePlayer10, panePlayer11    
			);
	    
			// Lista per i ruoli
			roleLabels = Arrays.asList(
					rolePlayer1, rolePlayer2, rolePlayer3, rolePlayer4, rolePlayer5, rolePlayer6, rolePlayer7, rolePlayer8, rolePlayer9, rolePlayer10, rolePlayer11	
			);
	    
			// Lista per le label dei giocatori
			labelPlayers = Arrays.asList(
					labelPlayer1, labelPlayer2, labelPlayer3, labelPlayer4, labelPlayer5, labelPlayer6, labelPlayer7, labelPlayer8, labelPlayer9, labelPlayer10, labelPlayer11    
			);
	    
			
			// Imposta colori "maglie"
		    LineupLayoutUtils.setTeamColors(opponentName, shirtPlayers);
		    
		   
		    labelFormation.setText(lineupController.getFormation(opponentName));
		    labelPlayStyle.setText(lineupController.getPlayStyle(opponentName));
		    
		    updateFormationAndRoles();
		    
		    setTeamLineup(opponentName);
		    
			
    	} catch (LineupException le) {
			AlertUtils.showAlert(Alert.AlertType.WARNING, null, le.getMessage());
			//-----openHome
		}
	}
    
	
	 @FXML
     private void comingSoonBtn(MouseEvent event) {
    	 AlertUtils.comingSoonAlert();
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
	    	
		 OpenWindowUtils.openLineup(event);
	 }   
	
	private void updateFormationAndRoles() {		
		
		 String formation = labelFormation.getText();
		 List<String> roles = lineupController.getRequiredRoles(formation);
		 
		 LineupLayoutUtils.setFormationAndRoles(formation, shirtPlayers, panePlayers, roleLabels, roles);
	}
	
	 // Imposta la lineup di default per una squadra
	 private void setTeamLineup(String teamName) {			
		 
		 List<String> lineup = lineupController.getStartingLineup(teamName);
		 
		 if (lineup != null) {
			 for (int i = 0; i < labelPlayers.size(); i++) {
				 labelPlayers.get(i).setText(lineup.get(i));
				 namePlayers.get(i).setText(lineupController.splitSurname(lineup.get(i)));
			 }
		 }	
	 }
	
}
