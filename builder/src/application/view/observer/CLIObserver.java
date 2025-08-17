package application.view.observer;

import application.observer.Observer;

import application.observer.SuccessRateCalculator;

public class CLIObserver implements Observer {
	
	private SuccessRateCalculator subject;
	
	public CLIObserver(SuccessRateCalculator subject) {
		this.subject = subject;
	}
	
	 @Override
	 public void update() {
		 int observerState = subject.getSuccessRate();
		 System.out.println("\nSuccess Rate: " + String.format("%d%%", observerState));
	 }
}
