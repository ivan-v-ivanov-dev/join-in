package com.social.relationship.service;

import com.social.relationship.model.Profile;
import com.social.relationship.repository.ProfileRepository;
import com.social.relationship.service.contracts.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.social.relationship.service.constants.LoggerConstants.NEW_USER_SAVED_IN_DATABASE_TEMPLATE;

@Service
@Slf4j
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Set<String> findFriendsByProfileIdentity(String identity) {
        return profileRepository.findFriendsByProfileIdentity(identity);
    }

    @Override
    public void save(Profile profile) {
        profileRepository.save(profile);
        log.info(String.format(NEW_USER_SAVED_IN_DATABASE_TEMPLATE, profile.getIdentity()));
    }

    @Override
    public int findFriendCountByProfileIdentity(String identity) {
        return profileRepository.findFriendCountByProfileIdentity(identity);
    }
}
