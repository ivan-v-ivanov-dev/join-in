package com.joinin.gateway.mapper;

import com.join_in.common_models.ConversationRpGatewayService;
import com.join_in.common_models.ConversationRpMessageService;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConversationMapper {
    ConversationRpGatewayService fromConversationRpMessageServicetoConversationRpGatewayService(ConversationRpMessageService conversationRpMessageService);
}
