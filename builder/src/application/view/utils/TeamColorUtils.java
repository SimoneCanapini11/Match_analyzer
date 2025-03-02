package application.view.utils;

import java.util.HashMap;
import java.util.Map;

public class TeamColorUtils {

	// Classe interna per raggruppare i colori del team
    public static class TeamColors {
        private String firstColor;
        private String secondColor;
        private String thirdColor;

        public TeamColors(String firstColor, String secondColor, String thirdColor) {
            this.firstColor = firstColor;
            this.secondColor = secondColor;
            this.thirdColor = thirdColor;
        }

        public String getFirstColor() {
            return firstColor;
        }

        public String getSecondColor() {
            return secondColor;
        }
        
        public String getThirdColor() {
            return thirdColor;
        }
    }

    // Mappa che associa il nome del team ai colori
    private static final Map<String, TeamColors> teamColorsMap = new HashMap<>();
    
    private static final String WHITE = "#FFFFFF";
    private static final String RED = "#FF0000";
    private static final String BLUE = "#0000FF";
    private static final String YELLOW = "#FFD700";
    private static final String BLACK = "#000000";
    private static final String GRAY = "#CCCCCC";
    private static final String WHITE_BLUE = "#12A0D7";
    private static final String DARK_BLUE = "#003C82";
    private static final String DARK_RED = "#8B0000";;
    private static final String PURPLE = "#482E92";

    static {
        teamColorsMap.put("Juventus", new TeamColors(WHITE, BLACK, BLACK)); // bianco, nero, nero(contorno)
        teamColorsMap.put("Milan", new TeamColors(RED, BLACK, BLACK));     
        teamColorsMap.put("Inter", new TeamColors(BLACK, BLUE, BLACK));      
        teamColorsMap.put("Roma", new TeamColors(YELLOW, RED, DARK_RED));  
        teamColorsMap.put("Napoli", new TeamColors(WHITE_BLUE, WHITE_BLUE, DARK_BLUE));
        teamColorsMap.put("Fiorentina", new TeamColors(PURPLE, PURPLE, WHITE));  
    }

    public static TeamColors getTeamColors(String teamName) {
        // Restituisce i colori associati, oppure colori di default se non trovati
    	return teamColorsMap.getOrDefault(teamName, new TeamColors(GRAY, "#666666", BLACK));
    }
}
