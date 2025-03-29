package test;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import application.model.bean.Team;
import application.model.dao.TeamDAO;
import application.model.dao.file.FileTeamDAO;

class TestFileTeamDAO {

	 private static final String TEST_FILE_PATH = "test_teams.csv";
	    private TeamDAO teamDAO;

	    @BeforeEach
	    void setUp() throws IOException {
	        // Creazione di un file CSV temporaneo con dati di test
	        List<String> lines = List.of(
	        	"nameTeam,stadium,city", // header	
	            "Inter,San Siro,Milano",
	            "Milan,San Siro,Milano",
	            "Juventus,Allianz Stadium,Torino",
	            "Roma,Olimpico,Roma"
	        );
	        Files.write(Paths.get(TEST_FILE_PATH), lines);
	        
	        // Inizializza TeamDAO con il file di test
	        teamDAO = new FileTeamDAO(TEST_FILE_PATH);
	    }

	    @AfterEach
	    void tearDown() throws IOException {
	        // Elimina il file di test dopo ogni esecuzione
	        Files.deleteIfExists(Paths.get(TEST_FILE_PATH));
	    }

	    
	    @Test
	    void testGetTeamByName_Found() {
	        Team team = teamDAO.getTeamByName("Inter");
	        assertNotNull(team);
	        assertEquals("Inter", team.getNameTeam());
	        assertEquals("San Siro", team.getStadium());
	        assertEquals("Milano", team.getCity());
	    }
	    
	    @Test
	    void testGetTeamByName_NotFound() {
	        Team team = teamDAO.getTeamByName("Napoli");
	        assertNull(team);
	    }
	    
	    @Test
	    void testGetOpponentList() {
	        List<String> opponents = teamDAO.getOpponentList("Inter");
	        assertEquals(3, opponents.size());
	        assertTrue(opponents.contains("Milan"));
	        assertTrue(opponents.contains("Juventus"));
	        assertTrue(opponents.contains("Roma"));
	        assertFalse(opponents.contains("Inter"));
	    }
	    
	    @Test
	    void testGetTeamNameList() {
	        List<String> teamNames = teamDAO.getTeamNameList();
	        System.out.println(teamNames.size());
	        assertEquals(4, teamNames.size());
	        assertTrue(teamNames.contains("Inter"));
	        assertTrue(teamNames.contains("Milan"));
	        assertTrue(teamNames.contains("Juventus"));
	        assertTrue(teamNames.contains("Roma"));
	    }
}
