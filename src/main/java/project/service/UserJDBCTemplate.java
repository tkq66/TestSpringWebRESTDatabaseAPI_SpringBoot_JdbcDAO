package project.service;

import java.util.List;

//import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import project.dao.UserDAO;
import project.domain.User;

// By using @Component annotation, Spring automatically added this class in as a bean 
// and initialize it, that's why UserController can auto-wire its private variable to
// this class. Remember: Bean -> wired -> usable object
@Component
public class UserJDBCTemplate implements UserDAO
{
	// JdbcTemplate doesn't have beans declared in our project, but is instead an object
	// provided by Spring. Since auto-wiring means that Spring will try to find an initialized
	// instanced to reference the object from, the next best thing Spring could do for JdbcTemplate
	// is initialize an instance and set an id to be jdbcTemplateObject. Therefore, using
	// @Autowired on an object can lead to object initialization, therefore constructors and
	// setters aren't really needed when working in Spring framework.
	//
	// The JdbcTemplate takes care of the JDBC connection in the background when initialized,
	// so instead of the traditional way of connecting by starting a driver, establishing
	// a connection with the Connection object, etc., JdbcTemplate does all that. The 
	// jdbcTemplateObject could be used to query and update to the database instead of the
	// traditional way of establishing an SQL string, executing the string, and posting it
	// to the database server. 
	@Autowired
	private JdbcTemplate jdbcTemplateObject;

	// This code snippet would be required if datasource is NOT being referenced by 
	// "applications.properties" file.
	//
	// IF Spring discovered "applications.properties" file (could either be in the src folder or
	// src/main/resources folder) THEN Spring will automatically try to use the values in there,
	// as specified by the property's keys (for example spring.datasource.* will be used to provide
	// the databse's data source). This happens WITHOUT ANY EXTRA CONFIGURATION, Spring does this
	// automatically. 
	//
	// In this case, Spring recognizes that in order to initialize an instance of
	// JdbcTemplate, a datasource is needed, therefore it will try to find reference to that.
	// A DataSource object could be defined and injected, like in the snippet below, or the 
	// datasource from "application.properties" could be used. 
	//
	// Spring knows which direction to go
	// because of context. The context: does the user try to provide their own dependency of the 
	// datasource? (like the snippet below) If a setter or a DataSource variable is present, Spring
	// drops the "application.properties" file. But if it is not present, then Spring goes to the 
	// next best thing, which is the datasource defined inside the "applications.properties" file.
	//
	// It is preferable to define the connection information for the datasource inside the 
	// "application.properties" file for tractability. 
	
	/*	private DataSource dataSource;
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}*/
	
	public void insert(String name, String email)
	{
		String SQLString = "INSERT INTO User (name, email) VALUES (?, ?)";
		jdbcTemplateObject.update(SQLString, name, email);
		return;
	}	
	
	public User getUserById(Integer id)
	{
		String SQLString = "SELECT * FROM User WHERE id = ?";
		User user = jdbcTemplateObject.queryForObject(SQLString,
				new Object[]{id},
				new UserMapper());
		return user;
	}

	public List<User> listUsers()
	{
		return null;
	}
	
	public void deleteUserById(Integer id)
	{
		
	}
	
	public void updateUserEmail(Integer id, String email)
	{
		
	}
}
