package pl.edu.wszib.gwk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@PropertySource("classpath:db.properties")
@EnableJpaRepositories
public class GwkApplication {

	public static void main(String[] args) {
		SpringApplication.run(GwkApplication.class, args);
	}

}
