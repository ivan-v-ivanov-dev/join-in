package com.social.image.service;

import com.social.image.service.contract.ImageService;
import com.social.kafka.messages.NewUserMessage;
import com.social.kafka.messages.contract.KafkaMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.social.image.service.constants.LoggerConstants.NEW_USER_MESSAGE_RECEIVED_FROM_AUTHENTICATION_SERVICE_TEMPLATE;

@Service
@Slf4j
public class ImageListener {

    private final ImageService imageService;
    private final String newUserTopic;

    public ImageListener(ImageService imageService,
                         @Value("${spring.kafka.topic.name.new.user}") String newUserTopic) {
        this.imageService = imageService;
        this.newUserTopic = newUserTopic;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name.new.user}", groupId = "${spring.kafka.group.id}")
    public void listener(KafkaMessage kafkaMessage) {
        NewUserMessage newUserMessage = (NewUserMessage) kafkaMessage;
        log.info(String.format(NEW_USER_MESSAGE_RECEIVED_FROM_AUTHENTICATION_SERVICE_TEMPLATE,
                newUserTopic, newUserMessage.getIdentity()));

        imageService.createCollection(newUserMessage.getIdentity());
    }
}
