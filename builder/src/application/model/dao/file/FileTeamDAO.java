package application.model.dao.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import application.model.bean.Team;
import application.model.dao.TeamDAO;

public class FileTeamDAO implements TeamDAO {
	
	 private static final String FILE_PATH = "data/teams.csv"; 
	 private static final String HEADER = "nameTeam,stadium,city";
	 
	 public FileTeamDAO() {
	    	FileUtils.ensureFileExists(FILE_PATH, HEADER);
	    }

	@Override
	public Team getTeamByName(String teamName) {		
		Team team = null;
		
		 try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
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
	            e.printStackTrace();
	        }
		 return team;
	}

	@Override
	public List<String> getOpponentList(String teamName) {
		 List<String> opponents = new ArrayList<>();
		 
	        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
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
	            e.printStackTrace();
	        }
	        return opponents;
	}

	@Override
	public List<String> getTeamNameList() {
		 List<String> teams = new ArrayList<>();
		 
	        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
	        	@SuppressWarnings("unused")
	            String header = br.readLine();
	        	
	        	String line;

	            while ((line = br.readLine()) != null) {
	                String[] fields = line.split(",");
	                if (fields.length < 1) continue; 

	                teams.add(fields[0].trim());
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return teams;
	}

}
