package application.controller.graphic;


import javafx.scene.input.MouseEvent;

import java.io.IOException;

import application.view.utils.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;


public class HomepageGraphicController {
	  
     @FXML
     private void openWindow(MouseEvent event) throws IOException{
    	 
    	 // Controlla l'ID del bottone per decidere quale finestra aprire
    	    String fxmlFile = "";
    	    String title = "";
    	    final String loginPath = "/application/view/login.fxml";
    	    final String titleLogin = "Login";
    	    final String homepagePath = "/application/view/homepage.fxml";
    	    final String homepageTitle = "Homepage";
    	    
    	    switch (((Node) event.getSource()).getId()) {
    	        case "btnLogin":
    	            fxmlFile = loginPath;
    	            title = titleLogin;
    	            break;
    	        case "BoxGetLineup":
    	            fxmlFile = loginPath;
    	            title = titleLogin;
    	            break;
    	        case "BoxManage":
    	            fxmlFile = loginPath;
    	            title = titleLogin;
    	            break;
    	        case "BoxPerformance":
    	            fxmlFile = loginPath;
    	            title = titleLogin;
    	            break;
    	        case "btnSignUp":
    	            fxmlFile = "/application/view/signup.fxml";
    	            title = "Sign Up";
    	            break;
    	        case "logoImage":
    	        	fxmlFile = homepagePath;
    	        	title = homepageTitle;
    	        	break;
    	        case "btnHome":
    	        	fxmlFile = homepagePath;
    	        	title = homepageTitle;
    	        	break;    	        
    	    }
    	    // Ottenengo lo Stage corrente (cioè la finestra) che contiene l'elemento che ha generato un evento
			Stage parentStage = (Stage)((Node)(event.getSource())).getScene().getWindow();
    	
            // Carica la vista file.fxml
        	if (title.equals("Sign Up") || title.equals("Login")) {
        		OpenWindowUtils.openFXMLWindow(fxmlFile, title, null, parentStage, true);   
        		
        	} 
        	
        	if (title.equals("Homepage")) {
        		OpenWindowUtils.openFXMLWindow(fxmlFile, title, null, parentStage, false);
        	}
     }
     
     
     @FXML
     private void comingSoonBtn(MouseEvent event) {
    	 AlertUtils.comingSoonAlert();
     }
     
}

