package com.social.model.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import static com.social.model.config.ConfigConstants.MONGO_CLIENT_CREATED;
import static com.social.model.config.ConfigConstants.MONGO_TEMPLATE_CREATED;

@Configuration
@Slf4j
public class MongoConfig {

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;
    @Value("${spring.data.mongodb.database}")
    private String database;

    @Bean
    public MongoClient mongoClient() {
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(mongoUri))
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        log.info(MONGO_CLIENT_CREATED);
        return mongoClient;
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient(), database);
        log.info(MONGO_TEMPLATE_CREATED);
        return mongoTemplate;
    }
}
