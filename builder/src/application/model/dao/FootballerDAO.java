package application.model.dao;

import application.model.bean.Footballer;
import java.util.List;

public interface FootballerDAO {
	List<Footballer> getFootballersByTeam(String teamName);
}
