package com.social.reaction.service;

import com.social.reaction.model.Profile;
import com.social.reaction.repository.ProfileRepository;
import com.social.reaction.service.contracts.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.social.reaction.service.constants.LoggerConstants.*;

@Service
@Slf4j
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public int findLikesAPostProfileCount(String postIdentity) {
        int likesAPostProfileCount = profileRepository.findLikesAPostProfileCount(postIdentity);
        log.info(String.format(RETRIEVE_LIKES_A_POST_USER_COUNT_POST_TEMPLATE, postIdentity));
        return likesAPostProfileCount;
    }

    @Override
    public int findLikesACommentProfileCount(String commentIdentity) {
        int likesACommentProfileCount = profileRepository.findLikesACommentProfileCount(commentIdentity);
        log.info(String.format(RETRIEVE_LIKES_A_COMMENT_USER_COUNT_COMMENT_TEMPLATE, commentIdentity));
        return likesACommentProfileCount;
    }

    @Override
    public int findDislikesAPostProfileCount(String postIdentity) {
        int dislikesAPostProfileCount = profileRepository.findDislikesAPostProfileCount(postIdentity);
        log.info(String.format(RETRIEVE_DISLIKES_A_POST_USER_COUNT_POST_TEMPLATE, postIdentity));
        return dislikesAPostProfileCount;
    }

    @Override
    public int findDislikesACommentProfileCount(String commentIdentity) {
        int dislikesACommentProfileCount = profileRepository.findDislikesACommentProfileCount(commentIdentity);
        log.info(String.format(RETRIEVE_DISLIKES_A_COMMENT_USER_COUNT_COMMENT_TEMPLATE, commentIdentity));
        return dislikesACommentProfileCount;
    }

    @Override
    public int findStarsAPostProfileCount(String postIdentity) {
        int starsAPostProfileCount = profileRepository.findStarsAPostProfileCount(postIdentity);
        log.info(String.format(RETRIEVE_STARS_A_POST_USER_COUNT_POST_TEMPLATE, postIdentity));
        return starsAPostProfileCount;
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

    @Override
    public Set<String> findPeopleWhoLikedThePost(String postIdentity) {
        Set<String> peopleWhoLikedThePost = profileRepository.findPeopleWhoLikedThePost(postIdentity);
        log.info(String.format(RETRIEVE_USERS_WHO_LIKED_THE_POST_TEMPLATE, postIdentity));
        return peopleWhoLikedThePost;
    }

    @Override
    public Set<String> findPeopleWhoDislikedThePost(String postIdentity) {
        Set<String> peopleWhoDislikedThePost = profileRepository.findPeopleWhoDislikedThePost(postIdentity);
        log.info(String.format(RETRIEVE_USERS_WHO_DISLIKED_THE_POST_TEMPLATE, postIdentity));
        return peopleWhoDislikedThePost;
    }

    @Override
    public Set<String> findPeopleWhoStaredThePost(String postIdentity) {
        Set<String> peopleWhoStaredThePost = profileRepository.findPeopleWhoStaredThePost(postIdentity);
        log.info(String.format(RETRIEVE_USERS_WHO_STARED_THE_POST_TEMPLATE, postIdentity));
        return peopleWhoStaredThePost;
    }
}
