package com.social.profile.repository.contract;

import com.social.profile.model.Profile;

public interface ProfileRepository {
    void createCollection(String collection);

    Profile findByIdentity(String identity);

    Profile findProfileNames(String identity);
}
