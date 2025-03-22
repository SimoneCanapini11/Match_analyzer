package application.view.cli;

import java.util.List;

public class CLIViewUtils {
	
	private CLIViewUtils() {}
	
	 public static void openRoleView(String userRole) {
	        System.out.println("\n Login riuscito! Sei un: " + userRole);
	        
	      // Apri la schermata in base al ruolo dell'utente
	        switch (userRole) {
	            case "coach":
	                new CoachCLIView().start();
	                break;
	            case "trainer":
	                new TrainerCLIView().start();
	                break;
	            default:
	                openHomepage("Role not recognized.");
	        }
	    }

	 public static void openHomepage(String str) {
		 System.out.println();
		 System.out.println(str);
         HomepageCLIView homepageView = new HomepageCLIView();
         homepageView.start();
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
