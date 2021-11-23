package de.eclipse.bookapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ServletComponentScan
@EnableJpaRepositories("de.eclipse.bookapp.repository")
@EntityScan("de.eclipse.bookapp.model")
@SpringBootApplication(scanBasePackages = "de.eclipse")
public class BookCollection {

	public static void main(String[] args) {
		SpringApplication.run(BookCollection.class, args);
	}

}