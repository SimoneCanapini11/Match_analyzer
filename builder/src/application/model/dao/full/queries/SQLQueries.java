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
}
