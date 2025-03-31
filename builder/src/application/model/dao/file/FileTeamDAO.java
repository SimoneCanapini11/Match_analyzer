package application.model.dao.file;

import java.io.BufferedReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import application.model.bean.Team;
import application.model.dao.TeamDAO;

public class FileTeamDAO implements TeamDAO {
	
	private static final Logger LOGGER = Logger.getLogger(FileTeamDAO.class.getName());
	private static final String READING_ERROR = "Error reading file";
	
	 private String filePath; 
	 private static final String HEADER = "nameTeam,stadium,city";
	 
	 // Predefinito
	 public FileTeamDAO() {
		 filePath = "data/teams.csv";  
		 FileUtils.ensureFileExists(filePath, HEADER);
	 }

	 // Test
	 public FileTeamDAO( String testFilePath) {
		 filePath = testFilePath;
		 FileUtils.ensureFileExists(filePath, HEADER);
	 }
		 
	 
	 
	@Override
	public Team getTeamByName(String teamName) {		
		Team team = null;
		
		 try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			 	@SuppressWarnings("unused")
	            String header = br.readLine();
			 
			 	String line;

	            while ((line = br.readLine()) != null) {
	                String[] fields = line.split(",");

	                if (fields.length < 3) continue; 

	                String name = fields[0].trim();
	                String stadium = fields[1].trim();
	                String city = fields[2].trim();

	                if (name.equalsIgnoreCase(teamName)) {
	                    team = new Team(name, stadium, city); 
	                }
	            }
	        } catch (IOException e) {
	        	LOGGER.log(Level.SEVERE, READING_ERROR, e);
	        }
		 return team;
	}

	@Override
	public List<String> getOpponentList(String teamName) {
		 List<String> opponents = new ArrayList<>();
		 
	        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	        	@SuppressWarnings("unused")
	            String header = br.readLine();
	        	
	        	String line;

	            while ((line = br.readLine()) != null) {
	                String[] fields = line.split(",");
	                if (fields.length < 1) continue; 

	                String name = fields[0].trim();

	                if (!name.equalsIgnoreCase(teamName)) {
	                    opponents.add(name);
	                }
	            }
	        } catch (IOException e) {
	        	LOGGER.log(Level.SEVERE, READING_ERROR, e);	       
	        }
	        return opponents;
	}

	@Override
	public List<String> getTeamNameList() {
		 List<String> teams = new ArrayList<>();
		 
	        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	        	@SuppressWarnings("unused")
	            String header = br.readLine();
	        	
	        	String line;

	            while ((line = br.readLine()) != null) {
	                String[] fields = line.split(",");
	                if (fields.length < 1) continue; 

	                teams.add(fields[0].trim());
	            }
	        } catch (IOException e) {
	        	LOGGER.log(Level.SEVERE, READING_ERROR, e);
	        }
	        return teams;
	}

}
