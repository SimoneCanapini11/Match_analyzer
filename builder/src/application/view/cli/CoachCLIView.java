package application.view.cli;

import java.util.Scanner;

import application.controller.application.GetLineupApplicationController;
import application.controller.application.UserApplicationController;
import application.exception.DAOException;

public class CoachCLIView implements CLIView {

	private final NavigatorCLI navigator;
	private Scanner scanner; 
	private UserApplicationController coachController;			
	
	public CoachCLIView(NavigatorCLI navigator) {
		this.navigator = navigator;
		this.scanner = new Scanner(System.in);
		this.coachController = new UserApplicationController();
	}
	
	@Override
	public void start() {
		System.out.println("\n\nWelcome " + coachController.getUserName() + " " + coachController.getUserSurname()
							+ ", " + coachController.getUserTeam());
		
		System.out.println("\n==== Coach View ====");
        System.out.println("1. Get the Lineup");
        System.out.println("2. Manage your Team");
        System.out.println("3. Sign Out");
        System.out.println("4. Exit");
        System.out.print("\nEnter a choice: ");
        
        String choice = scanner.nextLine();
        
        switch (choice) {
            case "1":
            	openGetLineup();
            	break;
            case "2":
            	System.out.println("\nComing soon\n");
            	start();
            	break;
            case "3":
            	handleSignOut();
            	break;
            case "4":
            	System.exit(0);          
            	break;
            default:
                System.out.println("Invalid choice. Please try again.\n");
                start();
        }		
	}
	
	private void handleSignOut() {
        coachController.signOut();
        navigator.navigateToHomepage("Sign out successful");
    }
	
	private void openGetLineup() {
		GetLineupApplicationController lineupController = new GetLineupApplicationController();
    	try {
    		lineupController.getFormation(coachController.getUserTeam());
    	} catch (DAOException dae) {
			System.out.println(dae.getMessage());
			start();
		}
    	
    	navigator.navigateToGetLineupView();
	}

}
