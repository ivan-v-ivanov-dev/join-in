package com.social.post.service;

import com.social.kafka.messages.CommentMessage;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.post.model.Comment;
import com.social.post.service.contracts.CommentService;
import com.social.post.service.contracts.IdentityGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static com.social.post.service.constants.LoggerConstants.NEW_COMMENT_PUBLISHED_MESSAGE_RECEIVED_FROM_PROFILE_SERVICE_TEMPLATE;

@Service
@Slf4j
public class PostCommentListener {

    private final IdentityGenerator identityGenerator;
    private final CommentService commentService;
    private final String kafkaTopic;

    public PostCommentListener(IdentityGenerator identityGenerator,
                               CommentService commentService,
                               @Value("${spring.kafka.topic.name.post.comment}") String kafkaTopic) {
        this.identityGenerator = identityGenerator;
        this.commentService = commentService;
        this.kafkaTopic = kafkaTopic;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name.post.comment}", groupId = "${spring.kafka.group.id}")
    public void postCommentListener(KafkaMessage kafkaMessage) {
        CommentMessage commentMessage = (CommentMessage) kafkaMessage;
        log.info(String.format(NEW_COMMENT_PUBLISHED_MESSAGE_RECEIVED_FROM_PROFILE_SERVICE_TEMPLATE,
                commentMessage.getUserIdentity(), kafkaTopic));

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
}
