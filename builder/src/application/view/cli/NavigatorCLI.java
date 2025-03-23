package application.view.cli;

public interface NavigatorCLI {
	void navigateToLogin();
    void navigateToSignup();
    void navigateToHomepage(String message);
    void navigateToCoachView();
    void navigateToTrainerView();
    void navigateToGetLineupView();
}
