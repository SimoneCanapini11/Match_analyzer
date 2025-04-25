package application.model.strategy;

import java.util.List;

public class TacticContext implements TacticManager {
	 private TacticStrategy strategy;

	 	@Override
	    public void setStrategy(TacticStrategy strategy) {
	        this.strategy = strategy;
	    }

	 	@Override
	    public List<String> getSuggestedTactic() {
	        if(strategy == null) {
	            throw new IllegalStateException("The strategy has not been set.");		
	        }
	        return strategy.suggestTactics();
	    }
}
