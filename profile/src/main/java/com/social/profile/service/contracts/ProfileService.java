package com.social.profile.service.contracts;

import com.social.profile.model.Profile;

public interface ProfileService {
    Profile findByIdentity(String identity);

    Profile save(Profile profile);
}
