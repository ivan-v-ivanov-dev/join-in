package com.social.post.service;

import com.social.kafka.messages.DeleteNodesMessage;
import com.social.kafka.messages.NewNodeMessage;
import com.social.kafka.messages.NotificationMessage;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.post.model.Comment;
import com.social.post.model.Post;
import com.social.post.repository.contract.PostRepository;
import com.social.post.repository.contract.ProfileRepository;
import com.social.post.service.contracts.KafkaMessageSender;
import com.social.post.service.contracts.PostService;
import com.social.post.service.feign.ImageClient;
import com.social.post.service.feign.ReactionClient;
import com.social.post.service.feign.RelationshipClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.social.post.service.constants.LoggerConstants.*;
import static com.social.post.service.constants.ServiceConstant.*;

@Service
@Slf4j
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ProfileRepository profileRepository;
    private final RelationshipClient relationshipClient;
    private final ReactionClient reactionClient;
    private final ImageClient imageClient;
    private final KafkaMessageSender kafkaMessageSender;
    private final String newPostNotificationTopic;
    private final String newCommentNotificationTopic;
    private final String newPostNodeTopic;
    private final String newCommentNodeTopic;
    private final String deleteNodesTopic;

    public PostServiceImpl(PostRepository postRepository,
                           ProfileRepository profileRepository,
                           RelationshipClient relationshipClient,
                           ReactionClient reactionClient,
                           ImageClient imageClient,
                           KafkaMessageSender kafkaMessageSender,
                           @Value("${spring.kafka.topic.name.new.post.notification}") String newPostNotificationTopic,
                           @Value("${spring.kafka.topic.name.new.comment.notification}") String newCommentNotificationTopic,
                           @Value("${spring.kafka.topic.name.new.post.node}") String newPostNodeTopic,
                           @Value("${spring.kafka.topic.name.new.comment.node}") String newCommentNodeTopic,
                           @Value("${spring.kafka.topic.name.delete.nodes}") String deleteNodesTopic) {
        this.postRepository = postRepository;
        this.profileRepository = profileRepository;
        this.relationshipClient = relationshipClient;
        this.reactionClient = reactionClient;
        this.imageClient = imageClient;
        this.kafkaMessageSender = kafkaMessageSender;
        this.newPostNotificationTopic = newPostNotificationTopic;
        this.newCommentNotificationTopic = newCommentNotificationTopic;
        this.newPostNodeTopic = newPostNodeTopic;
        this.newCommentNodeTopic = newCommentNodeTopic;
        this.deleteNodesTopic = deleteNodesTopic;
    }

    @Override
    public Post findByPostIdentity(String postIdentity, String authorIdentity) {
        Post post = postRepository.findByPostIdentity(postIdentity, String.format(COLLECTION_TEMPLATE, authorIdentity));
        post.setAuthorProfileImage(imageClient.findProfileImage(post.getAuthorIdentity()));
        post.getComments().forEach(comment ->
                comment.setAuthorProfileImage(imageClient.findProfileImage(comment.getAuthorIdentity())));
        log.info(String.format(RETRIEVE_POST_TEMPLATE, post.getPostIdentity()));
        return post;
    }

    @Override
    public void save(Post post, String authorIdentity, String authorNames) {
        postRepository.save(post, String.format(COLLECTION_TEMPLATE, authorIdentity));
        log.info(String.format(NEW_POST_SAVED_IN_DATABASE_AUTHOR_IDENTITY_POST_IDENTITY_TEMPLATE,
                authorIdentity, post.getPostIdentity()));

        Set<String> friends = relationshipClient.findFriends(authorIdentity);
        log.info(String.format(RETRIEVE_ALL_FRIENDS_FROM_RELATIONSHIP_SERVICE_TEMPLATE, authorIdentity));

        KafkaMessage newPostCommentNotificationMessage = NotificationMessage.builder()
                .peopleToNotify(friends)
                .authorIdentity(authorIdentity)
                .postIdentity(post.getPostIdentity())
                .authorNames(authorNames)
                .date(LocalDate.now().toString())
                .build();
        kafkaMessageSender.send(newPostCommentNotificationMessage, newPostNotificationTopic);
        log.info(String.format(NEW_POST_NOTIFICATIONS_MESSAGE_SEND_TO_NOTIFICATION_SERVICE_TEMPLATE,
                newPostNotificationTopic));

        KafkaMessage newPostNodeMessage = NewNodeMessage.builder()
                .identity(post.getPostIdentity())
                .build();
        kafkaMessageSender.send(newPostNodeMessage, newPostNodeTopic);
        log.info(String.format(NEW_POST_NODE_MESSAGE_SEND_TO_REACTION_SERVICE_TEMPLATE, newPostNodeTopic));
    }

    @Override
    public List<Post> findAllPostsByAuthorIdentity(String authorIdentity) {
        List<Post> posts = postRepository.findAllPostsByAuthorIdentity(String.format(COLLECTION_TEMPLATE, authorIdentity));
        posts.forEach(this::setPostTransientFields);
        log.info(String.format(RETRIEVE_POSTS_FOR_USER_TEMPLATE, authorIdentity));
        return posts;
    }

    @Override
    public void delete(String postIdentity, String authorIdentity) {
        Set<String> identitiesToDelete = postRepository.findAllCommentIdentitiesForAPost(postIdentity,
                String.format(COLLECTION_TEMPLATE, authorIdentity));
        log.info(String.format(RETRIEVE_COMMENT_IDENTITIES_FOR_A_POST_TEMPLATE, postIdentity));

        KafkaMessage nodesToDeleteMessage = DeleteNodesMessage.builder()
                .commentsNodesIdentities(identitiesToDelete)
                .postIdentity(postIdentity)
                .build();
        kafkaMessageSender.send(nodesToDeleteMessage, deleteNodesTopic);
        log.info(String.format(DELETE_NODES_MESSAGE_SEND_TO_REACTION_SERVICE_TEMPLATE, deleteNodesTopic));

        postRepository.delete(postIdentity, String.format(COLLECTION_TEMPLATE, authorIdentity));
        log.info(String.format(DELETE_POST_TEMPLATE, postIdentity));
    }

    @Override
    public void edit(String postIdentity, String newContent, String authorIdentity) {
        postRepository.updateOne(postIdentity, newContent, String.format(COLLECTION_TEMPLATE, authorIdentity));
        log.info(String.format(UPDATE_POST_CONTENT_TEMPLATE, postIdentity));
    }

    @Override
    public int findAuthorPostsCount(String authorIdentity) {
        int authorPostsCount = postRepository.findAuthorPostsCount(String.format(COLLECTION_TEMPLATE, authorIdentity));
        log.info(String.format(RETRIEVE_AUTHOR_POSTS_COUNT_TEMPLATE, authorIdentity));
        return authorPostsCount;
    }

    @Override
    public void createNewUserCollection(String identity) {
        postRepository.createNewUserCollection(String.format(COLLECTION_TEMPLATE, identity));
        log.info(String.format(NEW_COLLECTION_SAVED_IN_DATABASE_TEMPLATE, identity));
    }

    @Override
    public void saveComment(Comment comment, String postIdentity, String postAuthorIdentity, String authorNames) {
        postRepository.saveComment(comment, postIdentity, String.format(COLLECTION_TEMPLATE, postAuthorIdentity));
        log.info(String.format(NEW_COMMENT_SAVED_IN_DATABASE_AUTHOR_IDENTITY_COMMENT_IDENTITY_TEMPLATE,
                comment.getAuthorIdentity(), postIdentity));

        Set<String> peopleToNotify = profileRepository
                .findAllUsersCommentingThePost(postIdentity, String.format(COLLECTION_TEMPLATE, postAuthorIdentity));
        peopleToNotify.addAll(reactionClient.findPeopleWhoReactedToPost(postIdentity));
        peopleToNotify.add(comment.getAuthorIdentity());
        log.info(String.format(RETRIEVE_ALL_USERS_WHO_REACTED_AND_COMMENTED_THE_POST_TEMPLATE, postIdentity));

        KafkaMessage newPostCommentNotificationMessage = NotificationMessage.builder()
                .peopleToNotify(peopleToNotify)
                .authorIdentity(comment.getAuthorIdentity())
                .postIdentity(postIdentity)
                .authorNames(authorNames)
                .date(LocalDate.now().toString())
                .build();
        kafkaMessageSender.send(newPostCommentNotificationMessage, newCommentNotificationTopic);
        log.info(String.format(NEW_COMMENT_NOTIFICATIONS_MESSAGE_SEND_TO_NOTIFICATION_SERVICE_TEMPLATE,
                newCommentNotificationTopic));

        KafkaMessage newCommentNodeMessage = NewNodeMessage.builder()
                .identity(comment.getCommentIdentity())
                .build();
        kafkaMessageSender.send(newCommentNodeMessage, newCommentNodeTopic);
        log.info(String.format(NEW_COMMENT_NODE_MESSAGE_SEND_TO_REACTION_SERVICE_TEMPLATE, newCommentNodeTopic));
    }

    @Override
    public List<Post> findFeedPosts(String userIdentity) {
        Set<String> users = relationshipClient.findFriends(userIdentity);
        users.add(userIdentity);

        List<Post> posts = new ArrayList<>();
        users.forEach(user -> posts.addAll(postRepository.findAllPostsByAuthorIdentity(String.format(COLLECTION_TEMPLATE, user))));
        posts.forEach(this::setPostTransientFields);
        log.info(String.format(RETRIEVE_USERS_FEED_POSTS_TEMPLATE, userIdentity));
        return posts;
    }

    private String calculatePostedAgo(LocalDate postDate) {
        LocalDate now = LocalDate.now();

        if (now.isAfter(postDate.plusYears(1))) {
            if (now.isBefore(postDate.plusYears(2))) {
                return ONE_YEAR_AGO;
            }

            Period period = Period.between(postDate, now);
            int years = period.getYears();
            return String.format(SEVERAL_YEARS_AGO_TEMPLATE, years);
        } else if (now.isAfter(postDate.plusMonths(1))) {
            if (now.isBefore(postDate.plusMonths(2))) {
                return ONE_MONTH_AGO;
            }

            Period period = Period.between(postDate, now);
            int months = period.getMonths();
            return String.format(SEVERAL_MONTHS_AGO_TEMPLATE, months);
        } else {
            if (now.isBefore(postDate.plusDays(2))) {
                return ONE_DAY_AGO;
            }

            Period period = Period.between(postDate, now);
            int days = period.getDays();
            return String.format(SEVERAL_DAYS_AGO_TEMPLATE, days);
        }
    }

    private void setPostTransientFields(Post post) {
        post.setAuthorProfileImage(imageClient.findProfileImage(post.getAuthorIdentity()));
        post.setPostedAgo(calculatePostedAgo(post.getPostDate()));
        post.setLikes(reactionClient.findLikesAPostProfileCount(post.getPostIdentity()));
        post.setPeopleIdentitiesWhoLikedThePost(reactionClient.findPeopleWhoLikedThePost(post.getPostIdentity()));
        post.setDislikes(reactionClient.findDislikesAPostProfileCount(post.getPostIdentity()));
        post.setPeopleIdentitiesWhoDislikedThePost(reactionClient.findPeopleWhoDislikedThePost(post.getPostIdentity()));
        post.setStars(reactionClient.findStarsAPostProfileCount(post.getPostIdentity()));
        post.setPeopleIdentitiesWhoStaredThePost(reactionClient.findPeopleWhoStaredThePost(post.getPostIdentity()));
        post.getComments().forEach(comment -> {
            comment.setAuthorProfileImage(imageClient.findProfileImage(comment.getAuthorIdentity()));
            comment.setPostedAgo(calculatePostedAgo(comment.getPostDate()));
            comment.setLikes(reactionClient.findLikesACommentProfileCount(comment.getCommentIdentity()));
            comment.setLikes(reactionClient.findDislikesACommentProfileCount(comment.getCommentIdentity()));
        });
    }
}
