package application.view.cli;

import java.util.Scanner;

public class HomepageCLIView implements CLIView {
	
	private Scanner scanner; 
	private final NavigatorCLI navigator;
	
	public HomepageCLIView(NavigatorCLI navigator) {
		this.scanner = new Scanner(System.in);
		this.navigator = navigator;
	}
	
	@Override
	public void start() {	
		
			System.out.println("\n==== Homepage ====");
            System.out.println("1. Get the Lineup");
            System.out.println("2. Manage your Team");
            System.out.println("3. Analyze your Performance");
            System.out.println("4. Login");
            System.out.println("5. Sign Up");
            System.out.println("6. Exit");
            System.out.print("\nEnter a choice: ");
            
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":                 
                case "2":
                case "3":
                case "4":
                	new LoginCLIView(navigator).start();
                	break;
                case "5":      
                	new SignupCLIView(navigator).start();                	
                    break;
                case "6":
                	System.exit(0);          
                	break;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
                    start();
            }		
	}
	
}
