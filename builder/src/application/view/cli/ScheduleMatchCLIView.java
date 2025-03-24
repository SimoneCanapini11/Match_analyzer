package application.view.cli;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import application.controller.application.ScheduleMatchApplicationController;
import application.controller.application.UserApplicationController;
import application.exception.TrainerException;

public class ScheduleMatchCLIView implements CLIView {
	
	private final NavigatorCLI navigator;
	private UserApplicationController trainerController;
	private ScheduleMatchApplicationController scheduleController;
	private Scanner scanner; 
	
	private static final String CHOICE = "Enter a choice: ";
	private static final String TRY_AGAIN = "Something went wrong, try again.";
	private static final String INVALID_CHOICE = "Invalid choice. Please try again.";
	
	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm");
	
	
	public ScheduleMatchCLIView(NavigatorCLI navigator) {
        this.navigator = navigator;
        this.trainerController = new UserApplicationController();
        this.scheduleController = new ScheduleMatchApplicationController();
        this.scanner = new Scanner(System.in);
    }
	
	@Override
    public void start() {
		String teamName = trainerController.getUserTeam();
		
		System.out.println("\n==== Get Lineup View ====");
        System.out.println("1. Insert Match");
        System.out.println("2. Show next five matches");
        System.out.println("3. Back to Trainer View");        
        System.out.println("4. Sign Out");
        System.out.println("5. Exit");
        System.out.print("\n" + CHOICE);
        
        String choice = scanner.nextLine();
        
        switch (choice) {
            case "1":
            	insertMatch(teamName);
            	break;
            case "2":
            	showMatches(teamName);
            	break;
            case "3":
            	navigator.navigateToTrainerView();
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

	
	private void showMatches(String teamName) {
		
		List<List<String>> upcomingMatches = scheduleController.getNextFiveMatches(teamName);
		
        System.out.println("\n==== Next Five Matches ====\n");
        System.out.printf("%-10s %-10s %-20s %-10s%n", "Home", "Away", "Date", "Time");
        System.out.println("----------------------------------------------------");
        
        for (List<String> match : upcomingMatches) {                        
            System.out.printf("%-10s %-10s %-20s %-10s%n", match.get(0), match.get(1), match.get(2), match.get(3));
        }
        
        navigator.navigateToScheduleMatchView();
	}
	

	private void insertMatch(String teamName) {
		
		System.out.println("\n==== Insert new Match ====");
		
		 // Acquisizione e validazione date
        LocalDate date = null;
        while (date == null) {
            System.out.print("\nEnter match date (dd/MM/yyyy): ");
            String dateInput = scanner.nextLine();
            try {
                date = LocalDate.parse(dateInput, DATE_FORMAT);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use dd/MM/yyyy.");
            }
        }

        // Acquisizione e validazione time
        LocalTime time = null;
        while (time == null) {
            System.out.print("\nEnter match time (HH:mm): ");
            String timeInput = scanner.nextLine();
            try {
                time = LocalTime.parse(timeInput, TIME_FORMAT);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid time format. Please use HH:mm.");
            }
        }
        
        List<String> locations = List.of("Home", "Away");
        
        String matchLocation = null;
        while (matchLocation == null) {
        	CLIViewUtils.printList(locations);
        	System.out.print("\nEnter match location (Home/Away): ");
        	String input = scanner.nextLine();
        	
        	if (!CLIViewUtils.isInvalidOption(input, locations)) {
        		matchLocation = input;
        	} else {
        		System.out.println(INVALID_CHOICE + "\n");
        	}
        }
        
        List<String> opponentsList = scheduleController.getOpponentList(teamName);
        
        String opponent = null;
        while (opponent == null) {
        	CLIViewUtils.printList(opponentsList);
            System.out.print("\nEnter opponent's name: ");
            String input = scanner.nextLine();
            
            if (opponentsList.contains(input)) {
                opponent = input;
            } else {
                System.out.println(INVALID_CHOICE + "\n");            }
        }
        
        int isSaved;
		try {
			isSaved = scheduleController.saveMatch(teamName, date, time, opponent, matchLocation);
		 
			if (isSaved == 0) {		
				System.out.println("\nMatch saved successfully.");                
			} else {
				System.out.println("\nMatch updated successfully.");
			}
			navigator.navigateToScheduleMatchView();
			
		} catch (TrainerException te) {
			System.out.println(te.getMessage());
			start();
		} catch (Exception e) {
			navigator.navigateToHomepage(TRY_AGAIN);
		}

	}

	
	private void handleSignOut() {
        trainerController.signOut();
        navigator.navigateToHomepage("Sign out successful");
    }
}
