package project.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import project.domain.User;

/**
 * 
 * Maps the queried row from the User database to the User model.
 * @author teekay
 *
 */
public class UserMapper implements RowMapper<User> 
{
	public User mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
	      User user = new User(rs.getInt("id"), 
	    		  rs.getString("name"), 
	    		  rs.getString("email"));
	      return user;
	}
}
