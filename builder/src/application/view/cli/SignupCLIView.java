package application.view.cli;

import java.util.Scanner;

import application.controller.application.SignupApplicationController;
import application.exception.DAOException;
import application.exception.ValidationException;



public class SignupCLIView implements CLIView {
	
	private SignupApplicationController signupController;
    private Scanner scanner;
    private final NavigatorCLI navigator;

    public SignupCLIView(NavigatorCLI navigator) {
    	this.signupController = new SignupApplicationController(); 	
        this.scanner = new Scanner(System.in);
        this.navigator = navigator;
    }

	@Override
	public void start() {
		
		System.out.println("\n==== Sign Up ====");
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        System.out.print("Repeat password: ");
        String repPassword = scanner.nextLine();
        
        try {
        	boolean isRegistered = signupController.register(email, password, repPassword);	

	        if (isRegistered) {
	        	confirmSignup();
	        }
	   } catch (ValidationException ve) {
		   System.out.println("Sign Up error: " + ve.getMessage());
		   System.out.println();
		   start();
		   
	   } catch (DAOException dae) {
		   System.out.println("Error saving: " + dae.getMessage());
		   System.out.println();
		   System.out.println("Enter 1 to open Login");
           System.out.println("Enter anything else to try sign up in again.");
           String choice = scanner.nextLine();
           
           if (choice.equals("1")) {
        	   navigator.navigateToLogin();
           } else {
           	start();
           }
         
	   } catch (Exception e) {
		   navigator.navigateToHomepage("Something went wrong, try again.");
	   }
	}

	private void confirmSignup() {
		System.out.println();
		System.out.println("\n==== Confirm Sign Up ====");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter surname: ");
        String surname = scanner.nextLine();
        
        CLIViewUtils.printList(signupController.getRoles());
        System.out.print("\nEnter role: ");
        String role = scanner.nextLine();
        
        if (CLIViewUtils.isInvalidOption(role, signupController.getRoles())) {
        	System.out.println("Invalid role. Please try again.\n");
            confirmSignup();
            return;
        }
        
        CLIViewUtils.printList(signupController.getTeamNames());
        System.out.print("\nEnter team: ");
        String team = scanner.nextLine();
        
        if (CLIViewUtils.isInvalidOption(team, signupController.getTeamNames())) {
        	System.out.println("Invalid team. Please try again.\n");
            confirmSignup();
            return;
        }
        
        try {
               boolean isConfirmed = signupController.confirm(name, surname, role, team);	
               
               if (isConfirmed) {
               	// Lancio view in base al ruolo	
               	String userRole = signupController.getUserRole();
               	if (userRole.equals("footballer")) {
               		navigator.navigateToHomepage("Coming soon");
               		return;
               	}
                CLIViewUtils.openRoleView(userRole, navigator);		
               }
            } catch (ValidationException ve) {
            	System.out.println("Sign Up confirm error: " + ve.getMessage());
            	System.out.println();
            	confirmSignup();
           	 
            } catch (DAOException dae) {
            	navigator.navigateToHomepage("Error saving: " + dae.getMessage());
                
            } catch (Exception e) {
            	navigator.navigateToHomepage("Something went wrong, try again.");
            }   
        
	}

}
