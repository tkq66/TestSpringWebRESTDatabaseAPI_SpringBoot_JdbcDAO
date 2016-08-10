package project.dao;

import java.util.List;
import project.domain.User;

/**
 * 
 * Data Access Object for the User model.
 * This class acts as an API specific to the User model.
 * @author teekay
 *
 */
public interface UserDAO 
{		
	public void insert(String name, String email);
	
	public User getUserById(Integer id);

	public List<User> listUsers();
	
	public void deleteUserById(Integer id);
	
	public void updateUserEmail(Integer id, String email);
}

