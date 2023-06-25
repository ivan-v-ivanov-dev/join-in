package com.social.profile.repository;

import com.social.profile.model.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileRepository extends MongoRepository<Profile, String> {
    Profile findByIdentity(String identity);
}
