package com.social.profile.repository.contract;

import com.social.profile.model.Profile;

public interface ProfileRepository {
    Profile findByIdentity(String identity);
}
