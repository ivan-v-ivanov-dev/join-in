package com.social.graph.service;

import com.social.graph.model.Profile;
import com.social.graph.repository.ProfileRepository;
import com.social.graph.service.contracts.ProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Profile> findFriendsByProfileIdentity(String identity) {
        return profileRepository.findFriendsByProfileIdentity(identity);
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
