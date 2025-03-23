package application.view.cli;

public class TrainerCLIView implements CLIView {

	private final NavigatorCLI navigator;
	
	public TrainerCLIView(NavigatorCLI navigator) {
        this.navigator = navigator;
    }
	
	@Override
	public void start() {
		System.out.println("Trainer View");
	}
}
