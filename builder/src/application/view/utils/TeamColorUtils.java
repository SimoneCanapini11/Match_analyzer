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

    static {
        // Esempio di mappatura: sostituisci con i dati reali
        teamColorsMap.put("Juventus", new TeamColors("#FFFFFF", "#000000", "#000000")); // bianco, nero, nero(contorno)
        teamColorsMap.put("Milan", new TeamColors("#FF0000", "#000000", "#000000"));     
        teamColorsMap.put("Inter", new TeamColors("#000000", "#0000FF", "#000000"));      
        teamColorsMap.put("Roma", new TeamColors("#FFD700", "#FF0000", 	"#8B0000"));  
        teamColorsMap.put("Napoli", new TeamColors("#12A0D7", "#12A0D7", "#003C82"));
        teamColorsMap.put("Fiorentina", new TeamColors("#482E92", "#482E92", "#FFFFFF"));  
    }

    public static TeamColors getTeamColors(String teamName) {
        // Restituisce i colori associati, oppure colori di default se non trovati
    	return teamColorsMap.getOrDefault(teamName, new TeamColors("#CCCCCC", "#666666", "black"));
    }
}
