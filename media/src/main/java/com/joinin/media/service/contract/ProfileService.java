package com.joinin.media.service.contract;

import com.joinin.media.model.Profile;

import java.util.List;

public interface ProfileService {
    void saveUserWithDefaultPictures(String identity);

    Profile getProfileByIdentity(String identity);

    List<Profile> retrieveProfilesByIdentities(List<String> identities);
}
