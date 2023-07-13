package com.social.graph.service;

import com.social.graph.model.Profile;
import com.social.graph.repository.ProfileRepository;
import com.social.graph.service.contracts.ProfileService;
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
