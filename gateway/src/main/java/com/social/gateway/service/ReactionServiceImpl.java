package com.social.gateway.service;

import com.social.gateway.service.contract.ReactionService;
import com.social.gateway.service.feign.ReactionClient;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.Set;

import static com.social.gateway.service.constants.LoggerConstants.*;
import static java.lang.String.format;

@Service
@AllArgsConstructor
@Slf4j
public class ReactionServiceImpl implements ReactionService {

    private final ReactionClient reactionClient;

    @Override
    public int findPostLikesCount(String postIdentity) {
        try {
            int likes = reactionClient.findPostLikesCount(postIdentity);
            log.info(format(RETRIEVE_LIKES_A_POST_USER_COUNT_TEMPLATE, postIdentity));
            return likes;
        } catch (FeignException exception) {
            log.error(exception.getMessage());
            throw new ResourceAccessException(exception.getMessage());
        }
    }

    @Override
    public int findPostDislikesCount(String postIdentity) {
        try {
            int dislikes = reactionClient.findPostDislikesCount(postIdentity);
            log.info(format(RETRIEVE_DISLIKES_A_POST_USER_COUNT_TEMPLATE, postIdentity));
            return dislikes;
        } catch (FeignException exception) {
            log.error(exception.getMessage());
            throw new ResourceAccessException(exception.getMessage());
        }
    }

    @Override
    public int findPostStarsCount(String postIdentity) {
        try {
            int stars = reactionClient.findPostStarsCount(postIdentity);
            log.info(format(RETRIEVE_STARS_A_POST_USER_COUNT_TEMPLATE, postIdentity));
            return stars;
        } catch (FeignException exception) {
            log.error(exception.getMessage());
            throw new ResourceAccessException(exception.getMessage());
        }
    }

    @Override
    public Set<String> findProfileIdentitiesWhoLikedThePost(String postIdentity) {
        try {
            Set<String> identities = reactionClient.findProfileIdentitiesWhoLikedThePost(postIdentity);
            log.info(format(RETRIEVE_USER_IDENTITIES_WHO_LIKED_THE_POST_TEMPLATE, postIdentity));
            return identities;
        } catch (FeignException exception) {
            log.error(exception.getMessage());
            throw new ResourceAccessException(exception.getMessage());
        }
    }

    @Override
    public Set<String> findProfileIdentitiesWhoDislikedThePost(String postIdentity) {
        try {
            Set<String> identities = reactionClient.findProfileIdentitiesWhoDislikedThePost(postIdentity);
            log.info(format(RETRIEVE_USER_IDENTITIES_WHO_DISLIKED_THE_POST_TEMPLATE, postIdentity));
            return identities;
        } catch (FeignException exception) {
            log.error(exception.getMessage());
            throw new ResourceAccessException(exception.getMessage());
        }
    }

}
