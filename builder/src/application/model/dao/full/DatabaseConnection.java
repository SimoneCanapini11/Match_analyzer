package application.model.dao.full;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.IOException;
import java.io.FileInputStream;


public class DatabaseConnection {

	private DatabaseConnection() {} 
	
    private static final String PROPERTIES_FILE = "resources/db.properties";
    private static String DB_URL;
    private static String DB_USER;
    private static String DB_PASSWORD;
    private static Connection connection;
    
    
    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(PROPERTIES_FILE));

            DB_URL = properties.getProperty("db.url");
            DB_USER = properties.getProperty("db.user");
            DB_PASSWORD = properties.getProperty("db.password");

            Class.forName("com.mysql.cj.jdbc.Driver"); 
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        // Chiude la connessione quando l'applicazione termina
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
        	try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }));
    }
    
    public synchronized static Connection getConnection() throws SQLException, IOException {
        
    	if (connection == null || connection.isClosed()) {
    		connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);            
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
