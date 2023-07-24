package com.social.profile.service;

import com.social.kafka.messages.DeletePostMessage;
import com.social.kafka.messages.EditPostMessage;
import com.social.kafka.messages.PostMessage;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.profile.model.Profile;
import com.social.profile.model.dto.EditPostDto;
import com.social.profile.repository.contract.ProfileRepository;
import com.social.profile.service.contracts.KafkaMessageSender;
import com.social.profile.service.contracts.PostService;
import com.social.profile.service.feign.ImageClient;
import com.social.profile.service.feign.PostClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static com.social.profile.service.constants.LoggerConstants.*;
import static com.social.profile.service.constants.ServiceConstants.AUTHOR_NAME_TEMPLATE;

@Service
@Slf4j
public class PostServiceImpl implements PostService {

    private final KafkaMessageSender kafkaMessageSender;
    private final PostClient postClient;
    private final ImageClient imageClient;
    private final ProfileRepository profileRepository;
    private final String postPublicationTopic;
    private final String deletePostTopic;
    private final String editPostTopic;

    public PostServiceImpl(KafkaMessageSender kafkaMessageSender,
                           PostClient postClient,
                           ImageClient imageClient,
                           ProfileRepository profileRepository,
                           @Value("${spring.kafka.topic.name.post.publication}") String postPublicationTopic,
                           @Value("${spring.kafka.topic.name.delete.post}") String deletePostTopic,
                           @Value("${spring.kafka.topic.name.edit.post}") String editPostTopic) {
        this.kafkaMessageSender = kafkaMessageSender;
        this.postClient = postClient;
        this.imageClient = imageClient;
        this.profileRepository = profileRepository;
        this.postPublicationTopic = postPublicationTopic;
        this.deletePostTopic = deletePostTopic;
        this.editPostTopic = editPostTopic;
    }

    @Override
    public EditPostDto findByIdentity(String postIdentity, String authorIdentity) {
        EditPostDto post = postClient.findByPostIdentity(postIdentity, authorIdentity);
        Profile profile = profileRepository.findByIdentity(authorIdentity);
        post.setAuthor(String.format(AUTHOR_NAME_TEMPLATE, profile.getFirstName(), profile.getLastName()));
        post.setAuthorPhoto(imageClient.findProfileImage(authorIdentity));
        return post;
    }

    @Override
    public void post(String userIdentity, String content) {
        KafkaMessage postPublicationMessage = PostMessage.builder()
                .userIdentity(userIdentity)
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
}
