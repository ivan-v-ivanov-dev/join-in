package com.social.reaction.service;

import com.social.reaction.model.Profile;
import com.social.reaction.repository.ProfileRepository;
import com.social.reaction.service.contract.ProfileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.social.reaction.service.constants.LoggerConstants.NEW_USER_SAVED_IN_DATABASE_TEMPLATE;
import static com.social.reaction.service.constants.LoggerConstants.RETRIEVE_LIKES_A_POST_USER_COUNT_TEMPLATE;

@Service
@AllArgsConstructor
@Slf4j
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    @Override
    public void createProfile(String identity) {
        Profile profile = profileRepository.save(Profile.builder().identity(identity).build());
        log.info(String.format(NEW_USER_SAVED_IN_DATABASE_TEMPLATE, profile.getIdentity()));
    }

    @Override
    public int findPostLikesCount(String postIdentity) {
        int likesAPostProfileCount = profileRepository.findPostLikesCount(postIdentity);
        log.info(String.format(RETRIEVE_LIKES_A_POST_USER_COUNT_TEMPLATE, postIdentity));
        return likesAPostProfileCount;
    }
}
