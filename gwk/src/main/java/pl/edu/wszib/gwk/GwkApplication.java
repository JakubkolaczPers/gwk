package pl.edu.wszib.gwk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:db.properties")
public class GwkApplication {

	public static void main(String[] args) {
		SpringApplication.run(GwkApplication.class, args);
	}

}
