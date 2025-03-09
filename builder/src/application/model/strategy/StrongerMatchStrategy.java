package application.model.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrongerMatchStrategy implements TacticStrategy {
	
	private String opponentFormation;
	private String opponentPlayStyle;
	private String ourTeamFormation;
	    
	public StrongerMatchStrategy(String opponentFormation, String opponentPlayStyle, String ourTeamFormation) {
		this.opponentFormation = opponentFormation;
		this.opponentPlayStyle = opponentPlayStyle;
		this.ourTeamFormation = ourTeamFormation;
	}
	
	
	@Override
	public List<String> suggestTactics() {
		
		String suggestedFormation = adjustFormation(ourTeamFormation);
        String suggestedPlayStyle = adjustPlayStyle(opponentPlayStyle);
        String suggestedMarkingType = TacticUtils.adjustMarkingType(opponentFormation, ourTeamFormation);

        return new ArrayList<>(Arrays.asList(suggestedFormation, suggestedPlayStyle, suggestedMarkingType));
	}


	private String adjustFormation(String ourTeamFormation) {	//-----aggiungere altri 
		
		if (ourTeamFormation.equals("5-3-2")) {
            return "3-5-2";
        }
        
		if (ourTeamFormation.equals("5-2-2-1")) {
            return "3-4-2-1";
        }
		
		if (ourTeamFormation.equals("4-5-1")) {
            return "4-3-3";
        }
		
        return ourTeamFormation; 
	}


	private String adjustPlayStyle(String opponentPlayStyle) {
		
		if (opponentPlayStyle.equalsIgnoreCase("Counter-Attack")) {
            return "Gegenpressing";
        }
		
		if (opponentPlayStyle.equalsIgnoreCase("Park the Bus")) {
            return "Tiki-Taka";
        }
		
		if (opponentPlayStyle.equalsIgnoreCase("Direct Play")) {
            return "Wing Play";
        }
		
		if (opponentPlayStyle.equalsIgnoreCase("Wing Play")) {
            return "Direct Play";
        }
		
        return "Total Football";  
	}

}
