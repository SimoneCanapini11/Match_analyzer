package application.model.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EvenMatchStrategy implements TacticStrategy {
	
	private String opponentFormation;
	private String opponentPlayStyle;
	private String ourTeamFormation;
	private String ourTeamPlayStyle;
	    
	public EvenMatchStrategy(String opponentFormation, String opponentPlayStyle, String ourTeamFormation, String ourTeamPlayStyle) {
		this.opponentFormation = opponentFormation;
		this.opponentPlayStyle = opponentPlayStyle;
		this.ourTeamFormation = ourTeamFormation;
		this.ourTeamPlayStyle = ourTeamPlayStyle;
	}
	
	
	@Override
	public List<String> suggestTactics() {
		
		String suggestedFormation = ourTeamFormation;
        String suggestedPlayStyle = adjustPlayStyle(opponentPlayStyle, ourTeamPlayStyle);
        String suggestedMarkingType = TacticUtils.adjustMarkingType(opponentFormation, ourTeamFormation);
        
        return new ArrayList<>(Arrays.asList(suggestedFormation, suggestedPlayStyle, suggestedMarkingType));
	}

	
	private String adjustPlayStyle(String opponentPlayStyle, String ourTeamPlayStyle) {
		
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
		
        return ourTeamPlayStyle;  
	}
}
