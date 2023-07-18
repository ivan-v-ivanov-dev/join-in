package com.social.profile.repository.contract;

import com.social.profile.model.Profile;

public interface ProfileRepository {
    Profile findByIdentity(String identity);

    Profile save(Profile profile);

    String findProfileFirstName(String identity);

    String findProfileLastName(String identity);
}
