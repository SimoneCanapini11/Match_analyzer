package application.config;

import application.controller.application.SignupApplicationController;

public class AppContext {	//classe di contesto che gestisce istanze uniche
	
    private static final SignupApplicationController signupApplicationController = new SignupApplicationController();
    
    //    private static Connection dbConnection;
    
    /*
	static {
        try {
            // Carica il driver se necessario (a seconda della versione di JDBC)
            // Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Inizializza la connessione (sostituisci con i tuoi parametri)
            dbConnection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/nomeDB", "user", "password"
            );
        } catch (SQLException e) {
            e.printStackTrace();
            // Gestione dell'errore: in un'applicazione reale potresti voler terminare l'applicazione o riprovare
        }
    }
     */

    public static SignupApplicationController getSignupApplicationController() {
        return signupApplicationController;
    }
    
    
    /*
	public static Connection getDbConnection() {
        return dbConnection;
     */
}

