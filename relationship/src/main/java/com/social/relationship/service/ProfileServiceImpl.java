package com.social.relationship.service;

import com.social.relationship.model.Profile;
import com.social.relationship.repository.ProfileRepository;
import com.social.relationship.service.contracts.ProfileService;
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

    @Override
    public void save(Profile profile) {
        profileRepository.save(profile);
    }
}
