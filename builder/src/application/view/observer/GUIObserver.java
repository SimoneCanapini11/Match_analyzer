package application.view.observer;

import application.observer.Observer;
import javafx.scene.control.Label;

public class GUIObserver implements Observer {
	// Label che mostra la success rate nella GUI
	 private Label successRateLabel;
	 private int observerState; 

	    public GUIObserver(Label successRateLabel) {
	        this.successRateLabel = successRateLabel;
	    }

	    @Override
	    public void update(int successRate) {
	    	this.observerState = successRate;
	        successRateLabel.setText(String.format("%d%%", observerState));
	    }
}
