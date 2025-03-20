package application;

import application.config.AppConfig;

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
    	Scanner scanner = new Scanner(System.in);
        String mode = "";
        
     // Loop per input valido ("demo" , "full" o "file")
        while (true) {
            System.out.print("Enter the mode (demo/full/file): "); 	//---------anche per interfaccia javaFX o CLI (?)
         try {
            mode = scanner.nextLine().trim().toLowerCase();
         } catch (NoSuchElementException e) {   
        	 e.printStackTrace();
         }
            if ("demo".equals(mode) || "full".equals(mode) || "file".equals(mode)) {
                break;
            } else {
                System.out.println("Invalid input.");
            }
        }
        
     // Inizializza il contesto globale
        AppConfig.init(mode);      
        
        scanner.close(); // Letture da tastiera terminate
                
        launch(args);
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
 10) Persistenza (DB + CSV) 
 11) Interfaccia CLI *
 12) Test ****
 
 */





