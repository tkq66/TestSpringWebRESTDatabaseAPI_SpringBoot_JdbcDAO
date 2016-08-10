package project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"project", "project.dao", "project.domain", "project.web", "project.service"})*/

// @SpringBootApplication combined @Configuration, @EnableAutoConfiguration, and @ComponentScan.
// Those three annotations could be used if configurations need to be customized, for example
// declaring certain packages to be scanned for the beans to be collected. The @EnableAutoConfiguration
// allows @Autowired to be used and applications.properties to be referenced for datasource.
@SpringBootApplication
public class Application 
{	
	public static void main(String[] args) 
	{
		// These two methods to run app are equivalent.
		
		// 1st method to run app
		// SpringApplication.run(Application.class, args);
		
		// 2nd method to run app
		SpringApplication app = new SpringApplication(Application.class);
		app.run(args);
		
	}
}
