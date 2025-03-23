package application.view.cli;

import java.util.List;

public class CLIViewUtils {
	
	private CLIViewUtils() {}
	
	 public static void openRoleView(String userRole, NavigatorCLI navigator) {
	      // Apri la schermata in base al ruolo dell'utente
	        switch (userRole) {
	            case "coach":
	                navigator.navigateToCoachView();
	                break;
	            case "trainer":
	                navigator.navigateToTrainerView();
	                break;
	            default:
	            	navigator.navigateToHomepage("Role not recognized.");
	        }
	    }

	 
	 
	 public static void printList(List<String> list) {
		 System.out.println("\nAvailable options:");
		 for (String item : list) {
             System.out.println("- " + item);
         }
	 }
	 
	 public static boolean isInvalidOption(String input, List<String> validOptions) {
		    return !validOptions.contains(input);
	 }
	 
}
