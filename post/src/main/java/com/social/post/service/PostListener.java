package com.social.post.service;

import com.social.kafka.messages.CommentMessage;
import com.social.kafka.messages.DeletePostMessage;
import com.social.kafka.messages.PostMessage;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.post.model.Comment;
import com.social.post.model.Post;
import com.social.post.service.contracts.CommentService;
import com.social.post.service.contracts.IdentityGenerator;
import com.social.post.service.contracts.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static com.social.post.service.constants.LoggerConstants.*;

@Service
@Slf4j
public class PostListener {

    private final IdentityGenerator identityGenerator;
    private final PostService postService;
    private final CommentService commentService;
    private final String postPublicationTopic;
    private final String postCommentTopic;
    private final String deletePostTopic;

    public PostListener(IdentityGenerator identityGenerator,
                        PostService postService,
                        CommentService commentService,
                        @Value("${spring.kafka.topic.name.post.publication}") String postPublicationTopic,
                        @Value("${spring.kafka.topic.name.post.comment}") String postCommentTopic,
                        @Value("${spring.kafka.topic.name.delete.post}") String deletePostTopic) {
        this.identityGenerator = identityGenerator;
        this.postService = postService;
        this.commentService = commentService;
        this.postPublicationTopic = postPublicationTopic;
        this.postCommentTopic = postCommentTopic;
        this.deletePostTopic = deletePostTopic;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name.post.publication}", groupId = "${spring.kafka.group.id}")
    public void postPublicationListener(KafkaMessage kafkaMessage) {
        PostMessage postMessage = (PostMessage) kafkaMessage;
        log.info(String.format(NEW_POST_PUBLISHED_MESSAGE_RECEIVED_FROM_PROFILE_SERVICE_TEMPLATE,
                postMessage.getUserIdentity(), postPublicationTopic));

        LocalDate dateNow = LocalDate.now();

        Post post = Post.builder()
                .authorIdentity(postMessage.getUserIdentity())
                .postIdentity(identityGenerator
                        .generate(postMessage.getUserIdentity(), postMessage.getContent(), dateNow.toString()))
                .content(postMessage.getContent())
                .postDate(dateNow)
                .build();

        postService.save(post);
    }

    @KafkaListener(topics = "${spring.kafka.topic.name.post.comment}", groupId = "${spring.kafka.group.id}")
    public void postCommentListener(KafkaMessage kafkaMessage) {
        CommentMessage commentMessage = (CommentMessage) kafkaMessage;
        log.info(String.format(NEW_COMMENT_PUBLISHED_MESSAGE_RECEIVED_FROM_PROFILE_SERVICE_TEMPLATE,
                commentMessage.getUserIdentity(), postCommentTopic));

        LocalDate dateNow = LocalDate.now();

        Comment comment = Comment.builder()
                .postIdentity(commentMessage.getPostIdentity())
                .authorIdentity(commentMessage.getUserIdentity())
                .commentIdentity(identityGenerator
                        .generate(commentMessage.getUserIdentity(), commentMessage.getContent(), dateNow.toString()))
                .content(commentMessage.getContent())
                .postDate(dateNow)
                .build();

        commentService.save(comment);
    }

    @KafkaListener(topics = "${spring.kafka.topic.name.delete.post}", groupId = "${spring.kafka.group.id}")
    public void deletePostListener(KafkaMessage kafkaMessage) {
        DeletePostMessage deletePostMessage = (DeletePostMessage) kafkaMessage;
        log.info(String.format(NEW_DELETE_POST_MESSAGE_RECEIVED_FROM_PROFILE_SERVICE_TEMPLATE,
                deletePostMessage.getPostIdentity(), deletePostTopic));

        postService.delete(deletePostMessage.getPostIdentity());
    }
}
