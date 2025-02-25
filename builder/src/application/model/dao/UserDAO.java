package application.model.dao;

import application.model.bean.User;

public interface UserDAO {
	 User findByEmail(String email);
	 void saveUser(User user);
	 // altri metodi
}
