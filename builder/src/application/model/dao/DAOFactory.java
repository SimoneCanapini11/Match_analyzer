package application.model.dao;

import application.config.AppConfig;


import application.model.dao.demo.*;
import application.model.dao.full.*;
import application.model.dao.file.*;

public class DAOFactory {
	
	  private DAOFactory() {}

	private static DAOFactory instance = null;
		
	private static final String MODE_DEMO = "demo";
	private static final String MODE_FILE = "file";  
	private static final String MODE_EXCEPTION = "Mode not initialized!";
	private static String mode = AppConfig.getInstance().getMode(); 
	
	private DemoLineupDAO lineupInstance;	
	private DemoUserDAO userInstance;    
	private DemoMatchDAO matchInstance;	
	
	 public static synchronized DAOFactory getFactoryInstance() {
	        if (instance == null) {
	            instance = new DAOFactory();
	        }
	        return instance;
	    }
	
    public UserDAO getUserDAO() {
    	if (mode == null) {					
            throw new IllegalStateException(MODE_EXCEPTION);
        }
    	if (MODE_DEMO.equals(mode)) { 
    	    if (userInstance == null) {  
    	    	userInstance = new DemoUserDAO();
    	    }
    	    return userInstance;           
    	    
    	} else if (MODE_FILE.equals(mode)) {
    		return new FileUserDAO();
    		
    	} else {
        	return new FullUserDAO();
        }
    }
    
    public TeamDAO getTeamDAO() {
    	if (mode == null) {					
            throw new IllegalStateException(MODE_EXCEPTION);
        }
        if (MODE_DEMO.equals(mode)) {
            return new DemoTeamDAO();
            
        } else if (MODE_FILE.equals(mode)) {
    		return new FileTeamDAO();
    		
    	} else {
        	return new FullTeamDAO();
        }
    } 
    
    public FootballerDAO getFootballerDAO() {
    	if (mode == null) {					
            throw new IllegalStateException(MODE_EXCEPTION);
        }
        if (MODE_DEMO.equals(mode)) {
            return new DemoFootballerDAO();
            
        } else {
        	return new FullFootballerDAO();
        }
    } 
    
    public LineupDAO getLineupDAO() {
    	if (mode == null) {					
            throw new IllegalStateException(MODE_EXCEPTION);
        }
    	if (MODE_DEMO.equals(mode)) { 
    	    if (lineupInstance == null) {  
    	    	lineupInstance = new DemoLineupDAO();
    	    }
    	    return lineupInstance;        
    	    
    	} else {
        	return new FullLineupDAO();
        }
    } 
    
    public MatchDAO getMatchDAO() {
    	if (mode == null) {					
            throw new IllegalStateException(MODE_EXCEPTION);
        }
        if (MODE_DEMO.equals(mode)) {
        	if (matchInstance == null) {  
        		matchInstance = new DemoMatchDAO();
    	    }
    	    return matchInstance;  
    	    
        } else if (MODE_FILE.equals(mode)) {
    		return new FileMatchDAO();
    	} else {
        	return new FullMatchDAO();
        }
    } 
    
}

