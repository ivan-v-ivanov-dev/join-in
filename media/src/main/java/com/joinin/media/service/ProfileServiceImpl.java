package com.joinin.media.service;

import com.joinin.media.model.Profile;
import com.joinin.media.repository.ProfileRepository;
import com.joinin.media.service.contract.ProfileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    //TODO Add default pictures from S3
    @Override
    public void saveUserWithDefaultPictures(String identity) {
        Profile profile = Profile.builder().identity(identity).build();
        Profile savedProfile = profileRepository.save(profile);
        log.info("Profile saved. Profile identity: " + savedProfile.getIdentity());
    }
}
