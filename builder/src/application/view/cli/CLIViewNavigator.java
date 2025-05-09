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

		@Override
		public void navigateToCoachView() {
			new CoachCLIView(this).start();
		}

		@Override
		public void navigateToTrainerView() {
			new TrainerCLIView(this).start();
		}

		@Override
		public void navigateToGetLineupView() {
			new GetLineupCLIView(this).start();
		}

		@Override
		public void navigateToScheduleMatchView() {
			new ScheduleMatchCLIView(this).start();
		}
}
