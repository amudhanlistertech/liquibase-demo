package amudhan.liquibase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@SpringBootApplication
public class LiquibaseDemoApplication {

	public static void main(String[] args) {
		new EmbeddedDatabaseBuilder().setName("customerdb").setType(EmbeddedDatabaseType.H2)
				.addScript("classpath:/script.sql").build();
		SpringApplication.run(LiquibaseDemoApplication.class, args);
	}
}
