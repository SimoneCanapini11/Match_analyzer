package application.model.dao;

import application.config.AppConfig;


import application.model.dao.demo.*;
import application.model.dao.full.*;
import application.model.dao.file.*;

public class DAOFactory {
	
	  private DAOFactory() {
		    throw new IllegalStateException("DAOFactory class");
	  }

	
	private static final String MODE_DEMO = "demo";
	private static final String MODE_FILE = "file";  
	private static final String MODE_EXCEPTION = "Mode not initialized!";
	private static String mode = AppConfig.getInstance().getMode(); // "demo" o "full"
	
	private static DemoLineupDAO instanceLineup;	// singleton lineupDAO
	private static DemoUserDAO instanceUser;    // singleton userDAO
	private static DemoMatchDAO instanceMatch;
	
    public static synchronized UserDAO getUserDAO() {
    	if (mode == null) {					
            throw new IllegalStateException(MODE_EXCEPTION);
        }
    	if (MODE_DEMO.equals(mode)) { 
    	    if (instanceUser == null) {  
    	    	instanceUser = new DemoUserDAO();
    	    }
    	    return instanceUser;           
    	    
    	} else if (MODE_FILE.equals(mode)) {
    		return new FileUserDAO();
    	} else {
        	return new FullUserDAO();
            //return new FullUserDAO(getConnection()); //-- es. per DB
        }
    }
    
    public static TeamDAO getTeamDAO() {
    	if (mode == null) {					
            throw new IllegalStateException(MODE_EXCEPTION);
        }
        if (MODE_DEMO.equals(mode)) {
            return new DemoTeamDAO();
        } else if (MODE_FILE.equals(mode)) {
    		return new FileTeamDAO();
    	} else {
        	return new FullTeamDAO();
            //return new FullUserDAO(getConnection()); //-- es. per DB
        }
    } 
    
    public static FootballerDAO getFootballerDAO() {
    	if (mode == null) {					
            throw new IllegalStateException(MODE_EXCEPTION);
        }
        if (MODE_DEMO.equals(mode)) {
            return new DemoFootballerDAO();
        } else if (MODE_FILE.equals(mode)) {
    		return new FileFootballerDAO();
    	}else {
        	return new FullFootballerDAO();
            //return new FullUserDAO(getConnection()); //-- es. per DB
        }
    } 
    
    public static synchronized LineupDAO getLineupDAO() {
    	if (mode == null) {					
            throw new IllegalStateException(MODE_EXCEPTION);
        }
    	if (MODE_DEMO.equals(mode)) { 
    	    if (instanceLineup == null) {  
    	    	instanceLineup = new DemoLineupDAO();
    	    }
    	    return instanceLineup;        
    	    
    	} else if (MODE_FILE.equals(mode)) {
    		return new FileLineupDAO();
    	}else {
        	return new FullLineupDAO();
            //return new FullUserDAO(getConnection()); //-- es. per DB
        }
    } 
    
    public static MatchDAO getMatchDAO() {
    	if (mode == null) {					
            throw new IllegalStateException(MODE_EXCEPTION);
        }
        if (MODE_DEMO.equals(mode)) {
        	if (instanceMatch == null) {  
        		instanceMatch = new DemoMatchDAO();
    	    }
    	    return instanceMatch;   
        } else if (MODE_FILE.equals(mode)) {
    		return new FileMatchDAO();
    	}else {
        	return new FullMatchDAO();
            //return new FullUserDAO(getConnection()); //-- es. per DB
        }
    } 
    
}

