package application.controller.graphic;


import java.io.IOException;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import application.controller.application.ScheduleMatchApplicationController;
import application.controller.application.UserApplicationController;
import application.exception.TrainerException;
import application.view.utils.AlertUtils;
import application.view.utils.MyCustomDateConverter;
import application.view.utils.OpenWindowUtils;
import application.view.utils.UserInterfaceHelper;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;



public class ScheduleMatchGraphicController {
	
	private UserApplicationController trainerController;
	private ScheduleMatchApplicationController scheduleController;
	 
	 public ScheduleMatchGraphicController() {
		 this.trainerController = new UserApplicationController(); 	
		 this.scheduleController = new ScheduleMatchApplicationController();
	 }
	 
	 private List<Label> matchDates;
	 private List<Label> matchHours;
	 private List<Label> homeTeams;
	 private List<Label> awayTeams;
	 private List<ImageView> homeLogos;
	 private List<ImageView> awayLogos;
	 
	 @FXML
	 private Label nameLabel;
	 
	 @FXML
	 private ImageView teamLogoImage;

	 @FXML
	 private DatePicker matchDate;
	 
	 @FXML
	 private Spinner<Integer> hourSpinner;

	 @FXML
	 private Spinner<Integer> minuteSpinner;
	 
	 @FXML
	 private ChoiceBox<String> choiceBoxOpponent;
	 
	 @FXML private RadioButton radioButtonHome;
	 @FXML private RadioButton radioButtonAway;
	 @FXML private ToggleGroup group2;
	 
	 @FXML private Label labelDate1;
	 @FXML private Label labelDate2;
     @FXML private Label labelDate3;
     @FXML private Label labelDate4;
     @FXML private Label labelDate5;
     
     @FXML private Label labelTime1;
     @FXML private Label labelTime2;
     @FXML private Label labelTime3;
     @FXML private Label labelTime4;
     @FXML private Label labelTime5;
     
     @FXML private Label labelHomeTeam1;
     @FXML private Label labelHomeTeam2;
     @FXML private Label labelHomeTeam3;
     @FXML private Label labelHomeTeam4;
     @FXML private Label labelHomeTeam5;
     
     @FXML private Label labelAwayTeam1;
     @FXML private Label labelAwayTeam2;
     @FXML private Label labelAwayTeam3;
     @FXML private Label labelAwayTeam4;
     @FXML private Label labelAwayTeam5;
     
     @FXML private ImageView homeLogo1;
     @FXML private ImageView homeLogo2;
     @FXML private ImageView homeLogo3;
     @FXML private ImageView homeLogo4;
     @FXML private ImageView homeLogo5;
     
     @FXML private ImageView awayLogo1;
     @FXML private ImageView awayLogo2;
     @FXML private ImageView awayLogo3;
     @FXML private ImageView awayLogo4;
     @FXML private ImageView awayLogo5;
	 
	 
	 @FXML
	 public void initialize() {
   	
		 String userName = trainerController.getUserName();
		 String teamName = trainerController.getUserTeam();
		 String userSurname = trainerController.getUserSurname();
	
		 UserInterfaceHelper.initializeLabelImage(nameLabel, teamLogoImage, userName, userSurname, teamName);
		 
		configureDatePicker(); 
		 
		// Converter personalizzato
		matchDate.setConverter(new MyCustomDateConverter());	//--------indip. da view

        // Listener per ogni modifica del testo
		matchDate.getEditor().focusedProperty().addListener((obs, wasFocused, isFocused) -> {
			if (!isFocused) {		       
		        parseEditorText();
		    }
        });
		
	    hourSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 20));
	    minuteSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 45));
	
	    choiceBoxOpponent.setItems(FXCollections.observableArrayList(scheduleController.getOpponentList(teamName)));	
	    
	    
	    matchDates = Arrays.asList(labelDate1, labelDate2, labelDate3, labelDate4, labelDate5);
	    matchHours = Arrays.asList(labelTime1, labelTime2, labelTime3, labelTime4, labelTime5);
	    homeTeams = Arrays.asList(labelHomeTeam1, labelHomeTeam2, labelHomeTeam3, labelHomeTeam4, labelHomeTeam5);
	    awayTeams = Arrays.asList(labelAwayTeam1, labelAwayTeam2, labelAwayTeam3, labelAwayTeam4, labelAwayTeam5);
	    homeLogos = Arrays.asList(homeLogo1, homeLogo2, homeLogo3, homeLogo4, homeLogo5);
	    awayLogos = Arrays.asList(awayLogo1, awayLogo2, awayLogo3, awayLogo4, awayLogo5);
	    
	    updateMatchDisplay(teamName);
	 }
   
   
	 @FXML
	 private void handleSignOut(MouseEvent event) throws IOException {
		 trainerController.signOut();
		 OpenWindowUtils.signOut(event);
	 }
	 
	 @FXML
	 private void comingSoonBtn(MouseEvent event) {
		 AlertUtils.comingSoonAlert();
	 }
	   
   
	 @FXML
	 private void openRoleHome(MouseEvent event) throws IOException {
		 OpenWindowUtils.openTrainerHome(event);
	 }
   
	 @FXML
	 private void openMatchSchedule(MouseEvent event) throws IOException {         
         OpenWindowUtils.openScheduleMatch(event);
     }
	 
	 
	@FXML
	private void saveMatch(MouseEvent event) throws IOException {         
         
		 LocalDate selectedDate = matchDate.getValue();
		 
		 int hour = hourSpinner.getValue();
    	 int minute = minuteSpinner.getValue();
    	 LocalTime selectedTime = LocalTime.of(hour, minute);
    	 
    	 String opponent = choiceBoxOpponent.getValue();
    	 
    	 Toggle selectedToggle = group2.getSelectedToggle();
    	    
    	 if (selectedToggle == null) {
    		 AlertUtils.showAlert(Alert.AlertType.WARNING, null, "Select Home or Away location");
    		 return;
    	 }
    	 
    	 RadioButton selectedRadio = (RadioButton) selectedToggle;
		 String selectedRadioValue = selectedRadio.getText(); 
		 
    	 int isSaved;
		try {
			isSaved = scheduleController.saveMatch(trainerController.getUserTeam(), selectedDate, selectedTime, opponent, selectedRadioValue);
		 
			if (isSaved == 0) {				
				AlertUtils.showAlert(Alert.AlertType.INFORMATION, null, "Match saved successfully!");
			} else {
				AlertUtils.showAlert(Alert.AlertType.INFORMATION, null, "Match updated successfully!");
			}
			openRoleHome(event);
			
		} catch (TrainerException te) {
			AlertUtils.showAlert(Alert.AlertType.WARNING, null, te.getMessage());
		}
     }
	 
   
	private void configureDatePicker() {
	    matchDate.setPromptText("dd/MM/yy"); 

	    // Unica DayCellFactory che fa entrambe le cose
	    matchDate.setDayCellFactory(datePicker -> new DateCell() {
	        @Override
	        public void updateItem(LocalDate item, boolean empty) {
	            super.updateItem(item, empty);

	            // Pulisci eventuali stili o disabilitazioni precedenti
	            getStyleClass().remove("weekend-cell");
	            setDisable(false);
	            setStyle(null);

	            if (!empty && item != null) {
	                // 1) Disabilita date precedenti a oggi
	                if (item.isBefore(LocalDate.now())) {
	                    setDisable(true);
	                    setStyle("-fx-background-color: #eeeeee;");
	                }

	                // 2) Aggiungi stile ai weekend
	                DayOfWeek day = item.getDayOfWeek();
	                if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
	                    getStyleClass().add("weekend-cell");
	                }
	            }
	        }
	    });
	}

	
	private void parseEditorText() {
	    String newText = matchDate.getEditor().getText();
	    LocalDate parsed = matchDate.getConverter().fromString(newText);
	    if (parsed != null && !parsed.equals(matchDate.getValue())) {
	    	matchDate.setValue(parsed);
	    }
	}
	
	
	private void updateMatchDisplay(String teamName) {
		final String imageTail = "_black";
		
		List<List<String>> upcomingMatches = scheduleController.getNextFiveMatches(teamName);
		
		int numberOfMatches = upcomingMatches.size();

	    for (int i = 0; i < 5; i++) {
	        if (i < numberOfMatches) {
	            List<String> matchData = upcomingMatches.get(i);
	            
	            if (matchData.size() >= 4) {	            	
	            	homeTeams.get(i).setText(matchData.get(0));
	            	UserInterfaceHelper.setImage(homeLogos.get(i), matchData.get(0) + imageTail);
	            	awayTeams.get(i).setText(matchData.get(1));
	            	UserInterfaceHelper.setImage(awayLogos.get(i), matchData.get(1) + imageTail);
	            	matchDates.get(i).setText(matchData.get(2));
	            	matchHours.get(i).setText(matchData.get(3));
	                
	                matchDates.get(i).setVisible(true);
	                matchHours.get(i).setVisible(true);
	                homeTeams.get(i).setVisible(true);
	                awayTeams.get(i).setVisible(true);
	                homeLogos.get(i).setVisible(true);
	                awayLogos.get(i).setVisible(true);
	            } else {
	                // Se la sottolista non contiene abbastanza dati
	            	matchDates.get(i).setVisible(false);
	            	matchHours.get(i).setVisible(false);
	            	homeTeams.get(i).setVisible(false);
	            	awayTeams.get(i).setVisible(false);
	            	homeLogos.get(i).setVisible(false);
	            	awayLogos.get(i).setVisible(false);
	            }
	        } else {
	            // Nascondi le label per gli indici non utilizzati
	        	matchDates.get(i).setVisible(false);
	        	matchHours.get(i).setVisible(false);
	        	homeTeams.get(i).setVisible(false);
	        	awayTeams.get(i).setVisible(false);
	        	homeLogos.get(i).setVisible(false);
	        	awayLogos.get(i).setVisible(false);
	        }
	    }
	}
	
}
