package com.social.reaction.service;

import com.social.reaction.repository.ProfileRepository;
import com.social.reaction.service.contracts.ProfileService;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public int findLikesAPostProfileCount(String postIdentity) {
        return profileRepository.findLikesAPostProfileCount(postIdentity);
    }

    @Override
    public int findDislikesAPostProfileCount(String postIdentity) {
        return profileRepository.findDislikesAPostProfileCount(postIdentity);
    }

    @Override
    public int findStarsAPostProfileCount(String postIdentity) {
        return profileRepository.findStarsAPostProfileCount(postIdentity);
    }
}
