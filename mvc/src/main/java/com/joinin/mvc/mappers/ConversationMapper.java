package com.joinin.mvc.mappers;

import com.join_in.common_models.ConversationRpGatewayService;
import com.joinin.mvc.model.Conversation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConversationMapper {

    Conversation fromConversationRpGatewayServicetoConversation(ConversationRpGatewayService conversationRpGatewayService);
}
