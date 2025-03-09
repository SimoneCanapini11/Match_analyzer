package application.obsever;

import java.util.List;

import application.model.bean.Footballer;

public class SuccessRateCalculator extends Subject {
	
	 private int successRate;

	 public int getSuccessRate() {
		 return successRate;
	 }

	 public void setSuccessRate(int newSuccessRate) {
		 this.successRate = newSuccessRate;
		 // Notifica tutti gli observer registrati
		 notifyObservers(successRate);
	 }
	 
	 
	 // Metodo per calcolare il success rate 	  				
	 public void calculateAndUpdate(String formation, String playStyle, String marking, List<Footballer> players, 
			 						List<String> roles, List<String> bestTactics, boolean homeMatch, int opponentStrength) {
	        
		 // Inizializza il penalty a 0.
	        double tacticPenalty = 0.0;
	        // Punti di penalty (applicati se diversi da bestTactics)
	        double formationPenaltyWeight = 5.0;
	        double playStylePenaltyWeight = 3.0;
	        double markingPenaltyWeight = 2.0;

	        // Confronta i valori inseriti con quelli migliori.
	        if (!formation.equalsIgnoreCase(bestTactics.get(0))) {
	            tacticPenalty += formationPenaltyWeight;
	        }
	        if (!playStyle.equalsIgnoreCase(bestTactics.get(1))) {
	            tacticPenalty += playStylePenaltyWeight;
	        }
	        if (!marking.equalsIgnoreCase(bestTactics.get(2))) {
	            tacticPenalty += markingPenaltyWeight;
	        }
	        
	        // Forza media dei giocatori basata sul loro "ready to play".
	        double totalReady = 0;
	        // Per ogni Footballer calcola il proprio ready-to-play per un ruolo specifico.
	        for (int i = 0; i < players.size(); i++) {
	            totalReady += players.get(i).getReadyToPlay(roles.get(i));
	        }
	        
	        double ourTeamStrength = ((totalReady / players.size()) * 100) - 10 ;
	        
	        // Base rate
	        double baseRate = opponentStrength > 0 ? Math.min(((ourTeamStrength / opponentStrength) * 100), 100) - 15 : 0;
	        
	        // Applica il penalty 
	        double adjustedRate = baseRate - tacticPenalty;

	        // Home or away
	        double homeFactor = homeMatch ? 1.03 : 0.97;
	        adjustedRate *= homeFactor;

	        int calculatedRate = (int) Math.round(adjustedRate);
	        
	        successRate = Math.max(0, Math.min(calculatedRate, 100));

	        // Notifica gli observer
	        notifyObservers(successRate);
	    }	 
}
