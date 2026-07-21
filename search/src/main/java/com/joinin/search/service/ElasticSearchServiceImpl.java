package com.joinin.search.service;

import com.joinin.search.model.elastic.ProfileElasticEntry;
import com.joinin.search.repository.ElasticsearchProfileRepository;
import com.joinin.search.service.contract.ElasticSearchService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ElasticSearchServiceImpl implements ElasticSearchService {

    private final ElasticsearchProfileRepository elasticsearchProfileRepository;

    @Override
    public void saveProfile(String identity, String firstName, String lastName) {
        ProfileElasticEntry profileElasticEntry =
                ProfileElasticEntry.builder()
                        .identity(identity)
                        .firstName(firstName)
                        .lastName(lastName).build();
        ProfileElasticEntry savedProfile = elasticsearchProfileRepository.save(profileElasticEntry);
        log.info("New profile elasticsearch entry saved with profile identity: " + savedProfile.getIdentity());
    }
}
