package application.view.observer;

import application.observer.Observer;

public class CLIObserver implements Observer {
	
	private int observerState;
	
	 @Override
	 public void update(int successRate) {
		 this.observerState = successRate;
		 System.out.println("\nSuccess Rate: " + String.format("%d%%", observerState));
	 }
}
