package com.social.reaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ReactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactionApplication.class, args);
    }

}
