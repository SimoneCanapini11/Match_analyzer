package application.model.dao.file;

import application.model.bean.User;
import application.model.dao.UserDAO;

public class FileUserDAO implements UserDAO {

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isCoachAlreadyAssigned(String teamName) {
		// TODO Auto-generated method stub
		return false;
	}

}
