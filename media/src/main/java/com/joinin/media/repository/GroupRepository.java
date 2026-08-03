package com.joinin.media.repository;

import com.joinin.media.model.Group;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository
@RequiredArgsConstructor
public class GroupRepository {

    private final MongoTemplate mongoTemplate;

    public List<Group> findAllByIdentities(List<String> identities) {
        if (identities == null || identities.isEmpty()) {
            return List.of();
        }
        Query query = new Query(where("identity").in(identities));
        return mongoTemplate.find(query, Group.class);
    }
}
