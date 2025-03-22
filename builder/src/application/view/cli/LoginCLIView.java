package application.view.cli;

import java.util.Scanner;

import application.controller.application.LoginApplicationController;
import application.exception.ValidationException;

public class LoginCLIView implements CLIView {
	
	private LoginApplicationController loginController;
    private Scanner scanner;

    public LoginCLIView() {
        this.loginController = new LoginApplicationController();
        this.scanner = new Scanner(System.in);
    }

	@Override
	public void start() {
		
			System.out.println("\n==== Login ====");
            System.out.print("Enter email: ");
            String email = scanner.nextLine();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            
            try {
                // Invia i dati al Controller Applicativo
                boolean isAuthenticated = loginController.authenticate(email, password);

                if (isAuthenticated) {
                	// Lancio view in base al ruolo 
                    String userRole = loginController.getUserRole();
                    CLIViewUtils.openRoleView(userRole);
                }

            } catch (ValidationException ve) {
                System.out.println("Login error: " + ve.getMessage());
                System.out.println();
                System.out.println("Enter 1 to open Signup");
                System.out.println("Enter anything else to try logging in again.");
                String choice = scanner.nextLine();
                
                if (choice.equals("1")) {
                	new SignupCLIView().start();           
                } else {
                	start();
                }
                
            } catch (Exception e) {
               CLIViewUtils.openHomepage("Something went wrong, try again.");
            }
	}
	
	
}
