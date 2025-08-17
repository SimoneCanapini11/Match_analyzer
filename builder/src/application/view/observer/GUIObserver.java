package application.view.observer;

import application.observer.Observer;
import application.observer.SuccessRateCalculator;
import javafx.scene.control.Label;

public class GUIObserver implements Observer {
	// Label che mostra la success rate nella GUI
	 private Label successRateLabel;
	 private SuccessRateCalculator subject;

	    public GUIObserver(Label successRateLabel, SuccessRateCalculator subject) {
	        this.successRateLabel = successRateLabel;
	        this.subject = subject;
	    }

	    @Override
	    public void update() {
	    	 int observerState = subject.getSuccessRate();
	        successRateLabel.setText(String.format("%d%%", observerState));
	    }
}
