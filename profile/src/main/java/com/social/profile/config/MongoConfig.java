package com.social.profile.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.social.profile.model.Profile;
import com.social.profile.repository.ProfileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Collections;

@Configuration
@EnableMongoRepositories(basePackages = {"com.social.profile.repository"})
@Slf4j
public class MongoConfig extends AbstractMongoClientConfiguration {

    public static String IMPORT_SAMPLE_DATA = "In PROFILE :: Import sample data.";

    @Value("${spring.data.mongodb.authentication-database}")
    private String authenticationDb;
    @Value("${spring.data.mongodb.database}")
    private String database;
    @Value("${spring.data.mongodb.username}")
    private String username;
    @Value("${spring.data.mongodb.password}")
    private String password;
    @Value("${spring.data.mongodb.host}")
    private String host;
    @Value("${spring.data.mongodb.port}")
    private String port;

    @Override
    protected void configureClientSettings(MongoClientSettings.Builder builder) {
        builder
                .credential(MongoCredential.createCredential(username, database, this.password.toCharArray()))
                .applyToClusterSettings(settings -> {
                    settings.hosts(Collections.singletonList(new ServerAddress(host, Integer.parseInt(port))));
                });
    }

    @Override
    protected String getDatabaseName() {
        return authenticationDb;
    }

    @Bean
    CommandLineRunner commandLineRunner(ProfileRepository profileRepository) {
        log.info(IMPORT_SAMPLE_DATA);
        return strings -> {
            profileRepository.save(Profile.builder().image(null).email("petur@petur.com").identity("1f7bf12277853b6c72a4e68f66e8c582c65570c0b62ff79b0846696997cf37246b1079bc8794f27516ed389232359831822e249e715bb5e8651fd6648ab26ef0").firstName("Petur").lastName("Petrov").build());
            profileRepository.save(Profile.builder().image(null).email("georgi@georgi.com").identity("a0df099e81ec99fc63ada8715fc4ad8a071e98e4907a1ab4cb76359d32601f66e9b4e286f6837dc3c0f47b77647e94b7d56d660664a46951c541d7d4720c2ed2").firstName("Georgi").lastName("Vankov").build());
            profileRepository.save(Profile.builder().image(null).email("stoyan@stoyan.com").identity("557348e4d21af46b3895497ad6c6b05a04ad7b5e6a0492432ea4a56c6d7510d63c62dd3928d4291e33259158b1809e6c6ce26e54654393e7fb33d6d1352df8cb").firstName("Stoyan").lastName("Naydenov").build());
            profileRepository.save(Profile.builder().image(null).email("victoriya@victoriya.com").identity("7e15b4ca44311b7a7e5b2c176f693cd85f28cb4670d35abbfeed8cb3ce17ef18a353f534f4b47fa3b546ae79cfaa6141c7b771dc8431f567033128eaca558e81").firstName("Viktoriya").lastName("Stefanova").build());
            profileRepository.save(Profile.builder().image(null).email("mariya@mariya.com").identity("f7e9d7e4d7622aefe395172350261857f7efb20dd6368eb95a71ed8caf74ffd3bc9d16404b74908911595e6f7261cf5108e30ee08551c246cb520eb8b98a1d6a").firstName("Mariya").lastName("Ivanova").build());
            profileRepository.save(Profile.builder().image(null).email("konstantin@konstantin.com").identity("477c9125eddcf72ab3c33c8af5ac2e22971eca09e2a2d27daba3c925ce04210c8a04bf9f900e902c7c647683d9df0ac9c6367cb74261c63c8b55f625a4085ed4").firstName("Konstantin").lastName("Petrov").build());
        };
    }
}