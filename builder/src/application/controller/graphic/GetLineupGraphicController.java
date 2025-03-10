package application.controller.graphic;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import application.controller.application.GetLineupApplicationController;
import application.controller.application.UserApplicationController;
import application.exception.DAOException;
import application.exception.LineupException;
import application.view.observer.GUIObserver;
import application.view.utils.AlertUtils;
import application.view.utils.LineupLayoutUtils;
import application.view.utils.OpenWindowUtils;
import application.view.utils.TeamColorUtils;
import application.view.utils.TeamColorUtils.TeamColors;
import application.view.utils.UserInterfaceHelper;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class GetLineupGraphicController {
	
	private UserApplicationController coachController;			
	private GetLineupApplicationController lineupController;
	
	 public GetLineupGraphicController() {
		 this.coachController = new UserApplicationController(); 
		 this.lineupController = new GetLineupApplicationController();
	 }
	 

	private List<Label> shirtPlayers;
	private List<Label> roleLabels;
	private List<StackPane> panePlayers;
	private List<ChoiceBox<String>> choiceBoxPlayers;
	
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
	
	
	@FXML private ChoiceBox<String> choiceBoxPlayer1;
	@FXML private ChoiceBox<String> choiceBoxPlayer2;
	@FXML private ChoiceBox<String> choiceBoxPlayer3;
	@FXML private ChoiceBox<String> choiceBoxPlayer4;
	@FXML private ChoiceBox<String> choiceBoxPlayer5;
	@FXML private ChoiceBox<String> choiceBoxPlayer6;
	@FXML private ChoiceBox<String> choiceBoxPlayer7;
	@FXML private ChoiceBox<String> choiceBoxPlayer8;
	@FXML private ChoiceBox<String> choiceBoxPlayer9;
	@FXML private ChoiceBox<String> choiceBoxPlayer10;
	@FXML private ChoiceBox<String> choiceBoxPlayer11;
	
	@FXML
	private ChoiceBox<String> choiceBoxFormation;
	@FXML
    private ChoiceBox<String> choiceBoxPlayStyle;
	@FXML
    private ChoiceBox<String> choiceBoxMarking;
	
	@FXML
    private ImageView teamLogoImage;
	
	@FXML
    private Label successRateLabel;

    @FXML
    private Label nameLabel;
    
    @FXML private RadioButton radioButton1;
    @FXML private RadioButton radioButton2;
    @FXML private RadioButton radioButton3;
    @FXML private ToggleGroup group1;
    

	@FXML
	private void initialize() {
		
		String userName = coachController.getUserName();
    	String userSurname = coachController.getUserSurname();
    	String teamName = coachController.getUserTeam();
    	
    	UserInterfaceHelper.initializeUserInfo(nameLabel, teamLogoImage, userName, userSurname, teamName);
    	
    	List<Label> namePlayers;
    	
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
	    
	    // Lista per le choiceBox dei giocatori
	    choiceBoxPlayers = Arrays.asList(
            choiceBoxPlayer1, choiceBoxPlayer2, choiceBoxPlayer3, choiceBoxPlayer4, choiceBoxPlayer5, choiceBoxPlayer6, choiceBoxPlayer7, choiceBoxPlayer8, choiceBoxPlayer9, choiceBoxPlayer10, choiceBoxPlayer11    
        );
        
	    
	    // Imposta colori "maglie"
	    setTeamColors(teamName);
	    
	    // Popola le choiceBoxPlayer con i giocatori della squadra		
	    setTeamPlayers(teamName);
	    
	    // Collega ogni choiceBoxPlayer alla sua Label corrispondente
        for (int i = 0; i < choiceBoxPlayers.size(); i++) {
        	bindChoiceBoxToLabel(choiceBoxPlayers.get(i), namePlayers.get(i));
        }
	    
	    
	    choiceBoxFormation.setItems(FXCollections.observableArrayList(lineupController.getFormationList()));		
        choiceBoxFormation.setOnAction(e -> updateFormationAndRoles(teamName));
        choiceBoxFormation.setValue(lineupController.getFormation(teamName));
		
        
        // Imposta lineup salvata
        setTeamLineup(teamName);
        
        // Inizializzazione choiceBoxPlayStyle e Marking
        choiceBoxPlayStyle.setItems(FXCollections.observableArrayList(lineupController.getPlayStyleList()));
        choiceBoxMarking.setItems(FXCollections.observableArrayList(lineupController.getMarkingList()));
       
        choiceBoxPlayStyle.setValue(lineupController.getPlayStyle(teamName));
        choiceBoxMarking.setValue(lineupController.getMarkingType(teamName));
        
        
        // Inizializza radioButton 
        int selectedOption;
		try {
			selectedOption = lineupController.getMyTeamIs(teamName);
		
        
			switch(selectedOption) {
			case 1:
				group1.selectToggle(radioButton1);
				radioButton2.setDisable(true);
				radioButton3.setDisable(true);
				break;
			case 2:
				group1.selectToggle(radioButton2);
				radioButton1.setDisable(true);
				radioButton3.setDisable(true);
				break;
			case 3:
				group1.selectToggle(radioButton3);
				radioButton1.setDisable(true);
				radioButton2.setDisable(true);
				break;
			default:
				group1.selectToggle(radioButton3);
                break;
			}
		} catch (LineupException le) {
			AlertUtils.showAlert(Alert.AlertType.WARNING, null, le.getMessage());
			openRoleHomeFromInit();
		}
        
        // Registra l'observer GUI al SuccessRateCalculator 
        lineupController.getSuccessRateCalculator().registerObserver(new GUIObserver(successRateLabel));
        
        // Listener: ogni volta che cambia un valore, aggiorna il success rate
        choiceBoxFormation.valueProperty().addListener((obs, oldVal, newVal) -> updateSuccessRate());
        choiceBoxPlayStyle.valueProperty().addListener((obs, oldVal, newVal) -> updateSuccessRate());
        choiceBoxMarking.valueProperty().addListener((obs, oldVal, newVal) -> updateSuccessRate());
        
        for (int i = 0; i < choiceBoxPlayers.size(); i++) {
        	choiceBoxPlayers.get(i).valueProperty().addListener((obs, oldVal, newVal) -> updateSuccessRate());
        }
        
        // Imposta un valore inziale per labelSuccessRate
        updateSuccessRate();
	}
	
	
	@FXML
	private void handleSaveLineup(MouseEvent event) throws IOException { 		
		// Salva tutti i valori 
		String formation = choiceBoxFormation.getValue();
		String playStyle = choiceBoxPlayStyle.getValue();
		String markingType = choiceBoxMarking.getValue();
		String teamName = coachController.getUserTeam();
				
		List<String> players = new ArrayList<>();
		
        for (ChoiceBox<String> choiceBox : choiceBoxPlayers) {
            players.add(choiceBox.getValue());
        }
		
        boolean isUpdated;
        
		try {
			isUpdated = lineupController.saveLineup(teamName, formation, playStyle, markingType, players);
		
			if (isUpdated) {
        	AlertUtils.showAlert(Alert.AlertType.INFORMATION, null, "Lineup saved successfully");
        	openRoleHome(event);
			} 
		} catch (LineupException le) {
			AlertUtils.showAlert(Alert.AlertType.WARNING, null, le.getMessage());
		} catch (DAOException dae) {
			AlertUtils.showAlert(Alert.AlertType.ERROR, "Error saving", dae.getMessage());
	   }
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
	 
	 
	 @FXML													
     private void getBestLineup(MouseEvent event) throws IOException {
		
		 List<String> tactics;
		 
		try {
			tactics = lineupController.getBestLineup(coachController.getUserTeam());
		
			// Set delle ChoiceBox
			choiceBoxFormation.setValue(tactics.get(0));
			choiceBoxPlayStyle.setValue(tactics.get(1));
			choiceBoxMarking.setValue(tactics.get(2));
		 
			// Set dei Footballer nelle choiceBoxPlayers
			for (int i = 0; i < choiceBoxPlayers.size(); i++) {
				choiceBoxPlayers.get(i).setValue(tactics.get(3 + i));
			}
		 
		} catch (LineupException le) {
			AlertUtils.showAlert(Alert.AlertType.WARNING, null, le.getMessage());
			openRoleHome(event);
		}
         
		 AlertUtils.showAlert(Alert.AlertType.INFORMATION, null, "Best lineup inserted");
	 }
	 
	
	 @FXML
     private void comingSoonBtn(MouseEvent event) {
    	 AlertUtils.comingSoonAlert();
     }
	
	
	private void updateFormationAndRoles(String teamName) {		
		
		 String formation = choiceBoxFormation.getValue();
		 List<Point2D> coords = LineupLayoutUtils.getCoordinates(formation);
		 List<String> roles = lineupController.getRequiredRoles(formation);
		 
		 if (coords == null || coords.size() < 11) {
			 AlertUtils.showAlert(Alert.AlertType.ERROR, null, "Few parameters coords. Please contact the administrator");
			 openRoleHomeFromInit();
		 }
		 
		 if (roles == null || roles.size() < 11) {
			 AlertUtils.showAlert(Alert.AlertType.ERROR, null, "Few parameters roles. Please contact the administrator");
			 openRoleHomeFromInit();
		 }
		
		// Assegna coordinate
		for (int i = 0; i < shirtPlayers.size(); i++) {
		    Label shirt = shirtPlayers.get(i);
		    StackPane name = panePlayers.get(i);
		    Point2D point = coords.get(i);
		    

		    // Posizionamento nome 
		    name.setLayoutX(point.getX());
		    name.setLayoutY(point.getY());
		  
		    // Posizionamento maglia
		    shirt.setLayoutX(point.getX() + 44);	
		    shirt.setLayoutY(point.getY() - 32);    
		}
		
		
		// Assegna i ruoli alle label
	    for (int i = 0; i < roleLabels.size(); i++) {
	        roleLabels.get(i).setText(roles.get(i));
	    }
	    
	    // Popola la ChoiceBox per i giocatori in base al ruolo richiesto
	    setTeamPlayers(teamName);
	    
	    // Popola la ChoiceBox con startingLineup
	    setTeamLineup(teamName);	    
	}
	
	 // Assegna colori alla maglie
	 private void setTeamColors(String teamName) {
	        // Colori per il Team
	        TeamColors colors = TeamColorUtils.getTeamColors(teamName);
	        // Stile CSS con i colori ottenuti
	        String style = "-fx-background-color: linear-gradient(to bottom, " 
	                		+ colors.getFirstColor() + " 50%, " + colors.getSecondColor() + " 50%); "
	                		+ "-fx-border-color: " + colors.getThirdColor() + "; "
	                		+ "-fx-border-width: 3;"
	                		+ "-fx-background-radius: 20;"
	                		+ "-fx-border-radius: 20;";
	        // Imposta lo stile per ogni label
	        for (Label label : shirtPlayers) {
	            label.setStyle(style);
	        }
	    }
	 
	 
	 // Popola le choiceBoxPlayer con i giocatori della squadra
	 private void setTeamPlayers(String teamName) {
		 // Popola la ChoiceBox per i giocatori in base al ruolo richiesto
		 for (int i = 0; i < choiceBoxPlayers.size(); i++) {
			 populateChoiceBoxForPlayer(choiceBoxPlayers.get(i), roleLabels.get(i).getText(), teamName);
		 }
	 }
	 

	 // Popola una ChoiceBox filtrando la lista dei giocatori in base al ruolo richiesto
	 private void populateChoiceBoxForPlayer(ChoiceBox<String> choiceBox, String roleAcronym, String teamName) {
		 
		 List<String> filteredPlayers =  lineupController.getFootballersByRole(teamName, roleAcronym);
		
		 // Imposta la ChoiceBox con la lista filtrata
		 choiceBox.setItems(FXCollections.observableArrayList(filteredPlayers));
	 }
	 
	 
	 // Aggiorna la label quando cambia la selezione
	 private void bindChoiceBoxToLabel(ChoiceBox<String> choiceBox, Label label) {
		    choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
		        if (newVal != null) {
		            label.setText(lineupController.splitSurname(newVal));
		        }
		    });
	 }
	 
	 
	 // Imposta la lineup di default per una squadra
	 private void setTeamLineup(String teamName) {			
		 try {
		 List<String> lineup = lineupController.getStartingLineup(teamName);
		 
		 if (lineup != null) {
			 for (int i = 0; i < choiceBoxPlayers.size(); i++) {
				 choiceBoxPlayers.get(i).setValue(lineup.get(i));
			 }
		 }
		 } catch (Exception e) {
             e.printStackTrace();
		 }
    
	 }
	 
	 
	 private void updateSuccessRate() {
		 
		 for (int i = 0; i < choiceBoxPlayers.size(); i++) {
		    if (choiceBoxPlayers.get(i).getValue() == null) {
		        Platform.runLater(() -> updateSuccessRate());
		        return;
		    }
		 }
		 
		 // Raccoglie i valori attuali dalle ChoiceBox
		 String formation = choiceBoxFormation.getValue();
		 String playStyle = choiceBoxPlayStyle.getValue();
		 String marking = choiceBoxMarking.getValue();
		 List<String> playerNames = new ArrayList<>();
		 
		 for (int i = 0; i < choiceBoxPlayers.size(); i++) {
			 playerNames.add(choiceBoxPlayers.get(i).getValue());
		 }
		 
		 // Passa i dati al controller applicativo per il calcolo.
		 try {
			lineupController.updateSuccessRate(formation, playStyle, marking, playerNames, coachController.getUserTeam());
		} catch (LineupException le) {
			AlertUtils.showAlert(Alert.AlertType.WARNING, null, le.getMessage());
			openRoleHomeFromInit();
		}
	 }
	 
	 
	 private void openRoleHomeFromInit()  {  
		 
		 String fxmlFile = "coachView.fxml";
		 String title = "Coach Home";
	    	
		 Stage parentStage = (Stage)(nameLabel.getScene().getWindow());
	    	
		 openHome(fxmlFile, title, parentStage);
	 }
	 
	 private void openHome(String fxmlFile, String title, Stage parentStage) {
		 try {
			OpenWindowUtils.openFXMLWindow(fxmlFile, title, null, parentStage, false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }
	 
	 
}
