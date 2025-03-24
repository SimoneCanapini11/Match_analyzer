package application.view.cli;

import java.util.Scanner;

import application.controller.application.UserApplicationController;

public class TrainerCLIView implements CLIView {

	private final NavigatorCLI navigator;
	private UserApplicationController trainerController;	
	private Scanner scanner; 
	
	public TrainerCLIView(NavigatorCLI navigator) {
        this.navigator = navigator;
        this.trainerController = new UserApplicationController();
        this.scanner = new Scanner(System.in);
    }
	
	@Override
	public void start() {
		String teamName = trainerController.getUserTeam();
		
		System.out.println("\n\nWelcome " + trainerController.getUserName() + " " + trainerController.getUserSurname()
		+ ", " + teamName);
		
		checkCoachRequest(teamName);

		System.out.println("\n==== Trainer View ====");
		System.out.println("1. Schedule Match");
		System.out.println("2. Plan Training");
		System.out.println("3. Sign Out");
		System.out.println("4. Exit");
		System.out.print("\nEnter a choice: ");

		String choice = scanner.nextLine();

		switch (choice) {
		case "1":
			openScheduleMatch();
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
	
	private void checkCoachRequest(String teamName) {
		 if (!trainerController.nextMatchCoachRequest(teamName)) {
			 System.out.println("\nThe coach asked to insert the next match");
			 openScheduleMatch();
		 }
	}

	private void openScheduleMatch() {
        navigator.navigateToScheduleMatchView();
    }
	
	private void handleSignOut() {
        trainerController.signOut();
        navigator.navigateToHomepage("Sign out successful");
    }
}
