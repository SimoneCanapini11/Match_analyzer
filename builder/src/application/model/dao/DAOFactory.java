package application.model.dao;

import application.config.AppConfig;

import application.model.dao.demo.*;
import application.model.dao.full.*;

public class DAOFactory {
	
	private static String mode = AppConfig.getInstance().getMode(); // "demo" o "full"
	
	private static DemoLineupDAO instanceLineup;	// singleton lineupDAO
	private static DemoUserDAO instanceUser;    // singleton userDAO
	
    public static UserDAO getUserDAO() {
    	if (mode == null) {					//-------da gestire
            throw new IllegalStateException("Mode non inizializzato!");
        }
        if ("demo".equals(mode)) { 
        	if (instanceUser == null) {
  		  instanceUser = new DemoUserDAO();
        }	return instanceUser;            
        } else {
        	return new FullUserDAO();
            //return new FullUserDAO(getConnection()); //-- es. per DB
        }
    }
    
    public static TeamDAO getTeamDAO() {
    	if (mode == null) {					//-------da gestire
            throw new IllegalStateException("Mode non inizializzato!");
        }
        if ("demo".equals(mode)) {
            return new DemoTeamDAO();
        } else {
        	return new FullTeamDAO();
            //return new FullUserDAO(getConnection()); //-- es. per DB
        }
    } 
    
    public static FootballerDAO getFootballerDAO() {
    	if (mode == null) {					//-------da gestire
            throw new IllegalStateException("Mode non inizializzato!");
        }
        if ("demo".equals(mode)) {
            return new DemoFootballerDAO();
        } else {
        	return new FullFootballerDAO();
            //return new FullUserDAO(getConnection()); //-- es. per DB
        }
    } 
    
    public static LineupDAO getLineupDAO() {
    	if (mode == null) {					//-------da gestire
            throw new IllegalStateException("Mode non inizializzato!");
        }
        if ("demo".equals(mode)) {
        	  if (instanceLineup == null) {
        		  instanceLineup = new DemoLineupDAO();
              }	return instanceLineup;
        } else {
        	return new FullLineupDAO();
            //return new FullUserDAO(getConnection()); //-- es. per DB
        }
    } 
}

