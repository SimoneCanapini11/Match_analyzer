package application;

import application.config.AppConfig;
import application.view.cli.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main extends Application {
	
    @Override
    public void start(Stage primaryStage) {
        try {
            // Carica la schermata iniziale (Homepage)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/homepage.fxml"));
            Parent root = loader.load();

            primaryStage.setTitle("Homapage");
            primaryStage.setScene(new Scene(root));
            primaryStage.setMaximized(true); 
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    	try (Scanner scanner = new Scanner(System.in)) {
			String view = "";
			String mode = "";
			
			// Loop per input valido ("cli" o "gui")
			 while (true) {
			     System.out.print("Enter the interface (GUI/CLI): "); 	
			  try {
				  view = scanner.nextLine().trim().toLowerCase();
			  } catch (NoSuchElementException e) {   
			 	 e.printStackTrace();
			  }
			     if ("cli".equals(view) || "gui".equals(view)) {
			         break;
			     } else {
			         System.out.println("Invalid input.");
			     }
			 }
			
			// Loop per input valido ("demo" , "full" o "file")
			while (true) {
			    System.out.print("Enter the mode (demo/full/file): "); 	
			 try {
			    mode = scanner.nextLine().trim().toLowerCase();
			 } catch (NoSuchElementException e) {   
				 e.printStackTrace();
			 }
			    if (isValidMode(mode)) {	
			        break;
			    } else {
			        System.out.println("Invalid input.");
			    }
			}
			
    // Inizializza il contesto globale
			AppConfig.init(mode);      
			
			if ("cli".equals(view)) {
				NavigatorCLI navigator = new CLIViewNavigator();
				new HomepageCLIView(navigator).start();
			} else {
				launch(args);
			}
		}        
    }
    
    private static boolean isValidMode(String mode) {
    	return "demo".equals(mode) || "full".equals(mode) || "file".equals(mode);
    }
}




/*
 1) signup e login (logica e controlli)
 2) gestione eccezioni (con exception handling) (DAOException)   
 3) Interfaccia coach + controller 
 4) Interfaccia trainer + plan training (non intrappolare l'utente) ***
 5) SonarCloud 	**
 6) 
 7) Interfaccia footballer
 8) Regole aziendali (controlli generici) 
 9) Codice duplicato 
 10) 
 11) Interfaccia CLI *
 12) Test ****
 
 */





