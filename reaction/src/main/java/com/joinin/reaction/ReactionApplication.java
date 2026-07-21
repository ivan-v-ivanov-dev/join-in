package com.joinin.reaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ReactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactionApplication.class, args);
	}

}
