package application.controller.graphic;

import java.io.IOException;

import java.util.Arrays;
import java.util.List;

import application.controller.application.UserApplicationController;
import application.view.utils.AlertUtils;
import application.view.utils.LineupLayoutUtils;
import application.view.utils.OpenWindowUtils;
import application.view.utils.UserInterfaceHelper;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LineupGraphicController {
	
	private UserApplicationController coachController;			//--------metodi in comune con altre classi	
	 
	 public LineupGraphicController() {
		 this.coachController = new UserApplicationController(); 			
	 }
	 

	private List<Label> shirtPlayers;
	private List<Label> namePlayers;
	private List<Label> roleLabels;
	
	@FXML
	private Label shirtPlayer1, shirtPlayer2, shirtPlayer3, shirtPlayer4, shirtPlayer5, shirtPlayer6, shirtPlayer7, shirtPlayer8, shirtPlayer9, shirtPlayer10, shirtPlayer11;
	@FXML
	private Label namePlayer1, namePlayer2, namePlayer3, namePlayer4, namePlayer5, namePlayer6, namePlayer7, namePlayer8, namePlayer9, namePlayer10, namePlayer11;
	@FXML
	private Label rolePlayer1, rolePlayer2, rolePlayer3, rolePlayer4, rolePlayer5, rolePlayer6, rolePlayer7, rolePlayer8, rolePlayer9, rolePlayer10, rolePlayer11;
	
	@FXML
	private ChoiceBox<String> choiceBoxFormation;
	
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
    	
	    // Lista per le “maglie”
	    shirtPlayers = Arrays.asList(
	    	shirtPlayer1, shirtPlayer2, shirtPlayer3, shirtPlayer4, shirtPlayer5, shirtPlayer6, shirtPlayer7, shirtPlayer8, shirtPlayer9, shirtPlayer10, shirtPlayer11
	    );

	    // Lista per i nomi
	    namePlayers = Arrays.asList(
	    	namePlayer1, namePlayer2, namePlayer3, namePlayer4, namePlayer5, namePlayer6, namePlayer7, namePlayer8, namePlayer9, namePlayer10, namePlayer11
	    );
	    
	    // Lista per i ruoli
	    roleLabels = Arrays.asList(
	    	rolePlayer1, rolePlayer2, rolePlayer3, rolePlayer4, rolePlayer5, rolePlayer6, rolePlayer7, rolePlayer8, rolePlayer9, rolePlayer10, rolePlayer11	
	    );
	    
	    choiceBoxFormation.setItems(FXCollections.observableArrayList("4-5-1", "4-4-2", "3-5-2", "4-3-3"));
        choiceBoxFormation.setOnAction(e -> updateFormationAndRoles());
        
        //---------formation di default, colori per shirtPlayer
	}
	
	
	  @FXML
	    private void handleSignOut(MouseEvent event) throws IOException {		//--------metodi in comune con altre classi
	    	
	    	coachController.signOut();
	    	
	    	String fxmlFile = "/application/view/homepage.fxml";
	 	    String title = "Homepage";
	 	    
	 	    // Ottenengo lo Stage corrente (cioè la finestra) che contiene l'elemento che ha generato un evento
			Stage parentStage = (Stage)((Node)(event.getSource())).getScene().getWindow();
			
			OpenWindowUtils.openFXMLWindow(fxmlFile, title, null, parentStage, false);
			AlertUtils.showAlert(Alert.AlertType.INFORMATION, null, "Sign out successful");
	    }
	
	
	 @FXML
	    private void openRoleHome(MouseEvent event) throws IOException {		//--------metodi in comune con altre classi
	    	
	    	String fxmlFile = "/application/view/coachView.fxml";
	    	String title = "Coach Home";
	    	
	    	Stage parentStage = (Stage)((Node)(event.getSource())).getScene().getWindow();
	    	
	        OpenWindowUtils.openFXMLWindow(fxmlFile, title, null, parentStage, false);
	    }   
	
	
	 @FXML
     private void comingSoonBtn(MouseEvent event) {
    	 AlertUtils.comingSoonAlert();
     }
	
	
	private void updateFormationAndRoles() {		//----------observer (?)
		
		 String formation = choiceBoxFormation.getValue();
		 List<Point2D> coords = LineupLayoutUtils.getCoordinates(formation);
		 List<String> roles = LineupLayoutUtils.getRoles(formation);
		 
		 if (coords == null || coords.size() < 11) {
			 AlertUtils.showAlert(Alert.AlertType.ERROR, null, "Few parameters coords");
			 return; 				//--------------eccezione da gestire
		 }
		 
		 if (roles == null || roles.size() < 11) {
			 AlertUtils.showAlert(Alert.AlertType.ERROR, null, "Few parameters roles");
			 return;
		 }
		
		// Assegna coordinate
		for (int i = 0; i < shirtPlayers.size(); i++) {
		    Label shirt = shirtPlayers.get(i);
		    Label name = namePlayers.get(i);
		    Point2D point = coords.get(i);

		    // Posizionamento nome 
		    name.setLayoutX(point.getX());
		    name.setLayoutY(point.getY());
		    
		    // Posizionamento maglia
		    shirt.setLayoutX(point.getX() + 14);
		    shirt.setLayoutY(point.getY() - 35);
		}
		
		// Assegna i ruoli alle label
	    for (int i = 0; i < roleLabels.size(); i++) {
	        roleLabels.get(i).setText(roles.get(i));
	    }

	}

}
