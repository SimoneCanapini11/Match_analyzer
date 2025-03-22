package application.view.cli;

public class CLIViewNavigator {

private static CLIViewNavigator instance = new CLIViewNavigator();
    
    private CLIViewNavigator() {} 

    public static CLIViewNavigator getInstance() {
        return instance;
    }

    public void openLoginView() {
        new LoginCLIView().start();
    }

    public void openSignupView() {
        new SignupCLIView().start();
    }
}
