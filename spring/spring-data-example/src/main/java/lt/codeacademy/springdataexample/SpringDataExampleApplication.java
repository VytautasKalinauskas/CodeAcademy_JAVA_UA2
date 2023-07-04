package lt.codeacademy.springdataexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity
public class SpringDataExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataExampleApplication.class, args);
	}

}
