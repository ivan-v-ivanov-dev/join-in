package com.joinin.group;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class GroupApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroupApplication.class, args);
	}

}
