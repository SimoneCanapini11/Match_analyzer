package application.view.cli;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import application.controller.application.GetLineupApplicationController;
import application.controller.application.UserApplicationController;
import application.exception.DAOException;
import application.exception.LineupException;
import application.observer.SuccessRateCalculator;
import application.view.observer.CLIObserver;



public class GetLineupCLIView implements CLIView {

	private final NavigatorCLI navigator;
	private Scanner scanner; 
	private UserApplicationController coachController;	
	private GetLineupApplicationController lineupController;
	
	private static final String CHOICE = "Enter a choice: ";
	private static final String INVALID_CHOICE = "Invalid choice. Please try again.";
	private static final String TRY_AGAIN = "Something went wrong, try again.";
	
	
	public GetLineupCLIView(NavigatorCLI navigator) {
        this.navigator = navigator;
        this.scanner = new Scanner(System.in);
        this.coachController = new UserApplicationController();
        this.lineupController = new GetLineupApplicationController();
        
        SuccessRateCalculator calculator = lineupController.getSuccessRateCalculator();
        CLIObserver cliObserver = new CLIObserver(calculator);
        calculator.registerObserver(cliObserver);
    }
	
	@Override
	public void start() {		
		// Set all team
		setTeam(coachController.getUserTeam());
		
		System.out.println("\n==== Get Lineup View ====");
        System.out.println("1. Show Lineup");
        System.out.println("2. Analyze Opponent");
        System.out.println("3. Back to Coach View");        
        System.out.println("4. Sign Out");
        System.out.println("5. Exit");
        System.out.print("\n" + CHOICE);
        
        String choice = scanner.nextLine();
        
        switch (choice) {
            case "1":
            	showLineup();
            	break;
            case "2":
            	showOpponent();
            	break;
            case "3":
            	navigator.navigateToCoachView();
            	break;
            case "4":
            	handleSignOut();
            	break;
            case "5":
            	System.exit(0);          
            	break;
            default:
                System.out.println(INVALID_CHOICE + "\n");
                start();
        }
	}
	

	private void showOpponent() {
		
		try {
			String opponentName = lineupController.getNextOpponent(coachController.getUserTeam());
			String opponentFormation = lineupController.getFormation(opponentName);
			String opponentPlayStyle = lineupController.getPlayStyle(opponentName);
			
			System.out.println("\n\n==== Opponent Lineup ====");
			System.out.println("\nTeam: " + opponentName + ", Formation: " + opponentFormation
                            + ", Play Style: " + opponentPlayStyle);			
            List<String> opponetLineup = lineupController.getStartingLineup(opponentName);
            System.out.println("\nOpponent starting Lineup: \n");
            printLineupInFormationStyle(opponentFormation, opponetLineup);
            
            System.out.println("\n");
    		System.out.println("1. Return to Lineup");
            System.out.println("2. Back to Get Lineup View");
            System.out.println("3. Exit");
            System.out.print("\n" + CHOICE);
            
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                	showLineup();
                	break;
                case "2":
                	navigator.navigateToGetLineupView();
                	break;
                case "3":
                	System.exit(0);          
                	break;
                default:
                	System.out.println(INVALID_CHOICE + "\n");
                    showOpponent();
            }		
			
		} catch (LineupException le) {
			System.out.println(le.getMessage());
			showLineup();
		} catch (Exception e) {
			navigator.navigateToHomepage(TRY_AGAIN);
		}
		
	}
	

	private void showLineup() {
		String teamName = coachController.getUserTeam(); 
		String formation = lineupController.getFormation(teamName);
		String playStyle = lineupController.getPlayStyle(teamName);
		String markingType = lineupController.getMarkingType(teamName);
		
		System.out.println("\n\n==== Lineup ====");
		System.out.println("\nTeam: " + teamName + ", Formation: " + formation
							+ ", Play Style: " + playStyle + ", Marking Type: " + markingType);
		List<String> lineup = lineupController.getStartingLineup(teamName);
		System.out.println("\nStarting Lineup: \n");
		printLineupInFormationStyle(formation, lineup);
        
        updateSuccessRate(teamName, lineup);
		
		System.out.println("\n");
		System.out.println("1. Save Lineup");
        System.out.println("2. Get best Lineup");
        System.out.println("3. Back to Get Lineup View");
        System.out.println("4. Exit");
        System.out.print("\n" + CHOICE);
        
        String choice = scanner.nextLine();
        
        switch (choice) {
            case "1":
            	handleSaveLineup(formation, playStyle, markingType, lineup);
            	System.out.println("Lineup saved successfully");
            	navigator.navigateToCoachView();
            	break;
            case "2":
            	showBestLineup();
         		System.out.println("Best lineup inserted");
            	showLineup();
            	break;
            case "3":
            	navigator.navigateToGetLineupView();
                break;
            case "4":
            	System.exit(0);          
            	break;
            default:
            	System.out.println(INVALID_CHOICE + "\n");
                showLineup();
        }		
		
	}
	
	
    private void handleSaveLineup(String formation, String playStyle, String markingType, List<String> lineup) {
    	
    	String teamName = coachController.getUserTeam();     	
    	boolean isUpdated;
    	
    	try {
			isUpdated = lineupController.saveLineup(teamName, formation, playStyle, markingType, lineup);
		
			if (isUpdated) {
				System.out.println();
			} 
		} catch (LineupException le) {
			System.out.println(le.getMessage());
			showLineup();
			
		} catch (DAOException dae) {
			System.out.println(dae.getMessage());
			start();
			
		} catch (Exception e) {
			navigator.navigateToHomepage(TRY_AGAIN);
		}
        
    }
    
    
    private void showBestLineup() {
    	
    	 List<String> tactics;
		 
 		try {
 			tactics = lineupController.computeBestLineup(coachController.getUserTeam());
 		
 			System.out.println("Best formation: " + tactics.get(0));
 			System.out.println("Best Play Style: " + tactics.get(1));
 			System.out.println("Best Marking Type: " + tactics.get(2));
 			
 			List<String> lineup = new ArrayList<>();
 		 
 			// Set dei Footballer 
 			lineup.addAll(tactics.subList(3, 3 + 11));
 			System.out.println("\nBest Lineup: " +  String.join(" - ", lineup));
 			
 			handleSaveLineup(tactics.get(0), tactics.get(1), tactics.get(2), lineup);
 			
 		} catch (LineupException le) {
 			System.out.println(le.getMessage());
			showLineup();
 		}
    }
	
	
	private void handleSignOut() {
        coachController.signOut();
        navigator.navigateToHomepage("Sign out successful");
    }
	
	
	private void setTeam(String teamName) {
		
		String formation = lineupController.getFormation(teamName);
		List<String> roles = lineupController.getRequiredRoles(formation);
		
		for (int i = 0; i < 11; i++) {
			lineupController.getFootballersByRole(teamName, roles.get(i));
		}
	}
	
	
    private void updateSuccessRate(String teamName, List<String> lineup) {
    	
    	String formation = lineupController.getFormation(teamName);
    	String playStyle = lineupController.getPlayStyle(teamName);
    	String marking = lineupController.getMarkingType(teamName);	
       
    	 // Passa i dati al controller applicativo per il calcolo
		 try {
			lineupController.updateSuccessRate(formation, playStyle, marking, lineup, teamName);
			
		} catch (LineupException le) {
			System.out.println();
			System.out.println(le.getMessage());
			navigator.navigateToCoachView();
		
		} catch (Exception e) {
			navigator.navigateToHomepage(TRY_AGAIN);
		}
    }
    
    private void printLineupInFormationStyle(String formation, List<String> lineup) {
    	 String[] parts = formation.split("-");
    	    int numGroups = parts.length; 

    	    int[] groupCounts = new int[numGroups];
    	    for (int i = 0; i < numGroups; i++) {
    	        groupCounts[i] = Integer.parseInt(parts[i]);
    	    }
    	    
    	    // Portiere 
    	    System.out.println(lineup.get(0));
    	    
    	    // Altri footballer
    	    int index = 1;
    	    for (int i = 0; i < numGroups; i++) {
    	        // Lista subgroup
    	        List<String> groupPlayers = new ArrayList<>();
    	        for (int j = 0; j < groupCounts[i]; j++) {
    	            groupPlayers.add(lineup.get(index));
    	            index++;
    	        }
    	        System.out.println(String.join(" - ", groupPlayers));
    	    }
    }
}
