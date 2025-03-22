package application.view.cli;

public class CLIViewNavigator implements NavigatorCLI {

	 @Override
	    public void navigateToLogin() {
	        new LoginCLIView(this).start();
	    }

	    @Override
	    public void navigateToSignup() {
	        new SignupCLIView(this).start();
	    }

	    @Override
	    public void navigateToHomepage(String message) {
	    	System.out.println();
        	System.out.println(message);
	        new HomepageCLIView(this).start();
	    }
}
