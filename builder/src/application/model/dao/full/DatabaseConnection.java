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
    private static String dbUrl;
    private static String dbUser;
    private static String dbPassword;
    private static Connection connection;
    
    
    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(PROPERTIES_FILE));

            dbUrl = properties.getProperty("db.url");
            dbUser = properties.getProperty("db.user");
            dbPassword = properties.getProperty("db.password");

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
    
    public static synchronized Connection getConnection() throws SQLException {
        
    	if (connection == null || connection.isClosed()) {
    		connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);            
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
