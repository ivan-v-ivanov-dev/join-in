package com.social.profile.service;

import com.social.kafka.messages.CommentMessage;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.profile.repository.contract.ProfileRepository;
import com.social.profile.service.contracts.CommentService;
import com.social.profile.service.contracts.KafkaMessageSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static com.social.profile.service.constants.LoggerConstants.NEW_COMMENT_CREATED_AND_SEND_TO_POST_SERVICE_TOPIC_NAME_USER_IDENTITY_TEMPLATE;
import static com.social.profile.service.constants.ServiceConstants.AUTHOR_NAME_TEMPLATE;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    private final ProfileRepository profileRepository;
    private final KafkaMessageSender kafkaMessageSender;
    private final String postCommentTopic;

    public CommentServiceImpl(ProfileRepository profileRepository,
                              KafkaMessageSender kafkaMessageSender,
                              @Value("${spring.kafka.topic.name.post.comment}") String topicName) {
        this.profileRepository = profileRepository;
        this.kafkaMessageSender = kafkaMessageSender;
        this.postCommentTopic = topicName;
    }

    @Override
    public void comment(String commentAuthorIdentity, String postIdentity, String postAuthorIdentity, String comment) {
        KafkaMessage createNewCommentMessage = CommentMessage.builder()
                .postIdentity(postIdentity)
                .postAuthorIdentity(postAuthorIdentity)
                .commentAuthorIdentity(commentAuthorIdentity)
                .commentAuthorNames(String.format(AUTHOR_NAME_TEMPLATE,
                        profileRepository.findProfileFirstName(commentAuthorIdentity),
                        profileRepository.findProfileLastName(commentAuthorIdentity)))
                .content(comment)
                .postDate(LocalDate.now().toString())
                .build();

        kafkaMessageSender.send(createNewCommentMessage, postCommentTopic);
        log.info(String.format(NEW_COMMENT_CREATED_AND_SEND_TO_POST_SERVICE_TOPIC_NAME_USER_IDENTITY_TEMPLATE,
                postCommentTopic, commentAuthorIdentity));
    }
}
