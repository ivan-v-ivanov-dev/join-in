package com.joinin.mvc.service.contract;

import com.joinin.mvc.model.EditProfileRq;
import com.joinin.mvc.model.Profile;
import org.jspecify.annotations.Nullable;

public interface ProfileService {
    Profile retrieveProfileByIdentity(String identity);

    String retrieveProfileNames(String identity);

    EditProfileRq retrieveEditProfileRequest(String identity);

    void editProfile(String identity, EditProfileRq editProfileRq);
}
