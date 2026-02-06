package com.nashtech.observability_pi_shaped;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ObservabilityPiShapedApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObservabilityPiShapedApplication.class, args);
	}

}
