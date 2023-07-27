package com.social.reaction.service;

import com.social.reaction.model.Profile;
import com.social.reaction.repository.ProfileRepository;
import com.social.reaction.service.contracts.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.social.reaction.service.constants.LoggerConstants.NEW_USER_SAVED_IN_DATABASE_TEMPLATE;
import static com.social.reaction.service.constants.LoggerConstants.RETRIEVE_USERS_WHO_REACTED_TO_POST_TEMPLATE;

@Service
@Slf4j
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
    public int findLikesACommentProfileCount(String commentIdentity) {
        return profileRepository.findLikesACommentProfileCount(commentIdentity);
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
        log.info(String.format(NEW_USER_SAVED_IN_DATABASE_TEMPLATE, profile.getIdentity()));
    }

    @Override
    public Set<String> findPeopleWhoReactedToPost(String postIdentity) {
        Set<String> peopleWhoReactedToPost = profileRepository.findPeopleWhoReactedToPost(postIdentity);
        log.info(String.format(RETRIEVE_USERS_WHO_REACTED_TO_POST_TEMPLATE, postIdentity));
        return peopleWhoReactedToPost;
    }
}
