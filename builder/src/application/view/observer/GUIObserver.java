package application.view.observer;

import application.obsever.Observer;
import javafx.scene.control.Label;

public class GUIObserver implements Observer {
	// Label che mostra la success rate nella GUI.
	 private Label successRateLabel;

	    public GUIObserver(Label successRateLabel) {
	        this.successRateLabel = successRateLabel;
	    }

	    @Override
	    public void update(int successRate) {
	        successRateLabel.setText(String.format("%d%%", successRate));
	    }
}
