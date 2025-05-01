package application.model.dao.file;

import java.io.BufferedReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import application.model.bean.Match;
import application.model.dao.MatchDAO;

public class FileMatchDAO implements MatchDAO {
	
	private static final Logger logger = Logger.getLogger(FileMatchDAO.class.getName());
	
	private static final String FILE_PATH = "data/matches.csv";
    private static final String HEADER = "homeTeam,awayTeam,matchDate,matchTime";
    
    public FileMatchDAO() {
    	FileUtils.ensureFileExists(FILE_PATH, HEADER);
    }
    
	@Override
	public List<Match> fetchUpcomingMatches() {
		 List<Match> allMatches = getAllMatches();
		 List<Match> upcomingMatches = new ArrayList<>();
		 LocalDateTime now = LocalDateTime.now();

	        for (Match match : allMatches) {
	            LocalDateTime matchDateTime = LocalDateTime.of(match.getMatchDate(), match.getMatchTime());
	            if (matchDateTime.isAfter(now)) {
	                upcomingMatches.add(match);
	            }
	        }

	        // Match in ordine cronologico
	        upcomingMatches.sort(Comparator.comparing(m -> LocalDateTime.of(m.getMatchDate(), m.getMatchTime())));
	        return upcomingMatches;
	}

	@Override
	public Match fetchNextMatch(String nameTeam) {
		 List<Match> allMatches = getAllMatches();
		 LocalDateTime now = LocalDateTime.now();
		 Match nextMatch = null;

	        for (Match match : allMatches) {
	            LocalDateTime matchDateTime = LocalDateTime.of(match.getMatchDate(), match.getMatchTime());

	            if (matchDateTime.isAfter(now) &&
	                (match.getHomeTeam().equalsIgnoreCase(nameTeam) || match.getAwayTeam().equalsIgnoreCase(nameTeam)) && 
	                isBeforeMatch(nextMatch, matchDateTime)) {
	            
	            		nextMatch = match;
	            }
	        }
	        return nextMatch;
	}

	@Override
	public List<Match> fetchMatchesByTeam(String teamName) {
		 List<Match> allMatches = getAllMatches();
		 List<Match> teamMatches = new ArrayList<>();
		 LocalDateTime now = LocalDateTime.now();

	        for (Match match : allMatches) {
	            LocalDateTime matchDateTime = LocalDateTime.of(match.getMatchDate(), match.getMatchTime());

	            if (matchDateTime.isAfter(now) && 
	                (match.getHomeTeam().equalsIgnoreCase(teamName) || match.getAwayTeam().equalsIgnoreCase(teamName))) {
	                teamMatches.add(match);
	            }
	        }

	        teamMatches.sort(Comparator.comparing(m -> LocalDateTime.of(m.getMatchDate(), m.getMatchTime())));
	        
	        return teamMatches;
	}
	

	@Override
	public void saveMatch(Match match) {
		 try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
	            writer.write(match.getHomeTeam() + "," + match.getAwayTeam() + "," + match.getMatchDate() + "," + match.getMatchTime() + "\n");
	            writer.newLine();
	        } catch (IOException e) {	            
	        	logger.log(Level.SEVERE, "Error saving match to file", e);
	        }
	}

	@Override
	public void updateMatch(Match match, String teamName) {
		  List<Match> matches = getAllMatches();
	        boolean updated = false;

	        for (Match m : matches) {
	            if (m.getMatchDate().equals(match.getMatchDate()) &&
	                (m.getHomeTeam().equalsIgnoreCase(teamName) || m.getAwayTeam().equalsIgnoreCase(teamName))) {
	                
	                // Aggiornamento Match
	                m.setMatchTime(match.getMatchTime());
	                m.setHomeTeam(match.getHomeTeam());
	                m.setAwayTeam(match.getAwayTeam());
	                updated = true;
	                break; 
	            }
	        }

	        if (updated) {
	            overwriteFile(matches); // Riscrive il file con le modifiche
	        }
	}
	
	private List<Match> getAllMatches() {
        List<Match> matches = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
        	@SuppressWarnings("unused")
            String header = br.readLine();
        	
        	String line;
            
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length < 4) continue; 

                Match match = new Match(
                    fields[0].trim(),
                    fields[1].trim(),
                    LocalDate.parse(fields[2].trim()),
                    LocalTime.parse(fields[3].trim())
                );
                matches.add(match);
            }
        } catch (IOException e) {
        	logger.log(Level.SEVERE, "Error reading matches from file", e);
        }
        return matches;
    }
	
	
	private static boolean isBeforeMatch( Match nextMatch, LocalDateTime matchDateTime) {
		return nextMatch == null || matchDateTime.isBefore(LocalDateTime.of(nextMatch.getMatchDate(), nextMatch.getMatchTime()));
	}
	

	  private void overwriteFile(List<Match> matches) {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
	            writer.write("homeTeam,awayTeam,matchDate,matchTime\n"); 
	            for (Match match : matches) {
	                writer.write(match.getHomeTeam() + "," + match.getAwayTeam() + "," + match.getMatchDate() + "," + match.getMatchTime() + "\n");
	            }
	        } catch (IOException e) {
	        	logger.log(Level.SEVERE, "Error writing matches to file", e);
	        }
	    }
}
