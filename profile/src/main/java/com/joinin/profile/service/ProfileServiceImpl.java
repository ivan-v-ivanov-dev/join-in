package com.joinin.profile.service;

import com.joinin.profile.models.Profile;
import com.joinin.profile.repository.ProfileRepository;
import com.joinin.profile.service.contract.ProfileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    @Override
    public void save(Profile profile) {
        Profile savedProfile = profileRepository.save(profile);
        log.info("Profile saved in database. Profile identity: " + savedProfile.getIdentity());
    }
}
