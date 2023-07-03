package com.social.profile.service;

import com.social.profile.model.Profile;
import com.social.profile.repository.contract.ProfileRepository;
import com.social.profile.service.contracts.ProfileService;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile findByIdentity(String identity) {
        return profileRepository.findByIdentity(identity);
    }

    @Override
    public Profile save(Profile profile) {
        return profileRepository.save(profile);
    }
}
