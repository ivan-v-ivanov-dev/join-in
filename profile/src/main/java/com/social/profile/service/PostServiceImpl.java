package com.social.profile.service;

import com.social.kafka.messages.DeletePostMessage;
import com.social.kafka.messages.EditPostMessage;
import com.social.kafka.messages.PostMessage;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.profile.model.EditPost;
import com.social.profile.model.Post;
import com.social.profile.repository.contract.ProfileRepository;
import com.social.profile.service.contracts.KafkaMessageSender;
import com.social.profile.service.contracts.PostService;
import com.social.profile.service.feign.PostClient;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static com.social.profile.service.constants.ExceptionConstants.POST_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN;
import static com.social.profile.service.constants.LoggerConstants.*;
import static com.social.profile.service.constants.ServiceConstants.AUTHOR_NAME_TEMPLATE;

@Service
@Slf4j
public class PostServiceImpl implements PostService {

    private final KafkaMessageSender kafkaMessageSender;
    private final PostClient postClient;
    private final ProfileRepository profileRepository;
    private final String postPublicationTopic;
    private final String deletePostTopic;
    private final String editPostTopic;

    public PostServiceImpl(KafkaMessageSender kafkaMessageSender,
                           PostClient postClient,
                           ProfileRepository profileRepository,
                           @Value("${spring.kafka.topic.name.post.publication}") String postPublicationTopic,
                           @Value("${spring.kafka.topic.name.delete.post}") String deletePostTopic,
                           @Value("${spring.kafka.topic.name.edit.post}") String editPostTopic) {
        this.kafkaMessageSender = kafkaMessageSender;
        this.postClient = postClient;
        this.profileRepository = profileRepository;
        this.postPublicationTopic = postPublicationTopic;
        this.deletePostTopic = deletePostTopic;
        this.editPostTopic = editPostTopic;
    }

    @Override
    public EditPost findByIdentity(String postIdentity, String authorIdentity) {
        try {
            EditPost post = postClient.findByPostIdentity(postIdentity, authorIdentity);
            post.setAuthorNames(findUserNamesFromUserIdentity(authorIdentity));
            log.info(String.format(RETRIEVE_POST_TEMPLATE, post.getPostIdentity()));
            return post;
        } catch (ResourceAccessException resourceAccessException) {
            log.error(resourceAccessException.getMessage());
            throw resourceAccessException;
        }
    }

    @Override
    public void post(String userIdentity, String content) {
        KafkaMessage postPublicationMessage = PostMessage.builder()
                .userIdentity(userIdentity)
                .userNames(findUserNamesFromUserIdentity(userIdentity))
                .content(content)
                .postDate(LocalDate.now().toString())
                .build();

        kafkaMessageSender.send(postPublicationMessage, postPublicationTopic);
        log.info(String.format(NEW_POST_CREATED_AND_SEND_TO_POST_SERVICE_TOPIC_NAME_USER_IDENTITY_TEMPLATE,
                postPublicationTopic, userIdentity));
    }

    @Override
    public void edit(String postIdentity, String authorIdentity, String newContent) {
        KafkaMessage editPostMessage = EditPostMessage.builder()
                .postIdentity(postIdentity)
                .auhthorIdentity(authorIdentity)
                .newContent(newContent).build();

        kafkaMessageSender.send(editPostMessage, editPostTopic);
        log.info(String.format(EDIT_POST_CREATED_AND_SEND_TO_POST_SERVICE_TOPIC_NAME_POST_IDENTITY_TEMPLATE,
                editPostTopic, postIdentity));
    }

    @Override
    public void delete(String postIdentity, String authorIdentity) {
        KafkaMessage deletePostMessage = DeletePostMessage.builder()
                .postIdentity(postIdentity)
                .authorIdentity(authorIdentity)
                .build();

        kafkaMessageSender.send(deletePostMessage, deletePostTopic);
        log.info(String.format(DELETE_POST_CREATED_AND_SEND_TO_POST_SERVICE_TOPIC_NAME_POST_IDENTITY_TEMPLATE,
                deletePostTopic, postIdentity));
    }

    @Override
    public List<Post> findUserPosts(String identity) {
        try {
            List<Post> posts = postClient.findAllPostsByAuthorIdentity(identity);
            posts.forEach(this::setUserNamesForThePostFields);
            log.info(String.format(RETRIEVE_USER_POSTS_FROM_POST_SERVICE_TEMPLATE, identity));
            return posts;
        } catch (ResourceAccessException resourceAccessException) {
            log.error(resourceAccessException.getMessage());
            throw resourceAccessException;
        }
    }

    @Override
    public int findUserPostsCount(String identity) {
        try {
            int postCount = postClient.findAuthorPostsCount(identity);
            log.info(String.format(RETRIEVE_USER_POSTS_COUNT_FROM_POST_SERVICE_TEMPLATE, identity));
            return postCount;
        } catch (FeignException feignException) {
            log.error(feignException.getMessage());
            throw new ResourceAccessException(POST_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN);
        }
    }

    @Override
    public List<Post> findFeedPosts(String userIdentity) {
        try {
            List<Post> posts = postClient.findFeedPosts(userIdentity);
            posts.forEach(this::setUserNamesForThePostFields);
            log.info(String.format(RETRIEVE_USERS_FEED_POSTS_FROM_POST_SERVICE_TEMPLATE, userIdentity));
            return posts;
        } catch (ResourceAccessException resourceAccessException) {
            log.error(resourceAccessException.getMessage());
            throw resourceAccessException;
        }
    }

    private void setUserNamesForThePostFields(Post post) {
        post.setAuthorNames(findUserNamesFromUserIdentity(post.getAuthorIdentity()));
        post.setPeopleNamesWhoLikedThePost(findUsersNamesFromUserIdentity(post.getPeopleIdentitiesWhoLikedThePost()));
        post.setPeopleNamesWhoDislikedThePost(findUsersNamesFromUserIdentity(post.getPeopleIdentitiesWhoDislikedThePost()));
        post.setPeopleNamesWhoStaredThePost(findUsersNamesFromUserIdentity(post.getPeopleIdentitiesWhoStaredThePost()));
        post.getComments().forEach(comment ->
                comment.setAuthorNames(findUserNamesFromUserIdentity(comment.getAuthorIdentity())));
    }

    private List<String> findUsersNamesFromUserIdentity(Set<String> userIdentities) {
        return userIdentities
                .stream()
                .map(this::findUserNamesFromUserIdentity)
                .toList();
    }

    private String findUserNamesFromUserIdentity(String identity) {
        return String.format(AUTHOR_NAME_TEMPLATE,
                profileRepository.findProfileFirstName(identity),
                profileRepository.findProfileLastName(identity));
    }
}
