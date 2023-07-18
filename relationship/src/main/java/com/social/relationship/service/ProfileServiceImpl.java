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
    public List<String> findFriendsByProfileIdentity(String identity) {
        return profileRepository.findFriendsByProfileIdentity(identity);
    }

    @Override
    public void save(Profile profile) {
        profileRepository.save(profile);
    }

    @Override
    public int findFriendCountByProfileIdentity(String identity) {
        return profileRepository.findFriendCountByProfileIdentity(identity);
    }
}
