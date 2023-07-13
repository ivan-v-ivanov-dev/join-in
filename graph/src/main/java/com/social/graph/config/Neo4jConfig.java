package com.social.graph.config;

import com.social.graph.model.Profile;
import com.social.graph.repository.ProfileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class Neo4jConfig {

    private static final String NEO4J_COMMAND_LIE_RUNNER_SAMPLE_DATA_IMPORTED =
            "Neo4j CommandLineRunner:: Sample data imported";

    @Bean
    CommandLineRunner commandLineRunner(ProfileRepository profileRepository) {
        return strings -> {
            profileRepository.save(Profile.builder().id(0).identity("1567b3cb857f132473d4907fd3fee2f96e661308826522e823f5f2e6e20b6032").build());
            profileRepository.save(Profile.builder().id(1).identity("771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551").build());
            profileRepository.save(Profile.builder().id(2).identity("788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627").build());
            profileRepository.save(Profile.builder().id(3).identity("d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8").build());
            profileRepository.save(Profile.builder().id(4).identity("8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f").build());
            profileRepository.save(Profile.builder().id(5).identity("c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85").build());
            log.info(NEO4J_COMMAND_LIE_RUNNER_SAMPLE_DATA_IMPORTED);
        };
    }
}
