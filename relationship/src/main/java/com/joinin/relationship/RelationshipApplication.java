package com.joinin.relationship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class RelationshipApplication {

	public static void main(String[] args) {
		SpringApplication.run(RelationshipApplication.class, args);
	}

}
