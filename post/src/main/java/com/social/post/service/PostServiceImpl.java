package com.social.post.service;

import com.social.kafka.messages.NewPostNodeMessage;
import com.social.kafka.messages.NewPostNotificationMessage;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.post.model.Comment;
import com.social.post.model.Post;
import com.social.post.repository.contract.PostRepository;
import com.social.post.service.contracts.KafkaMessageSender;
import com.social.post.service.contracts.PostService;
import com.social.post.service.feign.RelationshipClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static com.social.post.service.constants.CollectionTemplateConstant.COLLECTION_TEMPLATE;
import static com.social.post.service.constants.LoggerConstants.*;

@Service
@Slf4j
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final RelationshipClient relationshipClient;
    private final KafkaMessageSender kafkaMessageSender;
    private final String newPostNotificationTopic;
    private final String newPostNodeTopic;

    public PostServiceImpl(PostRepository postRepository, RelationshipClient relationshipClient, KafkaMessageSender kafkaMessageSender, @Value("${spring.kafka.topic.name.new.post.notifications}") String newPostNotificationTopic, @Value("${spring.kafka.topic.name.new.post.node}") String newPostNodeTopic) {
        this.postRepository = postRepository;
        this.relationshipClient = relationshipClient;
        this.kafkaMessageSender = kafkaMessageSender;
        this.newPostNotificationTopic = newPostNotificationTopic;
        this.newPostNodeTopic = newPostNodeTopic;
    }

    @Override
    public Post findByPostIdentity(String postIdentity, String authorIdentity) {
        return postRepository.findByPostIdentity(postIdentity, String.format(COLLECTION_TEMPLATE, authorIdentity));
    }

    @Override
    public void save(Post post, String authorIdentity, String authorNames) {
        postRepository.save(post, String.format(COLLECTION_TEMPLATE, authorIdentity));
        log.info(String.format(NEW_POST_SAVED_IN_DATABASE_AUTHOR_IDENTITY_POST_IDENTITY_TEMPLATE, authorIdentity, post.getPostIdentity()));

        List<String> friends = relationshipClient.findFriends(authorIdentity);
        log.info(String.format(RETRIEVE_ALL_FRIENDS_FROM_RELATIONSHIP_SERVICE_TEMPLATE, authorIdentity));

        KafkaMessage newPostNotifications = NewPostNotificationMessage.builder()
                .friends(friends)
                .authorIdentity(authorIdentity)
                .postIdentity(post.getPostIdentity())
                .authorNames(authorNames)
                .date(LocalDate.now().toString())
                .build();
        kafkaMessageSender.send(newPostNotifications, newPostNotificationTopic);
        log.info(String.format(NEW_POST_NOTIFICATIONS_MESSAGE_SEND_TO_NOTIFICATION_SERVICE_TEMPLATE, newPostNotificationTopic));

        KafkaMessage newPostNodeMessage = NewPostNodeMessage.builder().postIdentity(post.getPostIdentity()).build();
        kafkaMessageSender.send(newPostNodeMessage, newPostNodeTopic);
        log.info(String.format(NEW_POST_NODE_MESSAGE_SEND_TO_REACTION_SERVICE_TEMPLATE, newPostNodeTopic));
    }

    @Override
    public List<Post> findAllPostsByAuthorIdentity(String authorIdentity) {
        return postRepository.findAllPostsByAuthorIdentity(String.format(COLLECTION_TEMPLATE, authorIdentity));
    }

    @Override
    public void delete(String postIdentity, String authorIdentity) {
        postRepository.delete(postIdentity, String.format(COLLECTION_TEMPLATE, authorIdentity));
    }

    @Override
    public void edit(String postIdentity, String newContent, String authorIdentity) {
        postRepository.updateOne(postIdentity, newContent, String.format(COLLECTION_TEMPLATE, authorIdentity));
    }

    @Override
    public int findAuthorPostsCount(String authorIdentity) {
        return postRepository.findAuthorPostsCount(String.format(COLLECTION_TEMPLATE, authorIdentity));
    }

    @Override
    public void createNewUserCollection(String identity) {
        postRepository.createNewUserCollection(String.format(COLLECTION_TEMPLATE, identity));
        log.info(String.format(NEW_COLLECTION_SAVED_IN_DATABASE_TEMPLATE, identity));
    }

    @Override
    public void saveComment(Comment comment, String postIdentity) {
        postRepository.saveComment(comment, postIdentity);
    }
}
