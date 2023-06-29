package com.social.profile.service;

import com.social.profile.model.Profile;
import com.social.profile.repository.contract.ProfileRepository;
import com.social.profile.service.contrancts.ProfileService;
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
}
