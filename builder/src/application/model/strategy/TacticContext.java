package application.model.strategy;

import java.util.List;

public class TacticContext {
	 private TacticStrategy strategy;

	    public void setStrategy(TacticStrategy strategy) {
	        this.strategy = strategy;
	    }

	    public List<String> getSuggestedTactic() {
	        if(strategy == null) {
	            throw new IllegalStateException("La strategia non è stata impostata.");		//----eccezione da rivedere
	        }
	        return strategy.suggestTactics();
	    }
}
