package com.social.gateway.service;

import com.social.gateway.adapter.PostAdapter;
import com.social.gateway.service.contract.ImageService;
import com.social.gateway.service.contract.PostService;
import com.social.gateway.service.contract.ProfileService;
import com.social.gateway.service.contract.ReactionService;
import com.social.gateway.service.feign.PostClient;
import com.social.model.dto.PostGatewayRp;
import com.social.model.dto.PostRp;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import static com.social.gateway.service.constants.LoggerConstants.RETRIEVE_POST_TEMPLATE;
import static java.lang.String.format;

@Service
@AllArgsConstructor
@Slf4j
public class PostServiceImpl implements PostService {

    private final PostAdapter postAdapter;
    private final PostClient postClient;
    private final ProfileService profileService;
    private final ImageService imageService;
    private final ReactionService reactionService;

    @Override
    public PostGatewayRp findByAuthorIdentityAndPostIdentity(String authorIdentity, String postIdentity) {
        try {
            ResponseEntity<PostRp> response = postClient.findByAuthorIdentityAndPostIdentity(authorIdentity, postIdentity);
            if (response.hasBody()) {
                PostGatewayRp post = postAdapter.fromPostRpToPostGatewayRp(response.getBody());
                post.setAuthorNames(profileService.findProfileNames(post.getAuthorIdentity()));
                post.setAuthorProfileImage(imageService.findProfileImage(post.getAuthorIdentity()));
                post.setLikes(reactionService.findPostLikesCount(post.getPostIdentity()));
                post.setPeopleIdentitiesWhoLikedThePost(reactionService.findProfileIdentitiesWhoLikedThePost(post.getPostIdentity()));
                post.getPeopleIdentitiesWhoLikedThePost().forEach(profileIdentity ->
                        post.getPeopleNamesWhoLikedThePost().add(profileService.findProfileNames(profileIdentity)));
                post.setDislikes(reactionService.findPostDislikesCount(post.getPostIdentity()));
                post.setPeopleIdentitiesWhoDislikedThePost(reactionService.findProfileIdentitiesWhoDislikedThePost(post.getPostIdentity()));
                post.getPeopleIdentitiesWhoDislikedThePost().forEach(profileIdentity ->
                        post.getPeopleNamesWhoDislikedThePost().add(profileService.findProfileNames(profileIdentity)));
                post.setStars(reactionService.findPostStarsCount(post.getPostIdentity()));
                post.setPeopleIdentitiesWhoStaredThePost(reactionService.findProfileIdentitiesWhoStaredThePost(post.getPostIdentity()));
                post.getPeopleIdentitiesWhoStaredThePost().forEach(profileIdentity ->
                        post.getPeopleNamesWhoStaredThePost().add(profileService.findProfileNames(profileIdentity)));
                post.getComments().forEach(comment -> {
                    comment.setAuthorNames(profileService.findProfileNames(comment.getAuthorIdentity()));
                    comment.setAuthorProfileImage(imageService.findProfileImage(comment.getAuthorIdentity()));
                    comment.setLikes(reactionService.findCommentsLikesCount(comment.getCommentIdentity()));
                    comment.setDislikes(reactionService.findCommentDislikesCount(comment.getCommentIdentity()));
                });
                log.info(format(RETRIEVE_POST_TEMPLATE, postIdentity));
                return post;
            }
            //TODO return proper object
            return null;
        } catch (FeignException exception) {
            log.error(exception.getMessage());
            throw new ResourceAccessException(exception.getMessage());
        }
    }
}
