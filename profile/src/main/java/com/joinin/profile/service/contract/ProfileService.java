package com.joinin.profile.service.contract;

import com.join_in.common_models.ProfileRpProfileNamesProfileService;
import com.join_in.common_models.ProfileRpProfileService;
import com.joinin.profile.models.Profile;

import java.util.List;

public interface ProfileService {
    void save(Profile profile);

    ProfileRpProfileService retrieveProfileByIdentity(String identity);

    List<ProfileRpProfileNamesProfileService> retrieveProfilesNames(List<String> identities);

    String retrieveProfileNames(String identity);
}
