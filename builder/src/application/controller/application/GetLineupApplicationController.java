package application.controller.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import application.exception.LineupException;
import application.model.bean.Footballer;
import application.model.bean.Lineup;
import application.model.bean.Match;
import application.model.bean.RoleFootballer;
import application.model.config.FormationRoles;
import application.model.dao.DAOFactory;
import application.model.dao.FootballerDAO;
import application.model.dao.LineupDAO;
import application.model.dao.MatchDAO;
import application.model.strategy.*;
import application.obsever.SuccessRateCalculator;
import application.util.Formatter;


public class GetLineupApplicationController {
	private FootballerDAO footballerDAO;
	private LineupDAO lineupDAO;
	private MatchDAO matchDAO;
	private Match nextMatch;
	private List<Footballer> availablePlayers;
	private SuccessRateCalculator rateCalculator;

	public GetLineupApplicationController() {
        this.footballerDAO = DAOFactory.getFootballerDAO();
        this.lineupDAO = DAOFactory.getLineupDAO();
        this.matchDAO = DAOFactory.getMatchDAO();
        this.rateCalculator = new SuccessRateCalculator();		
    }
	
	
	public List<String> getFootballersByRole(String teamName, String role) {
		// Ottieni tutti i giocatori disponibili della squadra
		availablePlayers = getAvailableFootballers(teamName);	
				 
		// Converte la sigla in un valore enum
		RoleFootballer requiredRole = RoleFootballer.valueOf(role.toUpperCase());

		// Filtra i giocatori che hanno un'affinità per il ruolo richiesto 
		List<Footballer> filteredPlayers = availablePlayers.stream()
				.filter(player -> player.getRoleAffinities().stream()
						.anyMatch(ra -> ra.getRole() == requiredRole && ra.getAffinity() > 0))	// valore minimo di affinita
				.collect(Collectors.toList());
		
		// Ritorna la lista dei nomi e cognomi dei giocatori trovati
		return filteredPlayers.stream()
			    .map(f -> f.getName() + " " + f.getSurname())
			    .collect(Collectors.toList());
	}
	
	
	public boolean saveLineup(String teamName, String formation, String playStyle, String markingType, List<String> startingLineup) throws LineupException {
		
		Lineup newLineup = lineupDAO.getFormationByTeam(teamName);
		
		if (formation == null || playStyle == null || markingType == null) {
			throw new LineupException("All fields must be filled");
		}
			
        newLineup.setFormation(formation);
        newLineup.setPlayStyle(playStyle);
        newLineup.setMarkingType(markingType);
        
        Set<String> seenElements = new HashSet<>();
        
        for (String player : startingLineup) {
            if (!seenElements.add(player)) {
                throw new LineupException("Duplicate footballer found: " + player);
            }
        }
        
        newLineup.setStartingLineup(convertNamesToFootballers(startingLineup, teamName));
        
        lineupDAO.updateTactics(newLineup);
        
		return true;
	}
	
	
	// Per settare i radio button 
	public int getMyTeamIs(String teamName) throws LineupException {    
		// Determina il nome della squadra avversaria
		String opponentTeamName = getNextOpponent(teamName);
		
		return getMatchup(teamName, opponentTeamName);
	}
	
	
	public List<String> getBestLineup(String teamName) throws LineupException {	
		// Determina il nome della squadra avversaria
		String opponentTeamName = getNextOpponent(teamName);
		
		// Modulo della squadra avversaria
		String opponentFormation = getFormation(opponentTeamName);
		// Stile di gioco della squadra avversaria
		String opponentPlayStyle = getPlayStyle(opponentTeamName);
		
		// Modulo della nosta squadra 
		String ourTeamFormation = getFormation(teamName);
		// Stile di gioco della nostra squadra
		String ourTeamPlayStyle = getPlayStyle(teamName);
		
		int setStrategy = getMatchup(teamName, opponentTeamName);
        
		// pattern strategy for tactics
		List<String> tactics = determineTactic(setStrategy, opponentFormation, opponentPlayStyle, ourTeamFormation, ourTeamPlayStyle);	
		
		// Scelta Footballer
		tactics.addAll(getBestFootballers(tactics.get(0)));
		
		return tactics;
	}
	
	
	// Metodo che viene chiamato dal controller grafico per aggiornare il success rate.
    public void updateSuccessRate(String formation, String playStyle, String marking, List<String> playerNames, String teamName) throws LineupException {
    	
    	List<Footballer> players = convertNamesToFootballers(playerNames, teamName);
    	List<String> roles = getRequiredRoles(formation);
    	List<String> bestTactics = getBestLineup(teamName); 
    	boolean homeMach = getHomeOrAway(teamName);
    	int opponentStrength = getTeamStrength(getNextOpponent(teamName));
    	List<String> chosenTactics = Arrays.asList(formation, playStyle, marking);
    			
        rateCalculator.calculateAndUpdate(chosenTactics, players, roles, bestTactics, homeMach, opponentStrength);
    }

    
    // Per consentire ai controller grafici di registrare i loro observer
    public SuccessRateCalculator getSuccessRateCalculator() {
        return rateCalculator;
    }
	
    
	public String splitSurname(String playerName) {	
		// Dividi il nome del giocatore in nome e cognome separandolo dal primo spazio
		return Formatter.splitString(playerName);
	}
	
	
	public String getFormation(String teamName) {			
		return lineupDAO.getFormationByTeam(teamName).getFormation() ;	
	}
	
	public List<String> getRequiredRoles(String formation) {   
		return FormationRoles.getRoles(formation);
	}
	
	public List<String> getStartingLineup(String teamName) {        
		List<Footballer> startingLineup = lineupDAO.getFormationByTeam(teamName).getStartingLineup();
		
		return startingLineup.stream()
				.map(f -> f.getName() + " " + f.getSurname())
                .collect(Collectors.toList());
	}
	
	public String getPlayStyle(String teamName) {        
		return lineupDAO.getFormationByTeam(teamName).getPlayStyle();
	}
	
	public String getMarkingType(String teamName) {        
        return lineupDAO.getFormationByTeam(teamName).getMarkingType();
    }
	
	public List<String> getFormationList() {		
		return List.of("4-5-1", "4-4-2", "4-3-3", "3-5-2");
	}
	
	public List<String> getPlayStyleList() {		
		return List.of("Counter-Attack", "Tiki-Taka", "Gegenpressing", "Wing Play", "Direct Play", "Park the Bus", "Total Football");
	}
	
	public List<String> getMarkingList() {
		return List.of("Zonal", "Man-to-Man");
	}
	
	
	public String getNextOpponent(String teamName) throws LineupException {        
		// Trova il prossimo match
        nextMatch = matchDAO.getNextMatch(teamName);
                        
        if (nextMatch == null) {            
        	throw new LineupException("Upcoming match details missing. The trainer has been notified");  //---------sollecitare il trainer a inserire il nextMatch
        }
        
        // Determina il nome della squadra avversaria
        return nextMatch.getOpponent(teamName);
	}
	
	
	private int getTeamStrength(String teamName) {
        // Ottieni la lista dei giocatori della squadra
        List<Footballer> teamPlayers = footballerDAO.getFootballersByTeam(teamName);
       /* if (teamPlayers == null || teamPlayers.isEmpty()) {		
            System.out.println("Nessun giocatore trovato per la squadra " + teamName);
            return 0;
        }*/
        
     // Calcola la forza media: somma degli overallRating diviso per il numero dei giocatori
        double totalRating = teamPlayers.stream()
                .mapToDouble(Footballer::getOverallRating)
                .sum();
        
        return (int)  Math.round(totalRating / teamPlayers.size());
    }
	
	
	private boolean getHomeOrAway(String teamName) {
		return nextMatch.getMatchLocation(teamName);
	}
	
	
	private int getMatchup(String teamName, String opponentTeamName) {    
		// Forza della squadra avversaria
		int opponentStrength = getTeamStrength(opponentTeamName);
		// Forza della nostra squadra
		int ourTeamStrength = getTeamStrength(teamName);
		
		int diff = opponentStrength - ourTeamStrength;
		
		if (getHomeOrAway(teamName)) {
			diff += -2; 	// plays on home
		} else {
			diff += 2;		// plays on away
		}
		
		if (diff >= -3 && diff <= 3) {
			// Team di uguale forza
			return 3;	
		} else if (diff > 3) {
			// Il nostro team è più debole
			return 2;
		} else { // diff < -3, il nostro team è più forte
			return 1;
		}
	}
	
	// Strategy
	private List<String> determineTactic(int setStrategy, String opponentFormation, String opponentPlayStyle, String ourTeamFormation, String ourTeamPlayStyle) {
		 
		TacticContext context = new TacticContext();
	        
		if (setStrategy == 3) {
			// Team di uguale forza
			context.setStrategy(new EvenMatchStrategy(opponentFormation, opponentPlayStyle, ourTeamFormation, ourTeamPlayStyle));		
		} else if (setStrategy == 2) {
			// Il nostro team è più debole
			context.setStrategy(new WeakerMatchStrategy(opponentFormation, opponentPlayStyle, ourTeamFormation));
		} else { // Il nostro team è più forte
			context.setStrategy(new StrongerMatchStrategy(opponentFormation, opponentPlayStyle, ourTeamFormation));
		}
	        
		return context.getSuggestedTactic();
	}
	
	
	private List<String> getBestFootballers(String formation) {    
		
		List<String> requiredRoles = getRequiredRoles(formation);    // prendo i ruoli dalla formazione scelta
		
		 // Classe locale per rappresentare un candidato per un determinato ruolo
        class Candidate {
            int roleIndex;         // indice del ruolo nella lista requiredRoles
            Footballer footballer;
            double value;          // valore readyToPlay per quel ruolo

            Candidate(int roleIndex, Footballer footballer, double value) {
                this.roleIndex = roleIndex;
                this.footballer = footballer;
                this.value = value;
            }
        }

        // Costruisci la lista di tutti i candidati.
        List<Candidate> candidates = new ArrayList<>();
        for (int i = 0; i < requiredRoles.size(); i++) {
            String role = requiredRoles.get(i);
            for (Footballer f : availablePlayers) {
                // Calcola il valore ready to play per il ruolo specificato
                double value = f.getReadyToPlay(role);
                candidates.add(new Candidate(i, f, value));
            }
        }

        // Ordina i candidati in ordine decrescente di valore
        Collections.sort(candidates, (c1, c2) -> Double.compare(c2.value, c1.value));

        // Array per tenere traccia dell'assegnazione: per ogni ruolo l'oggetto Footballer selezionato
        Footballer[] assignment = new Footballer[requiredRoles.size()];
        // Set per ricordare quali giocatori sono già stati assegnati
        Set<Footballer> usedPlayers = new HashSet<>();

        // Assegna, in ordine dei candidati (migliori prima), il giocatore al ruolo se non è già usato
        for (Candidate candidate : candidates) {
            if (assignment[candidate.roleIndex] == null && !usedPlayers.contains(candidate.footballer)) {
                assignment[candidate.roleIndex] = candidate.footballer;
                usedPlayers.add(candidate.footballer);
            }
        }

        // Costruisci la lista di output, con "nome surname" per ogni ruolo
        List<String> lineup = new ArrayList<>();
        for (Footballer f : assignment) {
            if (f != null) {
                lineup.add(f.getName() + " " + f.getSurname());
            } else {
                lineup.add("No player"); // oppure lascia una stringa vuota
            }
        }
        return lineup;
    }


	private List<Footballer> getAvailableFootballers(String teamName) {        
		return footballerDAO.getFootballersByTeam(teamName).stream()
				  .filter(player -> player.getDeployable() == 1)
				  .collect(Collectors.toList());
	}

	
	private List<Footballer> convertNamesToFootballers(List<String> playerNames, String teamName) {
		
		List<Footballer> allFootballers = footballerDAO.getFootballersByTeam(teamName);
		
		 return playerNames.stream()
	                .map(name -> {
	                    String[] parts = name.split(" ");
	                    if (parts.length < 2) return null; 
	                    String firstName = parts[0].trim();
	                    String lastName = splitSurname(name);
	                    // Cerca il Footballer che ha nome e cognome corrispondenti
	                    return allFootballers.stream()
	                            .filter(f -> f.getName().equalsIgnoreCase(firstName)
	                                    && f.getSurname().equalsIgnoreCase(lastName))
	                            .findFirst()
	                            .orElse(null);
	                })
	                .filter(f -> f != null) // Rimuove eventuali null
	                .collect(Collectors.toList());
	}

}
