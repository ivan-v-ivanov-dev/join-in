package com.joinin.media.service.contract;

import com.joinin.media.model.Profile;

public interface ProfileService {
    void saveUserWithDefaultPictures(String identity);

    Profile getProfileByIdentity(String identity);
}
