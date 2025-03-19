package application.model.dao.full.queries;

public class SQLQueries {

	private SQLQueries() {}
	
	   public static final String FIND_USER_BY_EMAIL =
			   "SELECT * FROM users WHERE email = ?";

	   public static final String INSERT_USER =
		        "INSERT INTO users (email, password, name, surname, role, team) VALUES (?, ?, ?, ?, ?, ?)";

	   public static final String CHECK_COACH_EXISTS =
			   "SELECT COUNT(*) FROM users WHERE role = 'COACH' AND team = ?";
	   
	   public static final String FIND_TEAM_BY_NAME = 
			   "SELECT name_team, stadium, city FROM teams WHERE name_team = ?";
	   
	   public static final String OPPONENT_LIST =
			   "SELECT name_team FROM teams WHERE name_team != ?";
	   
	   public static final String TEAM_NAME_LIST =
			   "SELECT name_team FROM teams";
	   
	   public static final String TEAM_FOOTBALLERS_LIST = 
			   "SELECT id, name, surname, team, dob, " +
               "overall_rating, physical_form, mental_clarity, deployable " +
               "FROM footballers WHERE team = ?";
	   
	   public static final String FOOTBALLER_ROLE_AFFINITIES = 
			   "SELECT footballer_id, role, affinity FROM role_affinities " +
               "WHERE footballer_id IN (SELECT id FROM footballers WHERE team = ?)";

	   public static final String FIND_LINEUP_BY_TEAM =
			   "SELECT id, formation, play_style, marking_type FROM lineups WHERE team = ?";
	   
	   public static final String STARTING_LINEUP =
			 """
	   			SELECT f.id, f.name, f.surname, f.team, f.dob, 
	   			f.overall_rating, f.physical_form, f.mental_clarity, f.deployable,
	   		    lp.position, r.role, r.affinity
	   		  	FROM lineup_players lp
	   		  	JOIN footballers f ON lp.footballer_id = f.id
	   		  	LEFT JOIN role_affinities r ON f.id = r.footballer_id
	   		  	WHERE lp.lineup_id = ?
	   		  	ORDER BY lp.position
		    """;
	   
	   public static final String UPDATE_LINEUP =
			 """
		        UPDATE lineups
		        SET formation = ?, play_style = ?, marking_type = ?
		        WHERE team = ?
		     """;
	   
	   public static final String DELETE_LINEUP_PLAYERS =
			   "DELETE FROM lineup_players WHERE lineup_id = ?";
	   
	   public static final String FIND_LINEUP_ID = 
			   "SELECT id FROM lineups WHERE team = ?";
	   
	   public static final String FIND_FOOTBALLER_ID =
			   "SELECT id FROM footballers WHERE name = ? AND surname = ? AND team = ?";
	   
	   public static final String INSERT_LINEUP_PLAYERS =
			   "INSERT INTO lineup_players (lineup_id, footballer_id, position) VALUES (?, ?, ?)";
	   
	   public static final String FIND_UPCOMING_MATCHES =
			 """	   			
	   			SELECT * FROM matches
			   	WHERE (match_date > CURRENT_DATE)
	   			OR (match_date = CURRENT_DATE AND match_time > CURRENT_TIME)
			   	ORDER BY match_date ASC, match_time ASC
		     """;
	   
	   public static final String FIND_NEXT_MATCH =
	   		"""
	   			SELECT * FROM matches
	   			WHERE (home_team = ? OR away_team = ?)
	   			AND ((match_date > CURRENT_DATE)
	   			OR (match_date = CURRENT_DATE AND match_time > CURRENT_TIME))
	   			ORDER BY match_date ASC, match_time ASC
	   			LIMIT 1;	   		
	   		""";
	   
	   public static final String FIND_MATCHES_BY_TEAM =
			 """
	   			SELECT * FROM matches
	   			WHERE (home_team = ? OR away_team = ?)
	   			AND ((match_date > CURRENT_DATE)
	   			OR (match_date = CURRENT_DATE AND match_time > CURRENT_TIME))
	   			ORDER BY match_date ASC, match_time ASC
	   		""";
	   
	   public static final String SAVE_MATCH =
			   "INSERT INTO matches (home_team, away_team, match_date, match_time) VALUES (?, ?, ?, ?)";
	   
	   public static final String UPDATE_MATCH =
			   "UPDATE matches " +
			   "SET match_time = ?, home_team = ?, away_team = ? " +
			   "WHERE match_date = ? AND (home_team = ? OR away_team = ?)";
			   
}
