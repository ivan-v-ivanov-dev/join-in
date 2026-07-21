package com.joinin.search.repository;

import com.joinin.search.model.elastic.ProfileElasticEntry;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ElasticsearchProfileRepository extends ElasticsearchRepository<ProfileElasticEntry, String> {

    @Query("""
        {
          "multi_match": {
            "query": "?0",
            "fields": ["firstName", "lastName"]
          }
        }
        """)
    List<ProfileElasticEntry> searchByName(String name);
}
