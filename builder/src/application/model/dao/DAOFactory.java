package application.model.dao;

import application.config.AppConfig;
import application.model.dao.demo.DemoUserDAO;
import application.model.dao.full.FullUserDAO;

public class DAOFactory {
    public static UserDAO getUserDAO() {
        String mode = AppConfig.getInstance().getMode(); // "demo" o "full"
        if ("demo".equals(mode)) {
            return new DemoUserDAO();
        } else {
        	return new FullUserDAO();
            //return new FullUserDAO(getConnection()); // es. per DB
        }
    }
    
    // Analogamente, altri metodi per altri DAO
    
    
}

