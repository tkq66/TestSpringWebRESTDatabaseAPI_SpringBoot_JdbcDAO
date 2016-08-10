package project.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import project.domain.User;
import project.service.UserJDBCTemplate;

// @Controller is another one of the annotations that tells Spring that this class is a bean, and 
// configure it as such behind the scene, so no configuration file is needed.
@Controller
public class UserController 
{	
	// With auto-wiring, Spring reference the UserJDBCTemplate object that would've otherwise 
	// been initialize inside Beans.xml. Putting @Autowired here means we don't have to create
	// a setter function to inject dependency into this variable, since Spring already
	// took care of all that behind the scene.
	@Autowired
	private UserJDBCTemplate userJDBCTemplate;
	
/*	@Autowired
	public void setUserJDBCTemplate(UserJDBCTemplate userJDBCTemplate) {
		this.userJDBCTemplate = userJDBCTemplate;
	}
*/

	@RequestMapping(value="/user", method=RequestMethod.GET)
	@ResponseBody
	public User greetingJSON(@RequestParam(value="id", required=false, defaultValue="1") String id)
	{
		User obj = this.userJDBCTemplate.getUserById(Integer.parseInt(id));
		return obj;
	}
}
