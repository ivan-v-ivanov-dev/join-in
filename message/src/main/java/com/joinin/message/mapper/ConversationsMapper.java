package com.joinin.message.mapper;

import com.join_in.common_models.ConversationRpMessageService;
import com.join_in.common_models.ProfileImageRpMediaService;
import com.join_in.common_models.ProfileRpProfileNamesProfileService;
import com.joinin.message.model.MessageByConversation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConversationsMapper {

    public ConversationRpMessageService fromMessageByConversationtoConversationRpMessageService(
            MessageByConversation messageByConversation,
            List<ProfileImageRpMediaService> profileImages,
            List<ProfileRpProfileNamesProfileService> profileNames) {

        String profileImage = profileImages
                .stream()
                .filter(e -> e.identity().equals(messageByConversation.getKey().getUserId()))
                .map(ProfileImageRpMediaService::profileImage)
                .findFirst()
                .orElse("No profile image");

        String names = profileNames
                .stream()
                .filter(e -> e.identity().equals(messageByConversation.getKey().getUserId()))
                .map(e -> String.format("%s %s", e.firstName(), e.lastName()))
                .findFirst()
                .orElse("No profile names");

        return new ConversationRpMessageService(
                messageByConversation.getKey().getUserId(),
                names,
                profileImage,
                messageByConversation.getKey().getLastMessageAt(),
                messageByConversation.getKey().getConversationId(),
                messageByConversation.getParticipantId());
    }
}
