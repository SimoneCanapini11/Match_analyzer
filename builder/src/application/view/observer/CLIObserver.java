package application.view.observer;

import application.obsever.Observer;

public class CLIObserver implements Observer {
	
	 @Override
	 public void update(int successRate) {
		 System.out.println("\nSuccess Rate: " + String.format("%d%%", successRate));
	 }
}
