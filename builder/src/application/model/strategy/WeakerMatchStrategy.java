package application.model.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeakerMatchStrategy implements TacticStrategy {
	
	private String opponentFormation;
	private String opponentPlayStyle;
	private String ourTeamFormation;
	    
	public WeakerMatchStrategy(String opponentFormation, String opponentPlayStyle, String ourTeamFormation) {
		this.opponentFormation = opponentFormation;
		this.opponentPlayStyle = opponentPlayStyle;
		this.ourTeamFormation = ourTeamFormation;
	}
	 
	 
	@Override
	public List<String> suggestTactics() {
		
		String suggestedPlayStyle = adjustPlayStyle(opponentPlayStyle);
		String suggestedFormation = adjustFormation(ourTeamFormation);        
        String suggestedMarkingType = TacticUtils.adjustMarkingType(opponentFormation, ourTeamFormation);

        return new ArrayList<>(Arrays.asList(suggestedFormation, suggestedPlayStyle, suggestedMarkingType));
	}
	
	private String adjustFormation(String ourTeamFormation) {
		
        if (ourTeamFormation.equals("3-5-2")) {
            return "5-3-2";
        }
        
        if (ourTeamFormation.equals("3-4-2-1")) {
            return "5-2-2-1";
        }
        
        if (ourTeamFormation.equals("4-3-3")) {
            return "4-5-1";
        }
        
        return ourTeamFormation;
	}
	
	private String adjustPlayStyle(String opponentPlayStyle) {
		
		if (opponentPlayStyle.equalsIgnoreCase("Direct Play")) {
            return "Wing Play";
        }
		
		if (opponentPlayStyle.equalsIgnoreCase("Wing Play")) {
            return "Direct Play";
        }
		
		if (opponentPlayStyle.equalsIgnoreCase("Tiki-Taka")) {
            return "Park the Bus";
        }
		
        return "Counter-Attack";  
	}

}
