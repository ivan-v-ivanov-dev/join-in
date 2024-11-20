package com.social.gateway.service;

import com.social.gateway.adapter.PostAdapter;
import com.social.gateway.service.contract.*;
import com.social.gateway.service.feign.PostClient;
import com.social.kafka.messages.PostMessage;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.model.dto.PostGatewayRp;
import com.social.model.dto.PostRp;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.time.LocalDate;
import java.util.List;

import static com.social.gateway.service.constants.ExceptionConstants.POST_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN;
import static com.social.gateway.service.constants.ExceptionConstants.PROFILE_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN;
import static com.social.gateway.service.constants.LoggerConstants.*;
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
    private final KafkaMessageSender kafkaMessageSender;

    @Value("${spring.kafka.topic.name.post.publication}")
    String postPublicationTopic;

    @Override
    public PostGatewayRp findByAuthorIdentityAndPostIdentity(String authorIdentity, String postIdentity) {
        try {
            ResponseEntity<PostRp> response = postClient.findByAuthorIdentityAndPostIdentity(authorIdentity, postIdentity);
            if (response.hasBody()) {
                PostGatewayRp post = postAdapter.fromPostRpToPostGatewayRp(response.getBody());
                retrievePostInfo(post);
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

    @Override
    public List<PostGatewayRp> findPostsByAuthorIdentity(String identity) {
        try {
            ResponseEntity<List<PostRp>> posts = postClient.findPostsByAuthorIdentity(identity);
            if (posts.hasBody()) {
                List<PostGatewayRp> postGatewayRp = posts.getBody().stream()
                        .map(postAdapter::fromPostRpToPostGatewayRp)
                        .toList();
                postGatewayRp.forEach(this::retrievePostInfo);
                log.info(format(RETRIEVE_POSTS_FOR_USER_TEMPLATE, identity));
                return postGatewayRp;
            }
            //TODO return proper object and create custom exceptions for each service
            return null;
        } catch (FeignException exception) {
            log.error(exception.getMessage());
            throw new ResourceAccessException(POST_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN);
        }
    }

    @Override
    public void post(String identity, String content) {
        try {
            KafkaMessage postPublicationMessage = PostMessage.builder()
                    .userIdentity(identity)
                    .userNames(profileService.findProfileNames(identity))
                    .content(content)
                    .postDate(LocalDate.now().toString())
                    .build();

            kafkaMessageSender.send(postPublicationMessage, postPublicationTopic);
            log.info(String.format(NEW_POST_CREATED_AND_SEND_TO_POST_SERVICE_TOPIC_NAME_USER_IDENTITY_TEMPLATE,
                    postPublicationTopic, identity));
        } catch (FeignException exception) {
            log.error(exception.getMessage());
            throw new ResourceAccessException(PROFILE_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN);
        }
    }

    private void retrievePostInfo(PostGatewayRp post) {
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
    }

}
