package com.joinin.profile.service.contract;

import com.join_in.common_models.ProfileRpProfileService;
import com.joinin.profile.models.Profile;

public interface ProfileService {
    void save(Profile profile);

    ProfileRpProfileService retrieveProfileByIdentity(String identity);
}
