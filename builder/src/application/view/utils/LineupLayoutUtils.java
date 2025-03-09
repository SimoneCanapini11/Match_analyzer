package application.view.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.geometry.Point2D;

public class LineupLayoutUtils {		//dominio di layout
	
	private LineupLayoutUtils() {
	    throw new IllegalStateException("LineupLayoutUtils class");
	}
	
	 private static final Map<String, List<Point2D>> FORMATION_COORDS = new HashMap<>();

	    static {
	    	// Definizione coordinate per le formazioni
	        FORMATION_COORDS.put("4-5-1", Arrays.asList(
	        		new Point2D(573, 677), // Name Player 1
	        		new Point2D(443, 579), // Name Player 2
	        		new Point2D(520, 597), // Name Player 3
	        		new Point2D(625, 597), // Name Player 4
	        		new Point2D(702, 579), // Name Player 5
	        		new Point2D(573, 500), // Name Player 6
	        		new Point2D(512, 444), // Name Player 7
	        		new Point2D(633, 444), // Name Player 8
	        		new Point2D(443, 405), // Name Player 9
	        		new Point2D(702, 405), // Name Player 10
	        		new Point2D(570, 281)  // Name Player 11
	        ));
	        
	        FORMATION_COORDS.put("4-4-2", Arrays.asList(
	        		new Point2D(573, 677), // Name Player 1
		            new Point2D(443, 579), // Name Player 2
		            new Point2D(520, 597), // Name Player 3
		            new Point2D(625, 597), // Name Player 4
		            new Point2D(702, 579), // Name Player 5
		            new Point2D(512, 444), // Name Player 6
		            new Point2D(633, 444), // Name Player 7
		            new Point2D(443, 405), // Name Player 8
		            new Point2D(702, 405), // Name Player 9
		            new Point2D(530, 280), // Name Player 10
		            new Point2D(616, 280)  // Name Player 11
	        ));
	        
	        FORMATION_COORDS.put("3-5-2", Arrays.asList(
	        		new Point2D(573, 677), // Name Player 1
		            new Point2D(481, 589), // Name Player 2
		            new Point2D(573, 599), // Name Player 3
		            new Point2D(665, 589), // Name Player 4
		            new Point2D(573, 500), // Name Player 5
		            new Point2D(512, 444), // Name Player 6
		            new Point2D(633, 444), // Name Player 7
		            new Point2D(443, 405), // Name Player 8
		            new Point2D(702, 405), // Name Player 9
		            new Point2D(530, 280), // Name Player 10
		            new Point2D(616, 280)  // Name Player 11
	        ));
	        
	        FORMATION_COORDS.put("4-3-3", Arrays.asList(
	        		new Point2D(573, 677), // Name Player 1
	        		new Point2D(443, 579), // Name Player 2
	        		new Point2D(520, 597), // Name Player 3
	        		new Point2D(625, 597), // Name Player 4
	        		new Point2D(702, 579), // Name Player 5
	        		new Point2D(573, 500), // Name Player 6
	        		new Point2D(512, 444), // Name Player 7
	        		new Point2D(633, 444), // Name Player 8
	        		new Point2D(443, 308), // Name Player 9
	        		new Point2D(702, 308), // Name Player 10
	        		new Point2D(570, 281)  // Name Player 11
	        ));
	        
	    }

	    
	    public static List<Point2D> getCoordinates(String formation) {
	        return FORMATION_COORDS.get(formation);
	    }
	
	    

}
