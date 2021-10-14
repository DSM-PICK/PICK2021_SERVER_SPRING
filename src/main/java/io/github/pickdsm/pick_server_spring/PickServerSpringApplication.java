package io.github.pickdsm.pick_server_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class PickServerSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PickServerSpringApplication.class, args);
	}

}
