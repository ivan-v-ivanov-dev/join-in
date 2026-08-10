package com.joinin.message.service;

import com.join_in.common_models.ConversationRpMessageService;
import com.join_in.common_models.ProfileImageRpMediaService;
import com.join_in.common_models.ProfileRpProfileNamesProfileService;
import com.joinin.message.mapper.ConversationsMapper;
import com.joinin.message.model.ChatMessage;
import com.joinin.message.model.MessageByConversation;
import com.joinin.message.repository.ChatMessageRepository;
import com.joinin.message.repository.ConversationRepository;
import com.joinin.message.service.contract.MessageService;
import com.joinin.message.service.feign.MediaServiceClient;
import com.joinin.message.service.feign.ProfileServiceClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class MessageServiceImpl implements MessageService {

    private final ChatMessageRepository chatMessageRepository;
    private final ConversationRepository conversationRepository;
    private final MediaServiceClient mediaServiceClient;
    private final ProfileServiceClient profileServiceClient;
    private final ConversationsMapper conversationsMapper;

    @Override
    public List<ConversationRpMessageService> retrieveConversations(String identity) {
        List<MessageByConversation> conversations = conversationRepository.findConversationsByUserId(identity);
        log.info("Retrieve conversations for profile: " + identity);
        List<String> profileIdentities = conversations.stream().map(MessageByConversation::getParticipantId).toList();
        List<ProfileImageRpMediaService> profileImages = mediaServiceClient.retrieveProfileImagesForProfiles(profileIdentities);
        log.info("Retrieve profile images from Media service for profiles: " + String.join(", ", profileIdentities));
        List<ProfileRpProfileNamesProfileService> profileNames = profileServiceClient.retrieveProfilesNames(profileIdentities);
        log.info("Retrieve profile names from Profile service for profiles: " + String.join(", ", profileIdentities));
        return conversations
                .stream()
                .map(e -> conversationsMapper.fromMessageByConversationtoConversationRpMessageService(e, profileImages, profileNames))
                .toList();
    }

    @Override
    public List<ChatMessage> retrieveConversationMessages(String identity) {
        List<ChatMessage> chatMessages = chatMessageRepository.retrieveConversationMessages(identity);
        log.info("Retrieve conversation messages for conversation: " + identity);
        return chatMessages;
    }
}
