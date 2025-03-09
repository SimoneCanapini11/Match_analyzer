package application.view.observer;

import application.obsever.Observer;

public class CLIObserver implements Observer {
	
	 @Override
	 public void update(int successRate) {
		 System.out.println("Success Rate updated: " + String.format("%d%%", successRate));
	 }
}
