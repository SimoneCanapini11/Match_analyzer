package application.model.strategy;

public class TacticUtils {

	private TacticUtils() {
	    throw new IllegalStateException("TacticUtils class");
	}
	
	public static String adjustMarkingType(String opponentFormation, String ourTeamFormation) {
		
		String[] ourParts = ourTeamFormation.split("-");
        // Prima cifra della formazione
        int ourFirst = Integer.parseInt(ourParts[0]);

        String[] opponentParts = opponentFormation.split("-");
        // Ultima cifra della formazione 
        int opponentLast = Integer.parseInt(opponentParts[opponentParts.length - 1]);
        
        if (ourFirst == opponentLast || (ourFirst == 5 && opponentLast == 3)) {
        	return "Man-to-Man";
        }
        
        return "Zonal";
	}
}
