package application.model.strategy;

import java.util.List;

public interface TacticManager {
	 void setStrategy(TacticStrategy strategy);
	 List<String> getSuggestedTactic();
}
